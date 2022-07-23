package org.fintecy.md.coinbase;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.failsafe.Policy;
import org.fintecy.md.coinbase.model.*;
import org.fintecy.md.coinbase.model.dto.AccountsResponse;
import org.fintecy.md.coinbase.model.dto.CurrenciesResponse;
import org.fintecy.md.coinbase.model.dto.ProductsResponse;
import org.fintecy.md.coinbase.model.secure.Account;
import org.fintecy.md.coinbase.security.CoinbaseAuthHeaderGenerator;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static java.net.URI.create;
import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static java.util.Optional.ofNullable;

public class CoinbaseClient implements CoinbaseApi {
    private final String rootPath;
    private final HttpClient client;
    private final ObjectMapper mapper;
    private final List<Policy<Object>> policies;
    private final CoinbaseAuthHeaderGenerator headerGenerator;

    protected CoinbaseClient(String rootPath, CoinbaseAuthConfig authConfig, ObjectMapper mapper, HttpClient httpClient, List<Policy<Object>> policies) {
        this.client = checkRequired(httpClient, "Http client required for Coinbase client");
        this.mapper = checkRequired(mapper, "object mapper is required for serialization");
        this.rootPath = checkRequired(rootPath, "root path cannot be empty");
        this.policies = ofNullable(policies).orElse(List.of());
        this.headerGenerator = new CoinbaseAuthHeaderGenerator(authConfig.getKey(), authConfig.getPassphrase(), authConfig.getSecret());
    }

    public static CoinbaseApi api() {
        return new CoinbaseClientBuilder().build();
    }

    public static CoinbaseClientBuilder coinbaseClient() {
        return new CoinbaseClientBuilder();
    }

    public static double checkRequired(double v, String msg) {
        return (v == 0 ? Optional.<Double>empty() : Optional.of(v))
                .orElseThrow(() -> new IllegalArgumentException(msg));
    }

    public static <T> T checkRequired(T v, String msg) {
        return ofNullable(v)
                .orElseThrow(() -> new IllegalArgumentException(msg));
    }

    @Override
    public CompletableFuture<ExchangeRate> latest(ProductCode productCode) {
        var httpRequest = HttpRequest.newBuilder()
                .uri(create(rootPath + "/products/" + productCode.getCode() + "/ticker"))
                .build();

        return client.sendAsync(httpRequest, ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseResponse(body, ExchangeRate.class))
                .thenApply(exchangeRate -> exchangeRate.forProduct(productCode));
    }

    @Override
    public CompletableFuture<ProductStats> stats(ProductCode productCode) {
        var httpRequest = HttpRequest.newBuilder()
                .uri(create(rootPath + "/products/" + productCode.getCode() + "/stats"))
                .build();

        return client.sendAsync(httpRequest, ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseResponse(body, ProductStats.class));
    }

    @Override
    public CompletableFuture<List<Candle>> candles(ProductCode productCode, long granularity, long start) {
        var httpRequest = HttpRequest.newBuilder()
                .uri(create(rootPath + "/products/" + productCode.getCode() + "/candles?granularity=" + granularity + "&start=" + start))
                .build();

        return client.sendAsync(httpRequest, ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseResponse(body, CandlesResponse.class))
                .thenApply(MicroType::getValue);
    }

    @Override
    public CompletableFuture<OrderBook> orderBook(ProductCode productCode, OrderBookDepth level) {
        var httpRequest = HttpRequest.newBuilder()
                .uri(create(rootPath + "/products/" + productCode.getCode() + "/book?level=" + level.getLevel()))
                .build();

        return client.sendAsync(httpRequest, ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseResponse(body, OrderBook.class));
    }

    @Override
    public CompletableFuture<Product> product(String productId) {
        var httpRequest = HttpRequest.newBuilder()
                .uri(create(rootPath + "/products/" + productId))
                .build();

        return client.sendAsync(httpRequest, ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseResponse(body, Product.class));
    }

    @Override
    public CompletableFuture<List<Product>> products() {
        var httpRequest = HttpRequest.newBuilder()
                .uri(create(rootPath + "/products"))
                .build();

        return client.sendAsync(httpRequest, ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseResponse(body, ProductsResponse.class))
                .thenApply(MicroType::getValue);
    }

    @Override
    public CompletableFuture<List<Currency>> currencies() {
        var httpRequest = HttpRequest.newBuilder()
                .uri(create(rootPath + "/currencies"))
                .build();

        return client.sendAsync(httpRequest, ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseResponse(body, CurrenciesResponse.class))
                .thenApply(MicroType::getValue);
    }

    @Override
    public CompletableFuture<List<Account>> accounts() {
        try {
            var method = "GET";
            var path = "/accounts";
            var payload = "";
            HttpRequest.Builder uriBuilder = HttpRequest.newBuilder()
                    .uri(create(rootPath + path));
            headerGenerator.generateHeaders(create(path), method, payload)
                    .forEach(uriBuilder::header);

            var httpRequest = uriBuilder.build();
            HttpResponse<String> send = client.send(httpRequest, ofString());
            return client.sendAsync(httpRequest, ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(body -> parseResponse(body, AccountsResponse.class))
                    .thenApply(MicroType::getValue);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }


    private <T> T parseResponse(String body, Class<T> tClass) {
        try {
            return mapper.readValue(body, tClass);
        } catch (IOException e) {
            throw new IllegalStateException("Can parse response", e);
        }
    }
}

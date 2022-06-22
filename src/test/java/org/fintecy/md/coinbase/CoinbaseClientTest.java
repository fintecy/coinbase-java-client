package org.fintecy.md.coinbase;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.fintecy.md.coinbase.model.CurrencyCode;
import org.fintecy.md.coinbase.model.ExchangeRate;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.fintecy.md.coinbase.CoinbaseClient.coinbaseClient;
import static org.fintecy.md.coinbase.model.Currency.currency;
import static org.fintecy.md.coinbase.model.Product.product;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest(httpPort = 7777)
class CoinbaseClientTest {
    @Test
    void should_return_latest() throws ExecutionException, InterruptedException {
        CurrencyCode base = CurrencyCode.currency("BTC");
        CurrencyCode counter = CurrencyCode.currency("USD");
        String productCode = base.getCode() + "-" + counter.getCode();
        stubFor(get("/products/" + productCode + "/ticker")
                .willReturn(aResponse()
                        .withBodyFile("ticker.json")));

        var expected = new ExchangeRate(base, counter, Instant.parse("2022-07-03T16:30:20.006304Z"),
                new BigDecimal("19074.1"), new BigDecimal("19073.25"), new BigDecimal("19073.42"),
                369511316, new BigDecimal("9344.18227153"), new BigDecimal("0.07601607"));
        var actual = coinbaseClient()
                .rootPath("http://localhost:7777")
                .build()
                .latest(productCode)
                .get();
        assertEquals(expected, actual);
    }

    @Test
    void should_return_product() throws ExecutionException, InterruptedException {
        var expected = product("BTC-USD", "BTC", "USD", "online");

        stubFor(get("/products/" + expected.getId())
                .willReturn(aResponse()
                        .withBodyFile("product.json")));

        var actual = coinbaseClient()
                .rootPath("http://localhost:7777")
                .build()
                .product(expected.getId())
                .get();
        assertEquals(expected, actual);
    }

    @Test
    void should_return_products() throws ExecutionException, InterruptedException {
        stubFor(get("/products")
                .willReturn(aResponse()
                        .withBodyFile("products.json")));
        var expected = List.of(
                product("BTC-USD", "BTC", "USD", "online"),
                product("ETH-USD", "ETH", "USD", "online")
        );

        var actual = coinbaseClient()
                .rootPath("http://localhost:7777")
                .build()
                .products()
                .get();
        assertEquals(expected, actual);
    }

    @Test
    void should_return_currencies() throws ExecutionException, InterruptedException {
        stubFor(get("/currencies")
                .willReturn(aResponse()
                        .withBodyFile("currencies.json")));
        var expected = List.of(
                currency("GBP", "British Pound", "online"),
                currency("ETH", "Ether", "online"));
        var actual = coinbaseClient()
                .rootPath("http://localhost:7777")
                .build()
                .currencies()
                .get();
        assertEquals(expected, actual);
    }
}

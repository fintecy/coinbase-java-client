package org.fintecy.md.coinbase;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.fintecy.md.coinbase.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.math.BigDecimal.valueOf;
import static java.time.Instant.ofEpochMilli;
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
    void should_return_candles() throws ExecutionException, InterruptedException {
        var product = ProductCode.product("BTC-USD");
        var expected = List.of(
                new Candle(ofEpochMilli(1656806400L),
                        valueOf(18755.75),
                        valueOf(19363.41),
                        valueOf(19225.54),
                        valueOf(19059.2),
                        valueOf(6963.36840192)),
                new Candle(ofEpochMilli(1656720000L),
                        valueOf(18955.02),
                        valueOf(19422.02),
                        valueOf(19252.76),
                        valueOf(19224.03),
                        valueOf(10707.74160684)),
                new Candle(ofEpochMilli(1656633600L),
                        valueOf(18938.33),
                        valueOf(20879.99),
                        valueOf(19985.62),
                        valueOf(19252.76),
                        valueOf(32977.00052272))
        );
        long granularity = 86400;
        long start = 1554214400;
        stubFor(get("/products/" + product.getCode() + "/candles?granularity=" + granularity + "&start=" + start)
                .willReturn(aResponse()
                        .withBodyFile("candles.json")));

        var actual = coinbaseClient()
                .rootPath("http://localhost:7777")
                .build()
                .candles(product, granularity, start)
                .get();
        assertEquals(expected, actual);
    }

    @Test
    void should_return_order_book() throws ExecutionException, InterruptedException {
        var product = "BTC-USD";
        var expected = new OrderBook(
                List.of(new PriceLevel(new BigDecimal("19116.36"), new BigDecimal("0.025"), 1)),
                List.of(new PriceLevel(new BigDecimal("19116.99"), new BigDecimal("0.01164987"), 1)),
                39788471776L, false, null);

        stubFor(get("/products/" + product + "/book?level=1")
                .willReturn(aResponse()
                        .withBodyFile("book.json")));

        var actual = coinbaseClient()
                .rootPath("http://localhost:7777")
                .build()
                .orderBook(product)
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

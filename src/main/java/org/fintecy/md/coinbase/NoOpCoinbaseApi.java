package org.fintecy.md.coinbase;

import org.fintecy.md.coinbase.model.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.fintecy.md.coinbase.model.Currency.currency;

/**
 * Available for testing purposes
 */
public class NoOpCoinbaseApi implements CoinbaseApi {
    public static final List<Currency> SUPPORTED_CURRENCIES = List.of(
            currency("GBP"), currency("EUR"), currency("USD"),
            currency("BTC"), currency("ETH"), currency("BCH")
    );

    @Override
    public CompletableFuture<ExchangeRate> latest(ProductCode productCode) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public CompletableFuture<ProductStats> stats(ProductCode productCode) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public CompletableFuture<List<Candle>> candles(ProductCode productCode, long granularity, long start) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public CompletableFuture<OrderBook> orderBook(ProductCode productCode, OrderBookDepth level) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public CompletableFuture<Product> product(String productId) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public CompletableFuture<List<Product>> products() {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public CompletableFuture<List<Currency>> currencies() {
        return CompletableFuture.completedFuture(SUPPORTED_CURRENCIES);
    }
}
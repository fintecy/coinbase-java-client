package org.fintecy.md.coinbase;

import org.fintecy.md.coinbase.model.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.fintecy.md.coinbase.model.OrderBookDepth.LEVEL_1;

/**
 * @author batiaev
 * @see <a href="https://docs.cloud.coinbase.com/exchange/reference/">docs</a>
 */
public interface CoinbaseApi {
    String ROOT_PATH = "https://api.exchange.coinbase.com/";

    /**
     * @param productId - product is e.g. BTC-USD
     * @return exchange rate
     * @see <a href="https://api.exchange.coinbase.com/products/BTC-USD/ticker">test request</a>
     */
    default CompletableFuture<ExchangeRate> latest(String productId) {
        return latest(ProductCode.product(productId));
    }

    CompletableFuture<ExchangeRate> latest(ProductCode productId);

    /**
     * Return candlestick chart
     * @param productCode - product code e.g. BTC-USD
     * @param granularity
     * @param start
     * @return candlesticks chart
     * @see <a href="https://api.exchange.coinbase.com/products/BTC-USD/candles?granularity=86400&start=1554214400">test request</a>
     */
    CompletableFuture<List<Candle>> candles(ProductCode productCode, long granularity, long start);

    /**
     * Return product order book on required level of granularity
     * @param productCode - product code e.g. BTC-USD
     * @param level - granularity can be 1, 2 or 3
     * @return order book
     * @see <a href="https://api.exchange.coinbase.com/products/btc-usd/book?level=2">test request</a>
     */
    CompletableFuture<OrderBook> orderBook(ProductCode productCode, OrderBookDepth level);

    default CompletableFuture<OrderBook> orderBook(String productCode) {
        return orderBook(ProductCode.product(productCode), LEVEL_1);
    }

    /**
     * @param productId - product id e.g. BTC-USD
     * @return product details
     * @see <a href="https://api.exchange.coinbase.com/products/btc-usd">test request</a>
     */
    CompletableFuture<Product> product(String productId);

    /**
     * @return list of supported products
     * @see <a href="https://api.exchange.coinbase.com/products">test request</a>
     */
    CompletableFuture<List<Product>> products();

    /**
     * @return list of supported currencies
     * @see <a href="https://api.exchange.coinbase.com/currencies">test request</a>
     */
    CompletableFuture<List<Currency>> currencies();
}

package org.fintecy.md.coinbase;

import org.fintecy.md.coinbase.model.Currency;
import org.fintecy.md.coinbase.model.ExchangeRate;
import org.fintecy.md.coinbase.model.Product;
import org.fintecy.md.coinbase.model.ProductCode;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
     * @return product details
     * @param productId - product id e.g. BTC-USD
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

package org.fintecy.md.coinbase;

import org.fintecy.md.coinbase.rest.CoinbaseApi;
import org.fintecy.md.coinbase.rest.NoOpCoinbaseApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.fintecy.md.coinbase.rest.NoOpCoinbaseApi.SUPPORTED_CURRENCIES;
import static org.junit.jupiter.api.Assertions.*;

class NoOpCoinbaseApiTest {
    private CoinbaseApi noOpCoinbaseApi;

    @BeforeEach
    void setUp() {
        noOpCoinbaseApi = new NoOpCoinbaseApi();
    }

    @Test
    void should_throw_exception_for_balances() {
        assertTrue(noOpCoinbaseApi.balances().isCompletedExceptionally());
    }

    @Test
    void should_throw_exception_for_coinbase_accounts() {
        assertThrows(IllegalStateException.class, () -> noOpCoinbaseApi.coinbaseAccounts().get());
    }

    @Test
    void should_throw_exception_for_accounts() {
        assertThrows(IllegalStateException.class, () -> noOpCoinbaseApi.accounts().get());
    }

    @Test
    void should_throw_exception_for_products() {
        assertThrows(IllegalStateException.class, () -> noOpCoinbaseApi.products().get());
    }

    @Test
    void should_throw_exception_for_product() {
        assertThrows(IllegalStateException.class, () -> noOpCoinbaseApi.product("USD/GBP").get());
    }

    @Test
    void should_throw_exception_for_latest() {
        assertThrows(IllegalStateException.class, () -> noOpCoinbaseApi.latest("USD/GBP").get());
    }

    @Test
    void should_throw_exception_for_currencies() throws ExecutionException, InterruptedException {
        var currencies = noOpCoinbaseApi.currencies().get();
        assertEquals(currencies, SUPPORTED_CURRENCIES);
    }
}

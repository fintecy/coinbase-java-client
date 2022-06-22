package org.fintecy.md.coinbase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.fintecy.md.coinbase.NoOpCoinbaseApi.SUPPORTED_CURRENCIES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NoOpCoinbaseApiTest {
    private CoinbaseApi noOpCoinbaseApi;

    @BeforeEach
    void setUp() {
        noOpCoinbaseApi = new NoOpCoinbaseApi();
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

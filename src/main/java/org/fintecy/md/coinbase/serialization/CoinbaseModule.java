package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.InstantKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer;
import org.fintecy.md.coinbase.model.*;
import org.fintecy.md.coinbase.model.dto.CurrenciesResponse;
import org.fintecy.md.coinbase.model.dto.ProductsResponse;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

public class CoinbaseModule extends SimpleModule {
    public static final String GROUP_ID = "org.fintecy.md";
    public static final String ARTIFACT_ID = "coinbase-client";
    public static final Version VERSION = new Version(1, 0, 2, "SNAPSHOT",
            GROUP_ID, ARTIFACT_ID);

    public CoinbaseModule() {
        super(CoinbaseModule.class.getSimpleName(), VERSION, Map.of(
                Instant.class, InstantDeserializer.INSTANT,
                LocalDate.class, LocalDateDeserializer.INSTANCE));

        addDeserializer(ProductStats.class, ProductStatsDeserializer.INSTANCE);
        addDeserializer(OrderBook.class, OrderBookDeserializer.INSTANCE);
        addDeserializer(ExchangeRate.class, ExchangeRateDeserializer.INSTANCE);
        addDeserializer(Candle.class, CandleDeserializer.INSTANCE);
        addDeserializer(Currency.class, CurrencyDeserializer.INSTANCE);
        addDeserializer(Product.class, ProductDeserializer.INSTANCE);

        addDeserializer(CandlesResponse.class, CandlesResponseDeserializer.INSTANCE);
        addDeserializer(CurrenciesResponse.class, CurrenciesResponseDeserializer.INSTANCE);
        addDeserializer(ProductsResponse.class, ProductsResponseDeserializer.INSTANCE);

        addKeyDeserializer(LocalDate.class, LocalDateKeyDeserializer.INSTANCE);
        addKeyDeserializer(Instant.class, InstantKeyDeserializer.INSTANCE);
    }
}

package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.InstantKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer;
import org.fintecy.md.coinbase.model.Currency;
import org.fintecy.md.coinbase.model.ExchangeRate;
import org.fintecy.md.coinbase.model.Product;
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
        super(CoinbaseModule.class.getSimpleName(), VERSION,
                Map.of(
                        ExchangeRate.class, ExchangeRateDeserializer.INSTANCE,
                        Currency.class, CurrencyDeserializer.INSTANCE,
                        Product.class, ProductDeserializer.INSTANCE,
                        CurrenciesResponse.class, CurrenciesResponseDeserializer.INSTANCE,
                        ProductsResponse.class, ProductsResponseDeserializer.INSTANCE,
                        Instant.class, InstantDeserializer.INSTANT,
                        LocalDate.class, LocalDateDeserializer.INSTANCE));

        addKeyDeserializer(LocalDate.class, LocalDateKeyDeserializer.INSTANCE);
        addKeyDeserializer(Instant.class, InstantKeyDeserializer.INSTANCE);
    }
}

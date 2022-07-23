package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.currencies.CurrencyCode;
import org.fintecy.md.coinbase.model.ExchangeRate;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

public class ExchangeRateDeserializer extends StdDeserializer<ExchangeRate> {
    public final static ExchangeRateDeserializer INSTANCE = new ExchangeRateDeserializer();
    public static final Set<String> REQUIRED_FIELDS = Set.of("ask", "bid", "price", "time");

    public ExchangeRateDeserializer() {
        super(ExchangeRate.class);
    }

    public static ExchangeRate parse(JsonParser jp, JsonNode node) {
        for (String field : REQUIRED_FIELDS) {
            if (!node.has(field)) throw new IllegalStateException("Required field " + field + " is missing");
        }

        var ask = new BigDecimal(node.get("ask").asText());
        var bid = new BigDecimal(node.get("bid").asText());
        var mid = new BigDecimal(node.get("price").asText());
        return new ExchangeRate(
                CurrencyCode.currency("USD"),CurrencyCode.currency("USD"),
                Instant.parse(node.get("time").asText()),
                ask,
                mid,
                bid,
                node.get("trade_id").asLong(),
                new BigDecimal(node.get("volume").asText()),
                new BigDecimal(node.get("size").asText())
        );
    }

    @Override
    public ExchangeRate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}

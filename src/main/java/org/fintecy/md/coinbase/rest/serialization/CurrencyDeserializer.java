package org.fintecy.md.coinbase.rest.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.currencies.Currency;
import org.fintecy.md.coinbase.model.ExchangeRate;

import java.io.IOException;
import java.util.Set;

public class CurrencyDeserializer extends StdDeserializer<Currency> {
    public final static CurrencyDeserializer INSTANCE = new CurrencyDeserializer();
    public static final Set<String> REQUIRED_FIELDS = Set.of("id", "name", "status");

    public CurrencyDeserializer() {
        super(ExchangeRate.class);
    }

    public static Currency parse(JsonParser jp, JsonNode node) {
        for (String field : REQUIRED_FIELDS) {
            if (!node.has(field)) throw new IllegalStateException("Required field " + field + " is missing");
        }

        return Currency.currency(
                node.get("id").asText(),
                node.get("name").asText(),
                node.get("status").asText()
        );
    }

    @Override
    public Currency deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}

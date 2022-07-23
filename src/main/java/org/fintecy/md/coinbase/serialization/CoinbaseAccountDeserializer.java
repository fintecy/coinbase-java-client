package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.CurrencyCode;
import org.fintecy.md.coinbase.model.accounts.Account;
import org.fintecy.md.coinbase.model.accounts.CoinbaseAccount;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public class CoinbaseAccountDeserializer extends StdDeserializer<CoinbaseAccount> {
    public final static CoinbaseAccountDeserializer INSTANCE = new CoinbaseAccountDeserializer();
    public static final Set<String> REQUIRED_FIELDS = Set.of("available_on_consumer", "hold_balance", "id",
            "hold_currency", "balance", "currency", "primary", "name", "type", "active"
    );

    public CoinbaseAccountDeserializer() {
        super(CoinbaseAccount.class);
    }

    public static CoinbaseAccount parse(JsonParser jp, JsonNode node) {
        for (String field : REQUIRED_FIELDS) {
            if (!node.has(field)) throw new IllegalStateException("Required field " + field + " is missing");
        }

        return new CoinbaseAccount(
                node.get("available_on_consumer").asBoolean(),
                new BigDecimal(node.get("hold_balance").asText()),
                node.get("id").asText(),
                CurrencyCode.currency(node.get("hold_currency").asText()),
                new BigDecimal(node.get("balance").asText()),
                CurrencyCode.currency(node.get("currency").asText()),
                node.get("primary").asBoolean(),
                node.get("name").asText(),
                node.get("type").asText(),
                node.get("active").asBoolean()
        );
    }

    @Override
    public CoinbaseAccount deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}

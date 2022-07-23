package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.CurrencyCode;
import org.fintecy.md.coinbase.model.secure.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public class AccountDeserializer extends StdDeserializer<Account> {
    public final static AccountDeserializer INSTANCE = new AccountDeserializer();
    public static final Set<String> REQUIRED_FIELDS = Set.of("id", "currency", "balance", "hold", "available", "profile_id", "trading_enabled");

    public AccountDeserializer() {
        super(Account.class);
    }

    public static Account parse(JsonParser jp, JsonNode node) {
        for (String field : REQUIRED_FIELDS) {
            if (!node.has(field)) throw new IllegalStateException("Required field " + field + " is missing");
        }

        return new Account(
                UUID.fromString(node.get("id").asText()),
                CurrencyCode.currency(node.get("currency").asText()),
                new BigDecimal(node.get("balance").asText()),
                new BigDecimal(node.get("hold").asText()),
                new BigDecimal(node.get("available").asText()),
                UUID.fromString(node.get("profile_id").asText()),
                node.get("trading_enabled").asBoolean()
        );
    }

    @Override
    public Account deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}

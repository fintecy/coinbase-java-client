package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.products.ProductStats;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

import static java.time.temporal.ChronoUnit.SECONDS;

public class ProductStatsDeserializer extends StdDeserializer<ProductStats> {
    public final static ProductStatsDeserializer INSTANCE = new ProductStatsDeserializer();
    public static final Set<String> REQUIRED_FIELDS = Set.of("low", "high", "open", "last", "volume", "volume_30day");

    public ProductStatsDeserializer() {
        super(ProductStats.class);
    }

    public static ProductStats parse(JsonParser jp, JsonNode node) {
        for (String field : REQUIRED_FIELDS) {
            if (!node.has(field)) throw new IllegalStateException("Required field " + field + " is missing");
        }

        return new ProductStats(
                Instant.now().truncatedTo(SECONDS),
                new BigDecimal(node.get("low").asText()),
                new BigDecimal(node.get("high").asText()),
                new BigDecimal(node.get("open").asText()),
                new BigDecimal(node.get("last").asText()),
                new BigDecimal(node.get("volume").asText()),
                new BigDecimal(node.get("volume_30day").asText()));
    }

    @Override
    public ProductStats deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}

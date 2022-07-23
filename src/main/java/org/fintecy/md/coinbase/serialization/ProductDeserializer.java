package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.ExchangeRate;
import org.fintecy.md.coinbase.model.products.Product;

import java.io.IOException;
import java.util.Set;

import static org.fintecy.md.coinbase.model.products.Product.product;

public class ProductDeserializer extends StdDeserializer<Product> {
    public final static ProductDeserializer INSTANCE = new ProductDeserializer();
    public static final Set<String> REQUIRED_FIELDS = Set.of("id", "base_currency", "quote_currency", "status");

    public ProductDeserializer() {
        super(ExchangeRate.class);
    }

    public static Product parse(JsonParser jp, JsonNode node) {
        for (String field : REQUIRED_FIELDS) {
            if (!node.has(field)) throw new IllegalStateException("Required field '" + field + "' is missing");
        }

        return product(
                node.get("id").asText(),
                node.get("base_currency").asText(),
                node.get("quote_currency").asText(),
                node.get("status").asText()
        );
    }

    @Override
    public Product deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}

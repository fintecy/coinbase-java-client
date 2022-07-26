package org.fintecy.md.coinbase.rest.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.products.Candle;
import org.fintecy.md.coinbase.model.ExchangeRate;

import java.io.IOException;

import static java.math.BigDecimal.valueOf;
import static java.time.Instant.ofEpochMilli;

public class CandleDeserializer extends StdDeserializer<Candle> {
    public final static CandleDeserializer INSTANCE = new CandleDeserializer();

    public CandleDeserializer() {
        super(ExchangeRate.class);
    }

    public static Candle parse(JsonParser jp, JsonNode node) {
        if (node.size() != 6)
            throw new IllegalStateException("Array should have 5 elements: ts, low, high, open, close, volume, but has " + node.size());
        return new Candle(
                ofEpochMilli(node.get(0).asLong()),
                valueOf(node.get(1).asDouble()),
                valueOf(node.get(2).asDouble()),
                valueOf(node.get(3).asDouble()),
                valueOf(node.get(4).asDouble()),
                valueOf(node.get(5).asDouble()));
    }

    @Override
    public Candle deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}

package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.OrderBook;
import org.fintecy.md.coinbase.model.PriceLevel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderBookDeserializer extends StdDeserializer<OrderBook> {
    public final static OrderBookDeserializer INSTANCE = new OrderBookDeserializer();
    public static final Set<String> REQUIRED_FIELDS = Set.of("bids", "asks", "sequence", "auction_mode", "auction");

    public OrderBookDeserializer() {
        super(OrderBook.class);
    }

    public static OrderBook parse(JsonParser jp, JsonNode node) {
        for (String field : REQUIRED_FIELDS) {
            if (!node.has(field)) throw new IllegalStateException("Required field " + field + " is missing");
        }
        return new OrderBook(
                processLevels(node.get("bids")),
                processLevels(node.get("asks")),
                node.get("sequence").asLong(),
                node.get("auction_mode").asBoolean(),
                node.get("auction").isNull() ? null : node.get("auction").asText());
    }

    private static List<PriceLevel> processLevels(JsonNode node) {
        List<PriceLevel> result = new ArrayList<>();
        node.forEach(jsonNode -> {
            BigDecimal price = new BigDecimal(jsonNode.get(0).asText());
            BigDecimal volume = new BigDecimal(jsonNode.get(1).asText());
            long level = jsonNode.get(2).asLong();
            result.add(new PriceLevel(price, volume, level));
        });
        return result;
    }

    @Override
    public OrderBook deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}

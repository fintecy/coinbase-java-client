package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.products.Candle;
import org.fintecy.md.coinbase.model.products.CandlesResponse;
import org.fintecy.md.coinbase.model.ExchangeRate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fintecy.md.coinbase.serialization.CandleDeserializer.parse;

public class CandlesResponseDeserializer extends StdDeserializer<CandlesResponse> {
    public final static CandlesResponseDeserializer INSTANCE = new CandlesResponseDeserializer();

    public CandlesResponseDeserializer() {
        super(ExchangeRate.class);
    }

    @Override
    public CandlesResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);

        List<Candle> candles = new ArrayList<>();
        node.forEach(candleNode ->
                candles.add(parse(jp, candleNode)));
        return new CandlesResponse(candles);
    }
}

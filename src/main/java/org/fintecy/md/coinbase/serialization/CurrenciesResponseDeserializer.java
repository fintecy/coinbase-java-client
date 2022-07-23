package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.currencies.Currency;
import org.fintecy.md.coinbase.model.ExchangeRate;
import org.fintecy.md.coinbase.model.dto.CurrenciesResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fintecy.md.coinbase.serialization.CurrencyDeserializer.parse;

public class CurrenciesResponseDeserializer extends StdDeserializer<CurrenciesResponse> {
    public final static CurrenciesResponseDeserializer INSTANCE = new CurrenciesResponseDeserializer();

    public CurrenciesResponseDeserializer() {
        super(ExchangeRate.class);
    }

    @Override
    public CurrenciesResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);

        List<Currency> currencyList = new ArrayList<>();
        node.forEach(ccyNode ->
                currencyList.add(parse(jp, ccyNode)));
        return new CurrenciesResponse(currencyList);
    }
}

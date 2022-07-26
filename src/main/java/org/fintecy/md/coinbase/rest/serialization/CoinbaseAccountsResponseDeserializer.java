package org.fintecy.md.coinbase.rest.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.accounts.CoinbaseAccount;
import org.fintecy.md.coinbase.model.dto.CoinbaseAccountsResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fintecy.md.coinbase.rest.serialization.CoinbaseAccountDeserializer.parse;

public class CoinbaseAccountsResponseDeserializer extends StdDeserializer<CoinbaseAccountsResponse> {
    public final static CoinbaseAccountsResponseDeserializer INSTANCE = new CoinbaseAccountsResponseDeserializer();

    public CoinbaseAccountsResponseDeserializer() {
        super(CoinbaseAccountsResponse.class);
    }

    @Override
    public CoinbaseAccountsResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);

        List<CoinbaseAccount> data = new ArrayList<>();
        node.forEach(productNode ->
                data.add(parse(jp, productNode)));
        return new CoinbaseAccountsResponse(data);
    }
}

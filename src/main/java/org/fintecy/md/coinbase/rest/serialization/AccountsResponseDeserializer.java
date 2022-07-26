package org.fintecy.md.coinbase.rest.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.dto.AccountsResponse;
import org.fintecy.md.coinbase.model.accounts.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fintecy.md.coinbase.rest.serialization.AccountDeserializer.parse;

public class AccountsResponseDeserializer extends StdDeserializer<AccountsResponse> {
    public final static AccountsResponseDeserializer INSTANCE = new AccountsResponseDeserializer();

    public AccountsResponseDeserializer() {
        super(AccountsResponse.class);
    }

    @Override
    public AccountsResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);

        List<Account> data = new ArrayList<>();
        node.forEach(productNode ->
                data.add(parse(jp, productNode)));
        return new AccountsResponse(data);
    }
}

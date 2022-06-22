package org.fintecy.md.coinbase;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.failsafe.Policy;
import org.fintecy.md.coinbase.serialization.CoinbaseModule;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

class CoinbaseClientBuilder {
    private ObjectMapper mapper = new ObjectMapper().registerModule(new CoinbaseModule());
    private HttpClient client = HttpClient.newHttpClient();
    private List<Policy<Object>> policies = new ArrayList<>();
    private String rootPath = CoinbaseApi.ROOT_PATH;

    public CoinbaseClientBuilder useClient(HttpClient client) {
        this.client = client;
        return this;
    }

    public CoinbaseClientBuilder mapper(ObjectMapper mapper) {
        this.mapper = mapper.registerModule(new CoinbaseModule());
        return this;
    }

    public CoinbaseClientBuilder rootPath(String rootPath) {
        this.rootPath = rootPath;
        return this;
    }

    public CoinbaseClientBuilder with(Policy<Object> policy) {
        this.policies.add(policy);
        return this;
    }

    public CoinbaseApi build() {
        return new CoinbaseClient(rootPath, mapper, client, policies);
    }
}

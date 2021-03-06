package org.fintecy.md.coinbase.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.failsafe.Policy;
import org.fintecy.md.coinbase.rest.serialization.CoinbaseModule;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class CoinbaseClientBuilder {
    private ObjectMapper mapper = new ObjectMapper().registerModule(new CoinbaseModule());
    private HttpClient client = HttpClient.newHttpClient();
    private List<Policy<Object>> policies = new ArrayList<>();
    private String rootPath = CoinbaseApi.ROOT_PATH;
    private CoinbaseAuthConfig authConfig = CoinbaseAuthConfig.EMPTY;

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

    public CoinbaseClientBuilder authConfig(String key, String secret, String passphrase) {
        return authConfig(new CoinbaseAuthConfig(key, secret, passphrase));
    }

    public CoinbaseClientBuilder authConfig(CoinbaseAuthConfig authConfig) {
        this.authConfig = authConfig;
        return this;
    }

    public CoinbaseClientBuilder with(Policy<Object> policy) {
        this.policies.add(policy);
        return this;
    }

    public CoinbaseApi build() {
        return new CoinbaseClient(rootPath, authConfig, mapper, client, policies);
    }
}

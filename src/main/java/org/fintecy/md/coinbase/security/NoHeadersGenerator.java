package org.fintecy.md.coinbase.security;

import java.net.URI;
import java.util.Map;

public class NoHeadersGenerator implements HeaderGenerator {
    @Override
    public Map<String, String> generateHeaders(URI uri, String method, String body) {
        return Map.of();
    }
}

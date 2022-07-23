package org.fintecy.md.coinbase.security;

import java.net.URI;
import java.util.Map;

public interface HeaderGenerator {
    /**
     * Generates a Map of heads to be added into the request.
     * @param uri
     * @param method
     * @param body
     * @return
     */
    Map<String, String> generateHeaders(URI uri, String method, String body);

}

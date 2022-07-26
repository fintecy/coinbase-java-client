package org.fintecy.md.coinbase.rest.security;

import org.fintecy.md.coinbase.rest.exeptions.CoinbaseException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static java.time.ZoneOffset.UTC;

public class CoinbaseAuthHeaderGenerator implements HeaderGenerator {
    public static final String ALGO = "HmacSHA256";
    private static final String API_DATE = "2021-02-05";

    private final String apiKey;
    private final String passphrase;
    private final SecretKeySpec keySpec;

    public CoinbaseAuthHeaderGenerator(String apiKey, String passphrase, String secretKey) {
        this.apiKey = apiKey;
        this.passphrase = passphrase;
        byte[] decode = Base64.getDecoder().decode(secretKey);
        this.keySpec = new SecretKeySpec(decode, ALGO);
    }

    private String generateSign(String timestamp, URI uri, String method, String body) {
        try {
            String uri1 = getURI(uri);
            String sign = timestamp + method.toUpperCase() + uri1 + (body == null ? "" : body);
            Mac mac = Mac.getInstance(ALGO);
            mac.init(keySpec);
            return Base64.getEncoder().encodeToString(mac.doFinal(sign.getBytes()));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new CoinbaseException(e.getMessage(), e);
        }
    }

    private String getURI(URI uri) {
        /*
         * The sign needs the full path, including the query strings but without the host.
         * uri.getPath() does not include the host, but it also does not include the query string.
         * Uri.toString() includes the query string but also includes host.
         * So this logic removes everything before the path from the toString.
         * e.g.
         * uri.toString() = "https://api.coinbase.com/v2/accounts?starting_after=1961d899-xxxx-50d4-9771-xxxxx"
         * uri.getPath() = "/v2/accounts"
         * uriStr.substring(uriStr.indexOf(uri.getPath())) = "/v2/accounts?starting_after=1961d899-xxxx-50d4-9771-xxxxx"
         */
        String uriStr = uri.toString();
        return uriStr.substring(uriStr.indexOf(uri.getPath()));
    }

    @Override
    public Map<String, String> generateHeaders(URI path, String method, String body) {
        Map<String, String> headers = new HashMap<>();
        String timestamp = String.valueOf(Instant.now().atOffset(UTC).toEpochSecond());
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("CB-ACCESS-KEY", apiKey);
        headers.put("CB-ACCESS-PASSPHRASE", passphrase);
        headers.put("CB-ACCESS-TIMESTAMP", timestamp);
        headers.put("CB-VERSION", API_DATE);
        headers.put("CB-ACCESS-SIGN", generateSign(timestamp, path, method, body));
        return headers;
    }
}

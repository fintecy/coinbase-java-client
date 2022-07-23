package org.fintecy.md.coinbase;

import java.util.Objects;

public class CoinbaseAuthConfig {
    public static final CoinbaseAuthConfig EMPTY = new CoinbaseAuthConfig("", "", "");
    ;
    private final String key;
    private final String secret;
    private final String passphrase;

    public CoinbaseAuthConfig(String key, String secret, String passphrase) {
        this.key = key;
        this.secret = secret;
        this.passphrase = passphrase;
    }

    public String getKey() {
        return key;
    }

    public String getSecret() {
        return secret;
    }

    public String getPassphrase() {
        return passphrase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinbaseAuthConfig that = (CoinbaseAuthConfig) o;
        return Objects.equals(key, that.key) && Objects.equals(secret, that.secret) && Objects.equals(passphrase, that.passphrase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, secret, passphrase);
    }

    @Override
    public String toString() {
        return "CoinbaseAuthConfig{key='" + key + '\'' + '}';//secret and passphrase not shown on purpose
    }
}

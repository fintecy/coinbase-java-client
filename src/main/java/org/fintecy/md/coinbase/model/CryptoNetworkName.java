package org.fintecy.md.coinbase.model;

public class CryptoNetworkName extends MicroType<String> {
    public static final CryptoNetworkName ETHEREUM = new CryptoNetworkName("ethereum");

    public CryptoNetworkName(String value) {
        super(value);
    }
}

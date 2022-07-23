package org.fintecy.md.coinbase.model.currencies;

import org.fintecy.md.coinbase.model.MicroType;

public class CryptoNetworkName extends MicroType<String> {
    public static final CryptoNetworkName ETHEREUM = new CryptoNetworkName("ethereum");

    public CryptoNetworkName(String value) {
        super(value);
    }
}

package org.fintecy.md.coinbase.model.currencies;

import org.fintecy.md.coinbase.model.MicroType;

public class CurrencyStatus extends MicroType<String> {
    public static final CurrencyStatus ONLINE = new CurrencyStatus("online");

    public CurrencyStatus(String value) {
        super(value);
    }
}

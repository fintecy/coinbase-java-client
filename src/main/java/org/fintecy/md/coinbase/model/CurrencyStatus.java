package org.fintecy.md.coinbase.model;

public class CurrencyStatus extends MicroType<String> {
    public static final CurrencyStatus ONLINE = new CurrencyStatus("online");

    public CurrencyStatus(String value) {
        super(value);
    }
}

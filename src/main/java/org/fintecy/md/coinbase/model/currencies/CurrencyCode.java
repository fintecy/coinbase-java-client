package org.fintecy.md.coinbase.model.currencies;

import org.fintecy.md.coinbase.model.MicroType;

public class CurrencyCode extends MicroType<String> implements Comparable<CurrencyCode> {
    public CurrencyCode(String value) {
        super(value);
    }

    public static CurrencyCode currency(String code) {
        return new CurrencyCode(code);
    }

    public static CurrencyCode fromJavaCurrency(java.util.Currency currency) {
        return currency(currency.getCurrencyCode());
    }

    public java.util.Currency toJavaCurrency() {
        return java.util.Currency.getInstance(value);
    }

    public String getCode() {
        return value;
    }

    @Override
    public int compareTo(CurrencyCode o) {
        return value.compareTo(o.value);
    }
}

package org.fintecy.md.coinbase.model.dto;

import org.fintecy.md.coinbase.model.currencies.Currency;
import org.fintecy.md.coinbase.model.MicroType;

import java.util.List;

public class CurrenciesResponse extends MicroType<List<Currency>> {

    public CurrenciesResponse(List<Currency> currencies) {
        super(currencies);
    }

    public List<Currency> currencies() {
        return getValue();
    }
}

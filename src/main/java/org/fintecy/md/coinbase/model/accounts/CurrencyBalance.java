package org.fintecy.md.coinbase.model.accounts;

import org.fintecy.md.coinbase.model.currencies.CurrencyCode;

import java.math.BigDecimal;

public interface CurrencyBalance {
    CurrencyCode getCurrency();

    BigDecimal getBalance();
}

package org.fintecy.md.coinbase.model.accounts;

import org.fintecy.md.coinbase.model.CurrencyCode;

import java.math.BigDecimal;

public interface CurrencyBalance {
    CurrencyCode getCurrency();

    BigDecimal getBalance();
}

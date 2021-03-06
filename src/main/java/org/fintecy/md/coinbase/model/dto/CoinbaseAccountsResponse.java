package org.fintecy.md.coinbase.model.dto;

import org.fintecy.md.coinbase.model.accounts.CoinbaseAccount;
import org.fintecy.md.coinbase.model.MicroType;

import java.util.List;

public class CoinbaseAccountsResponse extends MicroType<List<CoinbaseAccount>> {
    public CoinbaseAccountsResponse(List<CoinbaseAccount> value) {
        super(value);
    }
}

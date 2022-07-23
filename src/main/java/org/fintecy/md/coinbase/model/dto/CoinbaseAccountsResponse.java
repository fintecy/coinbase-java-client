package org.fintecy.md.coinbase.model.dto;

import org.fintecy.md.coinbase.model.MicroType;
import org.fintecy.md.coinbase.model.accounts.Account;
import org.fintecy.md.coinbase.model.accounts.CoinbaseAccount;

import java.util.List;

public class CoinbaseAccountsResponse extends MicroType<List<CoinbaseAccount>> {
    public CoinbaseAccountsResponse(List<CoinbaseAccount> value) {
        super(value);
    }
}

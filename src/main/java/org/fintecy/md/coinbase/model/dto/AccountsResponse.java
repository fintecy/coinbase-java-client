package org.fintecy.md.coinbase.model.dto;

import org.fintecy.md.coinbase.model.accounts.Account;
import org.fintecy.md.coinbase.model.MicroType;

import java.util.List;

public class AccountsResponse extends MicroType<List<Account>> {
    public AccountsResponse(List<Account> value) {
        super(value);
    }
}

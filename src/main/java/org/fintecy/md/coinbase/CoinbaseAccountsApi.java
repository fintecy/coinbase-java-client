package org.fintecy.md.coinbase;

import org.fintecy.md.coinbase.model.accounts.Account;
import org.fintecy.md.coinbase.model.accounts.CoinbaseAccount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CoinbaseAccountsApi {
    CompletableFuture<List<Account>> accounts();

    CompletableFuture<List<CoinbaseAccount>> coinbaseAccounts();
}

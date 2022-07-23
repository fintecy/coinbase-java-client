package org.fintecy.md.coinbase;

import org.fintecy.md.coinbase.model.secure.Account;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CoinbaseAccountsApi {
    CompletableFuture<List<Account>> accounts();
}

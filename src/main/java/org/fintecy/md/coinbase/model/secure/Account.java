package org.fintecy.md.coinbase.model.secure;

import org.fintecy.md.coinbase.model.CurrencyCode;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final CurrencyCode currency;
    private final BigDecimal balance;
    private final BigDecimal hold;
    private final BigDecimal available;
    private final UUID profileId;
    private final boolean tradingEnabled;

    public Account(UUID id, CurrencyCode currency, BigDecimal balance, BigDecimal hold, BigDecimal available,
                   UUID profileId, boolean tradingEnabled) {
        this.id = id;
        this.currency = currency;
        this.balance = balance;
        this.hold = hold;
        this.available = available;
        this.profileId = profileId;
        this.tradingEnabled = tradingEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return tradingEnabled == account.tradingEnabled && Objects.equals(id, account.id) && Objects.equals(currency, account.currency) && Objects.equals(balance, account.balance) && Objects.equals(hold, account.hold) && Objects.equals(available, account.available) && Objects.equals(profileId, account.profileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, balance, hold, available, profileId, tradingEnabled);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", currency=" + currency +
                ", balance=" + balance +
                ", hold=" + hold +
                ", available=" + available +
                ", profileId=" + profileId +
                ", tradingEnabled=" + tradingEnabled +
                '}';
    }
}

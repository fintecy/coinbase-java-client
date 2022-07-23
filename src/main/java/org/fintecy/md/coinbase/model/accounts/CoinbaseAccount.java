package org.fintecy.md.coinbase.model.accounts;

import org.fintecy.md.coinbase.model.CurrencyCode;

import java.math.BigDecimal;
import java.util.Objects;

public class CoinbaseAccount implements CurrencyBalance {
    private final boolean availableOnConsumer;
    private final BigDecimal holdBalance;
    private final String id;
    private final CurrencyCode holdCurrency;
    private final BigDecimal balance;
    private final CurrencyCode currency;
    private final boolean primary;
    private final String name;
    private final String type;
    private final boolean active;

    public CoinbaseAccount(boolean availableOnConsumer, BigDecimal holdBalance, String id, CurrencyCode holdCurrency,
                           BigDecimal balance, CurrencyCode currency, boolean primary, String name, String type, boolean active) {
        this.availableOnConsumer = availableOnConsumer;
        this.holdBalance = holdBalance;
        this.id = id;
        this.holdCurrency = holdCurrency;
        this.balance = balance;
        this.currency = currency;
        this.primary = primary;
        this.name = name;
        this.type = type;
        this.active = active;
    }

    public boolean isAvailableOnConsumer() {
        return availableOnConsumer;
    }

    public BigDecimal getHoldBalance() {
        return holdBalance;
    }

    public String getId() {
        return id;
    }

    public CurrencyCode getHoldCurrency() {
        return holdCurrency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public CurrencyCode getCurrency() {
        return currency;
    }

    public boolean isPrimary() {
        return primary;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinbaseAccount that = (CoinbaseAccount) o;
        return availableOnConsumer == that.availableOnConsumer && primary == that.primary && active == that.active && Objects.equals(holdBalance, that.holdBalance) && Objects.equals(id, that.id) && Objects.equals(holdCurrency, that.holdCurrency) && Objects.equals(balance, that.balance) && Objects.equals(currency, that.currency) && Objects.equals(name, that.name) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableOnConsumer, holdBalance, id, holdCurrency, balance, currency, primary, name, type, active);
    }

    @Override
    public String toString() {
        return "CoinbaseAccount{" +
                "availableOnConsumer=" + availableOnConsumer +
                ", holdBalance=" + holdBalance +
                ", id='" + id + '\'' +
                ", holdCurrency=" + holdCurrency +
                ", balance=" + balance +
                ", currency=" + currency +
                ", primary=" + primary +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", active=" + active +
                '}';
    }
}

package org.fintecy.md.coinbase.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;

public class ExchangeRate {
    private final CurrencyCode base;
    private final CurrencyCode counter;
    private final Instant timestamp;
    private final BigDecimal ask;
    private final BigDecimal bid;
    private final BigDecimal mid;
    private final long tradeId;
    private final BigDecimal volume;
    private final BigDecimal size;

    public ExchangeRate(CurrencyCode base, CurrencyCode counter, Instant timestamp,
                        BigDecimal ask,
                        BigDecimal mid,
                        BigDecimal bid,
                        long tradeId,
                        BigDecimal volume,
                        BigDecimal size) {
        this.base = base;
        this.counter = counter;
        this.timestamp = timestamp;
        this.ask = ask;
        this.mid = mid;
        this.bid = bid;
        this.tradeId = tradeId;
        this.volume = volume;
        this.size = size;
    }

    public ExchangeRate(CurrencyCode base, CurrencyCode counter, Instant timestamp,
                        BigDecimal ask,
                        BigDecimal bid,
                        long tradeId,
                        BigDecimal volume,
                        BigDecimal size) {
        this(base, counter, timestamp, ask, ask.add(bid).divide(BigDecimal.valueOf(2), HALF_UP), bid, tradeId, volume, size);
    }

    public static ExchangeRate exchangeRate(CurrencyCode base, CurrencyCode counter, Instant ts, BigDecimal mid) {
        return new ExchangeRate(base, counter, ts, mid, mid, mid, 0, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public BigDecimal getBid() {
        return bid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return tradeId == that.tradeId && Objects.equals(base, that.base)
                && Objects.equals(counter, that.counter)
                && Objects.equals(timestamp, that.timestamp)
                && Objects.equals(ask, that.ask)
                && Objects.equals(bid, that.bid)
                && Objects.equals(mid, that.mid)
                && Objects.equals(volume, that.volume)
                && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, counter, timestamp, ask, bid, mid, tradeId, volume, size);
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "base=" + base +
                ", counter=" + counter +
                ", timestamp=" + timestamp +
                ", ask=" + ask +
                ", bid=" + bid +
                ", mid=" + mid +
                ", tradeId=" + tradeId +
                ", volume=" + volume +
                ", size=" + size +
                '}';
    }

    public ExchangeRate forProduct(ProductCode productCode) {
        return new ExchangeRate(productCode.getFrom(), productCode.getTo(), timestamp, ask, mid, bid, tradeId, volume, size);
    }
}

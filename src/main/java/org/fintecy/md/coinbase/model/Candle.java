package org.fintecy.md.coinbase.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Candle {
    private final Instant timestamp;
    private final BigDecimal low;
    private final BigDecimal high;
    private final BigDecimal open;
    private final BigDecimal close;
    private final BigDecimal volume;

    public Candle(Instant timestamp, BigDecimal low, BigDecimal high, BigDecimal open, BigDecimal close, BigDecimal volume) {
        this.timestamp = timestamp;
        this.low = low;
        this.high = high;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candle candle = (Candle) o;
        return Objects.equals(timestamp, candle.timestamp)
                && Objects.equals(low, candle.low)
                && Objects.equals(high, candle.high)
                && Objects.equals(open, candle.open)
                && Objects.equals(close, candle.close)
                && Objects.equals(volume, candle.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, low, high, open, close, volume);
    }

    @Override
    public String toString() {
        return "Candle{" +
                "timestamp=" + timestamp +
                ", low=" + low +
                ", high=" + high +
                ", open=" + open +
                ", close=" + close +
                ", volume=" + volume +
                '}';
    }
}

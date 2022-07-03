package org.fintecy.md.coinbase.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class ProductStats extends Candle {
    private final BigDecimal volume30d;

    public ProductStats(Instant timestamp, BigDecimal low, BigDecimal high, BigDecimal open, BigDecimal close, BigDecimal volume, BigDecimal volume30d) {
        super(timestamp, low, high, open, close, volume);
        this.volume30d = volume30d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductStats that = (ProductStats) o;
        return Objects.equals(volume30d, that.volume30d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume30d);
    }

    @Override
    public String toString() {
        return "ProductStats{" +
                "timestamp=" + getTimestamp() +
                ", low=" + getLow() +
                ", high=" + getHigh() +
                ", open=" + getOpen() +
                ", close=" + getClose() +
                ", volume=" + getVolume() +
                ", volume30d=" + volume30d +
                "}";
    }
}

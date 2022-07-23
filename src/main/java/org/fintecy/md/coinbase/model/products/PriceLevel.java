package org.fintecy.md.coinbase.model.products;

import java.math.BigDecimal;
import java.util.Objects;

public class PriceLevel {
    private final BigDecimal price;
    private final BigDecimal volume;
    private final long level;

    public PriceLevel(BigDecimal price, BigDecimal volume, long level) {
        this.price = price;
        this.volume = volume;
        this.level = level;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public long getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceLevel that = (PriceLevel) o;
        return level == that.level && Objects.equals(price, that.price) && Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, volume, level);
    }

    @Override
    public String toString() {
        return "PriceLevel{" +
                "price=" + price +
                ", volume=" + volume +
                ", level=" + level +
                '}';
    }
}

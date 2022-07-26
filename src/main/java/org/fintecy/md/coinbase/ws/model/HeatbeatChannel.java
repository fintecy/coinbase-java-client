package org.fintecy.md.coinbase.ws.model;

import java.util.List;
import java.util.Objects;

public class HeatbeatChannel extends Channel {
    private final List<ProductId> productIds;

    protected HeatbeatChannel(String name, List<ProductId> productIds) {
        super(name);
        this.productIds = productIds;
    }

    public List<ProductId> getProductIds() {
        return productIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeatbeatChannel that = (HeatbeatChannel) o;
        return Objects.equals(productIds, that.productIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productIds);
    }

    @Override
    public String toString() {
        return "HeatbeatChannel{" +
                "name=" + getName() +
                "productIds=" + productIds +
                "} ";
    }
}

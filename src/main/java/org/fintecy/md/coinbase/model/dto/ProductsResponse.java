package org.fintecy.md.coinbase.model.dto;

import org.fintecy.md.coinbase.model.MicroType;
import org.fintecy.md.coinbase.model.Product;

import java.util.List;

public class ProductsResponse extends MicroType<List<Product>> {
    public ProductsResponse(List<Product> value) {
        super(value);
    }

    public List<Product> products() {
        return getValue();
    }
}

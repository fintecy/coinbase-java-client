package org.fintecy.md.coinbase.model.dto;

import org.fintecy.md.coinbase.model.products.Product;
import org.fintecy.md.coinbase.model.MicroType;

import java.util.List;

public class ProductsResponse extends MicroType<List<Product>> {
    public ProductsResponse(List<Product> value) {
        super(value);
    }
}

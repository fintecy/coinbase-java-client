package org.fintecy.md.coinbase.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.fintecy.md.coinbase.model.ExchangeRate;
import org.fintecy.md.coinbase.model.Product;
import org.fintecy.md.coinbase.model.dto.ProductsResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fintecy.md.coinbase.serialization.ProductDeserializer.parse;

public class ProductsResponseDeserializer extends StdDeserializer<ProductsResponse> {
    public final static ProductsResponseDeserializer INSTANCE = new ProductsResponseDeserializer();

    public ProductsResponseDeserializer() {
        super(ExchangeRate.class);
    }

    @Override
    public ProductsResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);

        List<Product> products = new ArrayList<>();
        node.forEach(productNode ->
                products.add(parse(jp, productNode)));
        return new ProductsResponse(products);
    }
}

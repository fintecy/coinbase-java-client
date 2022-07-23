package org.fintecy.md.coinbase.model.products;

import org.fintecy.md.coinbase.model.MicroType;

import java.util.List;

public class CandlesResponse extends MicroType<List<Candle>> {
    public CandlesResponse(List<Candle> value) {
        super(value);
    }
}

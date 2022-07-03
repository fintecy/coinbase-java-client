package org.fintecy.md.coinbase.model;

import java.util.List;

public class CandlesResponse extends MicroType<List<Candle>> {
    public CandlesResponse(List<Candle> value) {
        super(value);
    }
}

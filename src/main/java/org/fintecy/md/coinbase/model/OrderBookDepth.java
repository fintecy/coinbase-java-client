package org.fintecy.md.coinbase.model;

public enum OrderBookDepth {
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3);

    private final short level;

    OrderBookDepth(int lvl) {
        this.level = (short) lvl;
    }

    public short getLevel() {
        return level;
    }
}

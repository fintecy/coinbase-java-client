package org.fintecy.md.coinbase.ws.model;

public abstract class Channel {
    private final String name;

    protected Channel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

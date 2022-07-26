package org.fintecy.md.coinbase.ws;

public enum ChannelType {
    STATUS,
    HEARTBEAT,
    TICKER,
    TICKER_BATCH,
    LEVEL2,
    LEVEL2_BATCH,
    USER,
    MATCHES,
    FULL,
    AUCTIONFEED;

    String channelName() {
        return name().toLowerCase();
    }
}

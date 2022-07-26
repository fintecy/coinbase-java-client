package org.fintecy.md.coinbase.ws.model;

import java.time.Instant;
import java.util.Objects;

public class HeartbeatResponse implements Message {
    private final long sequence;
    private final long lastTradeId;
    private final String productId;
    private final Instant time;

    public HeartbeatResponse(long sequence, long lastTradeId, String productId, Instant time) {
        this.sequence = sequence;
        this.lastTradeId = lastTradeId;
        this.productId = productId;
        this.time = time;
    }

    @Override
    public MessageType type() {
        return MessageType.HEARTBEAT;
    }

    public long getSequence() {
        return sequence;
    }

    public long getLastTradeId() {
        return lastTradeId;
    }

    public String getProductId() {
        return productId;
    }

    public Instant getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeartbeatResponse that = (HeartbeatResponse) o;
        return sequence == that.sequence && lastTradeId == that.lastTradeId && Objects.equals(productId, that.productId) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, lastTradeId, productId, time);
    }

    @Override
    public String toString() {
        return "HeartbeatResponse{" +
                "sequence=" + sequence +
                ", lastTradeId=" + lastTradeId +
                ", productId='" + productId + '\'' +
                ", time=" + time +
                '}';
    }
}

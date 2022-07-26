package org.fintecy.md.coinbase.ws.model;

import java.util.List;
import java.util.Objects;

public class SubscribeRequest implements Message {
    private final List<Channel> channels;

    public SubscribeRequest(List<Channel> channels) {
        this.channels = channels;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribeRequest that = (SubscribeRequest) o;
        return Objects.equals(channels, that.channels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channels);
    }

    @Override
    public String toString() {
        return "SubscribeRequest{" +
                "channels=" + channels +
                '}';
    }

    @Override
    public MessageType type() {
        return MessageType.SUBSCRIBE;
    }
}

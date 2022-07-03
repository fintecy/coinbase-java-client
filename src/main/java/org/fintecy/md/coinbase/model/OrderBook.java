package org.fintecy.md.coinbase.model;

import java.util.List;
import java.util.Objects;

public class OrderBook {
    private final List<PriceLevel> bids;
    private final List<PriceLevel> asks;
    private final long sequence;
    private final boolean auctionMode;
    private final Object auction;

    public OrderBook(List<PriceLevel> bids, List<PriceLevel> asks, long sequence, boolean auctionMode, Object auction) {
        this.bids = bids;
        this.asks = asks;
        this.sequence = sequence;
        this.auctionMode = auctionMode;
        this.auction = auction;
    }

    public List<PriceLevel> getBids() {
        return bids;
    }

    public List<PriceLevel> getAsks() {
        return asks;
    }

    public long getSequence() {
        return sequence;
    }

    public boolean isAuctionMode() {
        return auctionMode;
    }

    public Object getAuction() {
        return auction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBook orderBook = (OrderBook) o;
        return sequence == orderBook.sequence && auctionMode == orderBook.auctionMode
                && Objects.equals(bids, orderBook.bids)
                && Objects.equals(asks, orderBook.asks)
                && Objects.equals(auction, orderBook.auction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bids, asks, sequence, auctionMode, auction);
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "bids=" + bids +
                ", asks=" + asks +
                ", sequence=" + sequence +
                ", auctionMode=" + auctionMode +
                ", auction=" + auction +
                '}';
    }
}

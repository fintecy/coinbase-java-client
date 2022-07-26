package org.fintecy.md.coinbase.ws;

import org.fintecy.md.coinbase.ws.model.HeartbeatResponse;
import org.fintecy.md.coinbase.ws.model.SubscribeRequest;

/**
 * @author batiaev
 * @see <a href="https://docs.cloud.coinbase.com/exchange/docs/websocket-overview">docs</a>
 */
public interface CoinbaseWSApi {
    String ROOT_PATH = "wss://ws-feed.exchange.coinbase.com";

    Flux<HeartbeatResponse> subscribe(SubscribeRequest request);
}

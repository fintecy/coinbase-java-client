package org.fintecy.md.coinbase.rest.exeptions;

import java.security.GeneralSecurityException;

public class CoinbaseException extends RuntimeException {
    public CoinbaseException(String message, GeneralSecurityException e) {
        super(message, e);
    }
}

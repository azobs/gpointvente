package org.c2psi.gpointvente.exceptions.tier;

public class TierExistInPointventeException extends TierException {
    public TierExistInPointventeException() {
    }

    public TierExistInPointventeException(String message) {
        super(message);
    }

    public TierExistInPointventeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TierExistInPointventeException(Throwable cause) {
        super(cause);
    }

    public TierExistInPointventeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

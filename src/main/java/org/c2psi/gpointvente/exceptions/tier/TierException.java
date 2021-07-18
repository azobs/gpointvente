package org.c2psi.gpointvente.exceptions.tier;

public class TierException extends Exception {
    public TierException() {
    }

    public TierException(String message) {
        super(message);
    }

    public TierException(String message, Throwable cause) {
        super(message, cause);
    }

    public TierException(Throwable cause) {
        super(cause);
    }

    public TierException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

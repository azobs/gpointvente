package org.c2psi.gpointvente.exceptions.pv;

public class PointventeNotFoundException extends PointventeException {
    public PointventeNotFoundException() {
    }

    public PointventeNotFoundException(String message) {
        super(message);
    }

    public PointventeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PointventeNotFoundException(Throwable cause) {
        super(cause);
    }

    public PointventeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

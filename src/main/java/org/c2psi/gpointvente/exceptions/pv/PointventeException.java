package org.c2psi.gpointvente.exceptions.pv;

public class PointventeException extends Exception{
    public PointventeException() {
    }

    public PointventeException(String message) {
        super(message);
    }

    public PointventeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PointventeException(Throwable cause) {
        super(cause);
    }

    public PointventeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

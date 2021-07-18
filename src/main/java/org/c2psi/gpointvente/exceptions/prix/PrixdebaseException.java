package org.c2psi.gpointvente.exceptions.prix;

public class PrixdebaseException extends Exception{
    public PrixdebaseException() {
    }

    public PrixdebaseException(String message) {
        super(message);
    }

    public PrixdebaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrixdebaseException(Throwable cause) {
        super(cause);
    }

    public PrixdebaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

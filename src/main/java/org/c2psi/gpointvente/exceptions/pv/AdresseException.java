package org.c2psi.gpointvente.exceptions.pv;

public class AdresseException extends Exception{
    public AdresseException() {
    }

    public AdresseException(String message) {
        super(message);
    }

    public AdresseException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdresseException(Throwable cause) {
        super(cause);
    }

    public AdresseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

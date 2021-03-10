package org.c2psi.gpointvente.exceptions.pv;

public class AdresseNotFoundException extends AdresseException {
    public AdresseNotFoundException() {
    }

    public AdresseNotFoundException(String message) {
        super(message);
    }

    public AdresseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdresseNotFoundException(Throwable cause) {
        super(cause);
    }

    public AdresseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

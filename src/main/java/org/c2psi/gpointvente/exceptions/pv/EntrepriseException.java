package org.c2psi.gpointvente.exceptions.pv;

public class EntrepriseException extends RuntimeException {
    public EntrepriseException() {
    }

    public EntrepriseException(String message) {
        super(message);
    }

    public EntrepriseException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntrepriseException(Throwable cause) {
        super(cause);
    }

    public EntrepriseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

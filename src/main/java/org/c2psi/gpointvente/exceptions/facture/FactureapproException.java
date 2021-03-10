package org.c2psi.gpointvente.exceptions.facture;

public class FactureapproException extends Exception {
    public FactureapproException() {
    }

    public FactureapproException(String message) {
        super(message);
    }

    public FactureapproException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactureapproException(Throwable cause) {
        super(cause);
    }

    public FactureapproException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

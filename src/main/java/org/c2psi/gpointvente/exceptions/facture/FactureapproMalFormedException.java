package org.c2psi.gpointvente.exceptions.facture;


public class FactureapproMalFormedException extends FactureapproException {
    public FactureapproMalFormedException() {
    }

    public FactureapproMalFormedException(String message) {
        super(message);
    }

    public FactureapproMalFormedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactureapproMalFormedException(Throwable cause) {
        super(cause);
    }

    public FactureapproMalFormedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

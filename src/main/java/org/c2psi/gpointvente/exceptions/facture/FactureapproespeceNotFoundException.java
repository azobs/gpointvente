package org.c2psi.gpointvente.exceptions.facture;

public class FactureapproespeceNotFoundException extends FactureapproException {
    public FactureapproespeceNotFoundException() {
    }

    public FactureapproespeceNotFoundException(String message) {
        super(message);
    }

    public FactureapproespeceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactureapproespeceNotFoundException(Throwable cause) {
        super(cause);
    }

    public FactureapproespeceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

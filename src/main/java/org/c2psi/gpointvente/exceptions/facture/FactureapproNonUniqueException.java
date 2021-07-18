package org.c2psi.gpointvente.exceptions.facture;

public class FactureapproNonUniqueException extends FactureapproException {
    public FactureapproNonUniqueException() {
    }

    public FactureapproNonUniqueException(String message) {
        super(message);
    }

    public FactureapproNonUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactureapproNonUniqueException(Throwable cause) {
        super(cause);
    }

    public FactureapproNonUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

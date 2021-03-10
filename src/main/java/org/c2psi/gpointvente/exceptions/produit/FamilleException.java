package org.c2psi.gpointvente.exceptions.produit;

public class FamilleException extends Exception {
    public FamilleException() {
    }

    public FamilleException(String message) {
        super(message);
    }

    public FamilleException(String message, Throwable cause) {
        super(message, cause);
    }

    public FamilleException(Throwable cause) {
        super(cause);
    }

    public FamilleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

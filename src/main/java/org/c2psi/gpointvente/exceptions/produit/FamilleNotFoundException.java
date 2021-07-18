package org.c2psi.gpointvente.exceptions.produit;

public class FamilleNotFoundException extends FamilleException {
    public FamilleNotFoundException() {
    }

    public FamilleNotFoundException(String message) {
        super(message);
    }

    public FamilleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FamilleNotFoundException(Throwable cause) {
        super(cause);
    }

    public FamilleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

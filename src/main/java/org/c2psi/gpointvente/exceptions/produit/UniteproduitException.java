package org.c2psi.gpointvente.exceptions.produit;

public class UniteproduitException extends Exception {
    public UniteproduitException() {
    }

    public UniteproduitException(String message) {
        super(message);
    }

    public UniteproduitException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniteproduitException(Throwable cause) {
        super(cause);
    }

    public UniteproduitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

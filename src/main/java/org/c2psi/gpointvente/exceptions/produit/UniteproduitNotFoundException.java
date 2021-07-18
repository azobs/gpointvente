package org.c2psi.gpointvente.exceptions.produit;

public class UniteproduitNotFoundException extends UniteproduitException {
    public UniteproduitNotFoundException() {
    }

    public UniteproduitNotFoundException(String message) {
        super(message);
    }

    public UniteproduitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniteproduitNotFoundException(Throwable cause) {
        super(cause);
    }

    public UniteproduitNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

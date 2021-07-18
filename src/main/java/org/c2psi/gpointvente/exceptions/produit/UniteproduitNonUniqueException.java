package org.c2psi.gpointvente.exceptions.produit;

public class UniteproduitNonUniqueException extends UniteproduitException {
    public UniteproduitNonUniqueException() {
    }

    public UniteproduitNonUniqueException(String message) {
        super(message);
    }

    public UniteproduitNonUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniteproduitNonUniqueException(Throwable cause) {
        super(cause);
    }

    public UniteproduitNonUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

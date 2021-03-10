package org.c2psi.gpointvente.exceptions.produit;

public class ProduitFormateUniteException extends Exception {
    public ProduitFormateUniteException() {
    }

    public ProduitFormateUniteException(String message) {
        super(message);
    }

    public ProduitFormateUniteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProduitFormateUniteException(Throwable cause) {
        super(cause);
    }

    public ProduitFormateUniteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package org.c2psi.gpointvente.exceptions.produit;

public class ProduitFormateException extends Exception {
    public ProduitFormateException() {
    }

    public ProduitFormateException(String message) {
        super(message);
    }

    public ProduitFormateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProduitFormateException(Throwable cause) {
        super(cause);
    }

    public ProduitFormateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

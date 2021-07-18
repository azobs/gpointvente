package org.c2psi.gpointvente.exceptions.produit;

public class ProduitFormateUniteNotFoundException extends ProduitFormateUniteException {
    public ProduitFormateUniteNotFoundException() {
    }

    public ProduitFormateUniteNotFoundException(String message) {
        super(message);
    }

    public ProduitFormateUniteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProduitFormateUniteNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProduitFormateUniteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

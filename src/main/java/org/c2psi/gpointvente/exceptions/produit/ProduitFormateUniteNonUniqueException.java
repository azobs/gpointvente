package org.c2psi.gpointvente.exceptions.produit;

public class ProduitFormateUniteNonUniqueException extends ProduitFormateUniteException {
    public ProduitFormateUniteNonUniqueException() {
    }

    public ProduitFormateUniteNonUniqueException(String message) {
        super(message);
    }

    public ProduitFormateUniteNonUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProduitFormateUniteNonUniqueException(Throwable cause) {
        super(cause);
    }

    public ProduitFormateUniteNonUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

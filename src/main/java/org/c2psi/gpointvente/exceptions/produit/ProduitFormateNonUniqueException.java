package org.c2psi.gpointvente.exceptions.produit;

public class ProduitFormateNonUniqueException extends ProduitFormateException {
    public ProduitFormateNonUniqueException() {
    }

    public ProduitFormateNonUniqueException(String message) {
        super(message);
    }

    public ProduitFormateNonUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProduitFormateNonUniqueException(Throwable cause) {
        super(cause);
    }

    public ProduitFormateNonUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

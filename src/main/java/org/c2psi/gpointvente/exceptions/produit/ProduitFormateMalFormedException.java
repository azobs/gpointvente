package org.c2psi.gpointvente.exceptions.produit;

public class ProduitFormateMalFormedException extends ProduitFormateException {
    public ProduitFormateMalFormedException() {
    }

    public ProduitFormateMalFormedException(String message) {
        super(message);
    }

    public ProduitFormateMalFormedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProduitFormateMalFormedException(Throwable cause) {
        super(cause);
    }

    public ProduitFormateMalFormedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

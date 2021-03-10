package org.c2psi.gpointvente.exceptions.produit;

public class FormatproduitException extends Exception {
    public FormatproduitException() {
    }

    public FormatproduitException(String message) {
        super(message);
    }

    public FormatproduitException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatproduitException(Throwable cause) {
        super(cause);
    }

    public FormatproduitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

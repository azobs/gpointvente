package org.c2psi.gpointvente.exceptions.produit;

public class FormatproduitNotFoundException extends FormatproduitException {
    public FormatproduitNotFoundException() {
    }

    public FormatproduitNotFoundException(String message) {
        super(message);
    }

    public FormatproduitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatproduitNotFoundException(Throwable cause) {
        super(cause);
    }

    public FormatproduitNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

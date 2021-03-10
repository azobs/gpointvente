package org.c2psi.gpointvente.exceptions.produit;

public class FormatproduitNonUniqueException extends FormatproduitException {
    public FormatproduitNonUniqueException() {
    }

    public FormatproduitNonUniqueException(String message) {
        super(message);
    }

    public FormatproduitNonUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatproduitNonUniqueException(Throwable cause) {
        super(cause);
    }

    public FormatproduitNonUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

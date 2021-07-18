package org.c2psi.gpointvente.exceptions.produit;

public class FamilleNonUniqueException extends FamilleException {
    public FamilleNonUniqueException() {
    }

    public FamilleNonUniqueException(String message) {
        super(message);
    }

    public FamilleNonUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public FamilleNonUniqueException(Throwable cause) {
        super(cause);
    }

    public FamilleNonUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

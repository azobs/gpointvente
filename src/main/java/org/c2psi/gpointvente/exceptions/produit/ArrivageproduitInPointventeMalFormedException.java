package org.c2psi.gpointvente.exceptions.produit;

public class ArrivageproduitInPointventeMalFormedException extends ArrivageProduitformateException {
    public ArrivageproduitInPointventeMalFormedException() {
    }

    public ArrivageproduitInPointventeMalFormedException(String message) {
        super(message);
    }

    public ArrivageproduitInPointventeMalFormedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrivageproduitInPointventeMalFormedException(Throwable cause) {
        super(cause);
    }

    public ArrivageproduitInPointventeMalFormedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

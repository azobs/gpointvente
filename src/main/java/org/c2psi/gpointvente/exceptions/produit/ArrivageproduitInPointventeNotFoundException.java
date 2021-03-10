package org.c2psi.gpointvente.exceptions.produit;

public class ArrivageproduitInPointventeNotFoundException extends ArrivageProduitformateException {
    public ArrivageproduitInPointventeNotFoundException() {
    }

    public ArrivageproduitInPointventeNotFoundException(String message) {
        super(message);
    }

    public ArrivageproduitInPointventeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrivageproduitInPointventeNotFoundException(Throwable cause) {
        super(cause);
    }

    public ArrivageproduitInPointventeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

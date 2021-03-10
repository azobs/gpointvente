package org.c2psi.gpointvente.exceptions.produit;

public class RegleconversionNotFoundException extends RegleconversionUniteException {
    public RegleconversionNotFoundException() {
    }

    public RegleconversionNotFoundException(String message) {
        super(message);
    }

    public RegleconversionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegleconversionNotFoundException(Throwable cause) {
        super(cause);
    }

    public RegleconversionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

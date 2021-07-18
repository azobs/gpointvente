package org.c2psi.gpointvente.exceptions.produit;

public class RegleconversionUniteException extends Exception{
    public RegleconversionUniteException() {
    }

    public RegleconversionUniteException(String message) {
        super(message);
    }

    public RegleconversionUniteException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegleconversionUniteException(Throwable cause) {
        super(cause);
    }

    public RegleconversionUniteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

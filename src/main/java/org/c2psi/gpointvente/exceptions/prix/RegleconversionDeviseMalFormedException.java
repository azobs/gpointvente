package org.c2psi.gpointvente.exceptions.prix;

public class RegleconversionDeviseMalFormedException extends RegleconversionDeviseException {
    public RegleconversionDeviseMalFormedException() {
    }

    public RegleconversionDeviseMalFormedException(String message) {
        super(message);
    }

    public RegleconversionDeviseMalFormedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegleconversionDeviseMalFormedException(Throwable cause) {
        super(cause);
    }

    public RegleconversionDeviseMalFormedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

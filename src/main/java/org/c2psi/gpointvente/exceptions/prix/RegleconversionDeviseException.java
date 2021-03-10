package org.c2psi.gpointvente.exceptions.prix;

public class RegleconversionDeviseException extends Exception{
    public RegleconversionDeviseException() {
    }

    public RegleconversionDeviseException(String message) {
        super(message);
    }

    public RegleconversionDeviseException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegleconversionDeviseException(Throwable cause) {
        super(cause);
    }

    public RegleconversionDeviseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

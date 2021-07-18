package org.c2psi.gpointvente.exceptions.produit;

public class RegleconversionUniteMalFormedException extends RegleconversionUniteException {
    public RegleconversionUniteMalFormedException() {
    }

    public RegleconversionUniteMalFormedException(String message) {
        super(message);
    }

    public RegleconversionUniteMalFormedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegleconversionUniteMalFormedException(Throwable cause) {
        super(cause);
    }

    public RegleconversionUniteMalFormedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

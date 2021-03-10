package org.c2psi.gpointvente.exceptions.produit;

public class ProduitFormateUniteMalFormedException extends ProduitFormateUniteException {
    public ProduitFormateUniteMalFormedException() {
    }

    public ProduitFormateUniteMalFormedException(String message) {
        super(message);
    }

    public ProduitFormateUniteMalFormedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProduitFormateUniteMalFormedException(Throwable cause) {
        super(cause);
    }

    public ProduitFormateUniteMalFormedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

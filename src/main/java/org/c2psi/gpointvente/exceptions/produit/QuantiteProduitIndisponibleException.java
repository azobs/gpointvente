package org.c2psi.gpointvente.exceptions.produit;

public class QuantiteProduitIndisponibleException extends ProduitFormateUniteException {
    public QuantiteProduitIndisponibleException() {
    }

    public QuantiteProduitIndisponibleException(String message) {
        super(message);
    }

    public QuantiteProduitIndisponibleException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuantiteProduitIndisponibleException(Throwable cause) {
        super(cause);
    }

    public QuantiteProduitIndisponibleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package org.c2psi.gpointvente.exceptions.pv;

import org.c2psi.gpointvente.exceptions.produit.ProduitException;

public class DesignationProduitNonUniqueInFamilleException extends ProduitException {
    public DesignationProduitNonUniqueInFamilleException() {
    }

    public DesignationProduitNonUniqueInFamilleException(String message) {
        super(message);
    }

    public DesignationProduitNonUniqueInFamilleException(String message, Throwable cause) {
        super(message, cause);
    }

    public DesignationProduitNonUniqueInFamilleException(Throwable cause) {
        super(cause);
    }

    public DesignationProduitNonUniqueInFamilleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package org.c2psi.gpointvente.exceptions.prix;

public class PrixdebaseExistInDeviseException extends PrixdebaseException {
    public PrixdebaseExistInDeviseException() {
    }

    public PrixdebaseExistInDeviseException(String message) {
        super(message);
    }

    public PrixdebaseExistInDeviseException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrixdebaseExistInDeviseException(Throwable cause) {
        super(cause);
    }

    public PrixdebaseExistInDeviseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

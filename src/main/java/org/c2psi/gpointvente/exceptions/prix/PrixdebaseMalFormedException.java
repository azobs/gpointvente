package org.c2psi.gpointvente.exceptions.prix;

public class PrixdebaseMalFormedException extends PrixdebaseException {
    public PrixdebaseMalFormedException() {
    }

    public PrixdebaseMalFormedException(String message) {
        super(message);
    }

    public PrixdebaseMalFormedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrixdebaseMalFormedException(Throwable cause) {
        super(cause);
    }

    public PrixdebaseMalFormedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

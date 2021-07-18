package org.c2psi.gpointvente.exceptions.prix;

public class DeviseException extends Exception {
    public DeviseException() {
    }

    public DeviseException(String message) {
        super(message);
    }

    public DeviseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviseException(Throwable cause) {
        super(cause);
    }

    public DeviseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

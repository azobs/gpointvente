package org.c2psi.gpointvente.exceptions.prix;

public class DeviseNotFoundException extends DeviseException {
    public DeviseNotFoundException() {
    }

    public DeviseNotFoundException(String message) {
        super(message);
    }

    public DeviseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviseNotFoundException(Throwable cause) {
        super(cause);
    }

    public DeviseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

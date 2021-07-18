package org.c2psi.gpointvente.exceptions.pv;

public class TypeemballageNotFoundException extends TypeemballageException {
    public TypeemballageNotFoundException() {
    }

    public TypeemballageNotFoundException(String message) {
        super(message);
    }

    public TypeemballageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeemballageNotFoundException(Throwable cause) {
        super(cause);
    }

    public TypeemballageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

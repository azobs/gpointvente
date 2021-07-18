package org.c2psi.gpointvente.exceptions.pv;

public class CompteprincipalNotFoundException extends CompteprincipalException{
    public CompteprincipalNotFoundException() {
    }

    public CompteprincipalNotFoundException(String message) {
        super(message);
    }

    public CompteprincipalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompteprincipalNotFoundException(Throwable cause) {
        super(cause);
    }

    public CompteprincipalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

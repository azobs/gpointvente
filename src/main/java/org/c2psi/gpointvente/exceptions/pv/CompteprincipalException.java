package org.c2psi.gpointvente.exceptions.pv;

public class CompteprincipalException extends Exception{
    public CompteprincipalException() {
    }

    public CompteprincipalException(String message) {
        super(message);
    }

    public CompteprincipalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompteprincipalException(Throwable cause) {
        super(cause);
    }

    public CompteprincipalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

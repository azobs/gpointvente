package org.c2psi.gpointvente.exceptions.pv;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntrepriseNotFoundException extends EntrepriseException {
    public EntrepriseNotFoundException() {
    }

    public EntrepriseNotFoundException(String message) {
        super(message);
    }

    public EntrepriseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntrepriseNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntrepriseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

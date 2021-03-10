package org.c2psi.gpointvente.exceptions.pv;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class SigleEntrepriseNonUniqueException extends EntrepriseException{
    public SigleEntrepriseNonUniqueException() {
    }

    public SigleEntrepriseNonUniqueException(String message) {
        super(message);
    }

    public SigleEntrepriseNonUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public SigleEntrepriseNonUniqueException(Throwable cause) {
        super(cause);
    }

    public SigleEntrepriseNonUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

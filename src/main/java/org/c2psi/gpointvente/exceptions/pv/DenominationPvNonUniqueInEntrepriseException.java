package org.c2psi.gpointvente.exceptions.pv;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class DenominationPvNonUniqueInEntrepriseException extends PointventeException {
    public DenominationPvNonUniqueInEntrepriseException() {
    }

    public DenominationPvNonUniqueInEntrepriseException(String message) {
        super(message);
    }

    public DenominationPvNonUniqueInEntrepriseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DenominationPvNonUniqueInEntrepriseException(Throwable cause) {
        super(cause);
    }

    public DenominationPvNonUniqueInEntrepriseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

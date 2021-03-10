package org.c2psi.gpointvente.entities.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Superadministrateur {
    @Id
    String idSuperadmin;

    /**
     * Un superadministrateur est d'abord un utilisateur
     */
    @DBRef
    Utilisateur userAssocie;

    public Superadministrateur() {
    }

    public Superadministrateur(String idSuperadmin, Utilisateur userAssocie) {
        this.idSuperadmin = idSuperadmin;
        this.userAssocie = userAssocie;
    }

    public String getIdSuperadmin() {
        return idSuperadmin;
    }

    public void setIdSuperadmin(String idSuperadmin) {
        this.idSuperadmin = idSuperadmin;
    }

    public Utilisateur getUserAssocie() {
        return userAssocie;
    }

    public void setUserAssocie(Utilisateur userAssocie) {
        this.userAssocie = userAssocie;
    }
}

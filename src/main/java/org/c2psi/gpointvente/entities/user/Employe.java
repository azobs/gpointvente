package org.c2psi.gpointvente.entities.user;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employe {
    @Id
    String idEmploye;

    @DBRef
    Utilisateur user;
    @DBRef
    Pointvente postetravail;

    public Employe() {
    }

    public Employe(String idEmploye, Utilisateur user, Pointvente postetravail) {
        this.idEmploye = idEmploye;
        this.user = user;
        this.postetravail = postetravail;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Pointvente getPostetravail() {
        return postetravail;
    }

    public void setPostetravail(Pointvente postetravail) {
        this.postetravail = postetravail;
    }
}

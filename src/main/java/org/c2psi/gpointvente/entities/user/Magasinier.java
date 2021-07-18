package org.c2psi.gpointvente.entities.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Magasinier {
    @Id
    String idMagasinier;

    @DBRef
    Employe employeCorrespondant;

    public Magasinier() {
    }

    public Magasinier(String idMagasinier, Employe employeCorrespondant) {
        this.idMagasinier = idMagasinier;
        this.employeCorrespondant = employeCorrespondant;
    }

    public String getIdMagasinier() {
        return idMagasinier;
    }

    public void setIdMagasinier(String idMagasinier) {
        this.idMagasinier = idMagasinier;
    }

    public Employe getEmployeCorrespondant() {
        return employeCorrespondant;
    }

    public void setEmployeCorrespondant(Employe employeCorrespondant) {
        this.employeCorrespondant = employeCorrespondant;
    }
}

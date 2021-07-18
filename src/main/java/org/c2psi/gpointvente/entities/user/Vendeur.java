package org.c2psi.gpointvente.entities.user;

import org.c2psi.gpointvente.entities.user.Employe;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vendeur {
    @Id
    String idVendeur;

    @DBRef
    Employe employeCorrespondant;

    public Vendeur() {
    }

    public Vendeur(String idVendeur, Employe employeCorrespondant) {
        this.idVendeur = idVendeur;
        this.employeCorrespondant = employeCorrespondant;
    }

    public String getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(String idVendeur) {
        this.idVendeur = idVendeur;
    }

    public Employe getEmployeCorrespondant() {
        return employeCorrespondant;
    }

    public void setEmployeCorrespondant(Employe employeCorrespondant) {
        this.employeCorrespondant = employeCorrespondant;
    }
}

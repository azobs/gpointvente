package org.c2psi.gpointvente.entities.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Gerant {
    @Id
    String idGerant;

    @DBRef
    Employe employeCorrespondant;

    public Gerant() {
    }

    public Gerant(String idGerant, Employe employeCorrespondant) {
        this.idGerant = idGerant;
        this.employeCorrespondant = employeCorrespondant;
    }

    public String getIdGerant() {
        return idGerant;
    }

    public void setIdGerant(String idGerant) {
        this.idGerant = idGerant;
    }

    public Employe getEmployeCorrespondant() {
        return employeCorrespondant;
    }

    public void setEmployeCorrespondant(Employe employeCorrespondant) {
        this.employeCorrespondant = employeCorrespondant;
    }
}

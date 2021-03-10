package org.c2psi.gpointvente.entities.facture.factureVente;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Factureventecapsule {
    @Id
    String idFactureventecapsule;
    int nbrecapsuleattenduFacturevente;
    int nbrecapsuleverseFacturevente;

    /**
     * Chaque factureventecapsule est d'abord une facturevente qui elle est une facture
     */
    @DBRef
    Facturevente factureventeAssocie;

    public Factureventecapsule() {
    }

    public Factureventecapsule(String idFactureventecapsule, int nbrecapsuleattenduFacturevente,
                               int nbrecapsuleverseFacturevente, Facturevente factureventeAssocie) {
        this.idFactureventecapsule = idFactureventecapsule;
        this.nbrecapsuleattenduFacturevente = nbrecapsuleattenduFacturevente;
        this.nbrecapsuleverseFacturevente = nbrecapsuleverseFacturevente;
        this.factureventeAssocie = factureventeAssocie;
    }

    public String getIdFactureventecapsule() {
        return idFactureventecapsule;
    }

    public void setIdFactureventecapsule(String idFactureventecapsule) {
        this.idFactureventecapsule = idFactureventecapsule;
    }

    public int getNbrecapsuleattenduFacturevente() {
        return nbrecapsuleattenduFacturevente;
    }

    public void setNbrecapsuleattenduFacturevente(int nbrecapsuleattenduFacturevente) {
        this.nbrecapsuleattenduFacturevente = nbrecapsuleattenduFacturevente;
    }

    public int getNbrecapsuleverseFacturevente() {
        return nbrecapsuleverseFacturevente;
    }

    public void setNbrecapsuleverseFacturevente(int nbrecapsuleverseFacturevente) {
        this.nbrecapsuleverseFacturevente = nbrecapsuleverseFacturevente;
    }

    public Facturevente getFactureventeAssocie() {
        return factureventeAssocie;
    }

    public void setFactureventeAssocie(Facturevente factureventeAssocie) {
        this.factureventeAssocie = factureventeAssocie;
    }
}

package org.c2psi.gpointvente.entities.facture;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Facture {
    @Id
    String idFacture;
    /***********************************************************
     * Une facture peut concerne soit l'Approvisionnement (typeFacture = Approvisionnement)
     * soit les ventes (typeFacture = vente)
     */
    String typeFacture;

    public Facture() {
    }

    public Facture(String idFacture, String typeFacture) {
        this.idFacture = idFacture;
        this.typeFacture = typeFacture;
    }

    public String getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(String idFacture) {
        this.idFacture = idFacture;
    }

    public String getTypeFacture() {
        return typeFacture;
    }

    public void setTypeFacture(String typeFacture) {
        this.typeFacture = typeFacture;
    }
}

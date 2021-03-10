package org.c2psi.gpointvente.entities.tier;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Fournisseur {
    @Id
    String idFournisseur;

    /**
     * Un fournisseur est un tier
     */
    @DBRef
    Tier tierFournisseur;


    public Fournisseur() {
    }

    public Fournisseur(String idFournisseur, Tier tierFournisseur, Pointvente pointvente) {
        this.idFournisseur = idFournisseur;
        this.tierFournisseur = tierFournisseur;
    }

    public String getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(String idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Tier getTierFournisseur() {
        return tierFournisseur;
    }

    public void setTierFournisseur(Tier tierFournisseur) {
        this.tierFournisseur = tierFournisseur;
    }



}

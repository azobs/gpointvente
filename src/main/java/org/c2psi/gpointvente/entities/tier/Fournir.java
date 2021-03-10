package org.c2psi.gpointvente.entities.tier;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Fournir {
    @Id
    String idFournir;
    /**
     * Un fournisseur fourni dans un point de vente
     */
    @DBRef
    Fournisseur fournisseur;
    /**
     * Un point de vente recoit les arrivages venant d'un fournisseur
     */
    @DBRef
    Pointvente pointvente;

    public Fournir() {
    }

    public Fournir(Fournisseur fournisseur, Pointvente pointvente) {
        this.fournisseur = fournisseur;
        this.pointvente = pointvente;
    }

    public String getIdFournir() {
        return idFournir;
    }

    public void setIdFournir(String idFournir) {
        this.idFournir = idFournir;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }
}

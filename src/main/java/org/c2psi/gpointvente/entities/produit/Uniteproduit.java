package org.c2psi.gpointvente.entities.produit;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Uniteproduit {
    @Id
    String idUnite;
    String libelleUniteFR;
    String libelleUniteEN;
    String abbreviationUniteEN;
    String abbreviationUniteFR;

    /**
     * Chaque format de produit appartient à un Point de vente. Donc c'est l'administrateur
     * du point de vente qui les enregistre pour formater les produits qui seront vendus dans
     * ce point de vente
     */
    @DBRef
    Pointvente pointvente;

    public Uniteproduit() {
    }

    public Uniteproduit(String idUnite, String libelleUniteFR, String libelleUniteEN,
                        String abbreviationUniteEN, String abbreviationUniteFR) {
        this.idUnite = idUnite;
        this.libelleUniteFR = libelleUniteFR;
        this.libelleUniteEN = libelleUniteEN;
        this.abbreviationUniteEN = abbreviationUniteEN;
        this.abbreviationUniteFR = abbreviationUniteFR;
    }

    public String getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(String idUnite) {
        this.idUnite = idUnite;
    }

    public String getLibelleUniteFR() {
        return libelleUniteFR;
    }

    public void setLibelleUniteFR(String libelleUniteFR) {
        this.libelleUniteFR = libelleUniteFR;
    }

    public String getLibelleUniteEN() {
        return libelleUniteEN;
    }

    public void setLibelleUniteEN(String libelleUniteEN) {
        this.libelleUniteEN = libelleUniteEN;
    }

    public String getAbbreviationUniteEN() {
        return abbreviationUniteEN;
    }

    public void setAbbreviationUniteEN(String abbreviationUniteEN) {
        this.abbreviationUniteEN = abbreviationUniteEN;
    }

    public String getAbbreviationUniteFR() {
        return abbreviationUniteFR;
    }

    public void setAbbreviationUniteFR(String abbreviationUniteFR) {
        this.abbreviationUniteFR = abbreviationUniteFR;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }
}

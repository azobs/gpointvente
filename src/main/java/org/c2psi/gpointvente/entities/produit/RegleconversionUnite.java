package org.c2psi.gpointvente.entities.produit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Une regle de conversion permettra de decomposer un produit qui utilise cette unite
 * l'unite multiple est supérieur à l'unité sousmultiple et le facteur de conversion
 * doit toujours etre un entier positif.
 */
@Document
public class RegleconversionUnite {
    @Id
    String idRcU;
    int facteurconversion;

    /**
     *Unite multiple implique dans la regle de conversion
     */
    @DBRef
    Uniteproduit unitemultiple;
    /**
     * Unite sous multiple implique dans la regle de conversion
     */
    @DBRef
    Uniteproduit unitesousmultiple;

    public RegleconversionUnite() {
    }

    public RegleconversionUnite(String idRcU, int facteurconversion, Uniteproduit unitemultiple,
                                Uniteproduit unitesousmultiple) {
        this.idRcU = idRcU;
        this.facteurconversion = facteurconversion;
        this.unitemultiple = unitemultiple;
        this.unitesousmultiple = unitesousmultiple;
    }

    public String getIdRcU() {
        return idRcU;
    }

    public void setIdRcU(String idRcU) {
        this.idRcU = idRcU;
    }

    public int getFacteurconversion() {
        return facteurconversion;
    }

    public void setFacteurconversion(int facteurconversion) {
        this.facteurconversion = facteurconversion;
    }

    public Uniteproduit getUnitemultiple() {
        return unitemultiple;
    }

    public void setUnitemultiple(Uniteproduit unitemultiple) {
        this.unitemultiple = unitemultiple;
    }

    public Uniteproduit getUnitesousmultiple() {
        return unitesousmultiple;
    }

    public void setUnitesousmultiple(Uniteproduit unitesousmultiple) {
        this.unitesousmultiple = unitesousmultiple;
    }
}

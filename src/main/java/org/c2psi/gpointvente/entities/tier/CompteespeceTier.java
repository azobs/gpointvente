package org.c2psi.gpointvente.entities.tier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CompteespeceTier {
    @Id
    String idCompteespeceTier;
    double soldeCompteespeceTier;
    /*
    *)1 pour dire positif c'est a dire  que c'est le Tier qui doit soit verser l'espece au point de vente
    *)0  pour dire negatif c'est a dire que c'est le point  de vente qui doit verser l'espece au Tier
     */
    int statutSoldeCompteespeceTier;
    /*
    Il s'agit du Tier qui possede le  compte
     */
    @DBRef
    Tier tierProprietaire;

    public CompteespeceTier() {
    }

    public CompteespeceTier(String idCompteespeceTier, double soldeCompteespeceTier,
                            int statutSoldeCompteespeceTier, Tier tierProprietaire) {
        this.idCompteespeceTier = idCompteespeceTier;
        this.soldeCompteespeceTier = soldeCompteespeceTier;
        this.statutSoldeCompteespeceTier = statutSoldeCompteespeceTier;
        this.tierProprietaire = tierProprietaire;
    }

    public String getIdCompteespeceTier() {
        return idCompteespeceTier;
    }

    public void setIdCompteespeceTier(String idCompteespeceTier) {
        this.idCompteespeceTier = idCompteespeceTier;
    }

    public double getSoldeCompteespeceTier() {
        return soldeCompteespeceTier;
    }

    public void setSoldeCompteespeceTier(double soldeCompteespeceTier) {
        this.soldeCompteespeceTier = soldeCompteespeceTier;
    }

    public int getStatutSoldeCompteespeceTier() {
        return statutSoldeCompteespeceTier;
    }

    public void setStatutSoldeCompteespeceTier(int statutSoldeCompteespeceTier) {
        this.statutSoldeCompteespeceTier = statutSoldeCompteespeceTier;
    }

    public Tier getTierProprietaire() {
        return tierProprietaire;
    }

    public void setTierProprietaire(Tier tierProprietaire) {
        this.tierProprietaire = tierProprietaire;
    }

    @Override
    public String toString() {
        return "CompteespeceTier{" +
                "idCompteespeceTier='" + idCompteespeceTier + '\'' +
                ", soldeCompteespeceTier=" + soldeCompteespeceTier +
                ", statutSoldeCompteespeceTier=" + statutSoldeCompteespeceTier +
                ", tierProprietaire=" + tierProprietaire +
                '}';
    }
}

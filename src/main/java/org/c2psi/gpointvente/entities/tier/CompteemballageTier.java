package org.c2psi.gpointvente.entities.tier;

import org.c2psi.gpointvente.entities.pv.Typeemballage;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CompteemballageTier {
    @Id
    String idCompteemballageTier;
    int soldeCompteemballageTier;
    /*
    *)1 pour dire positif c'est a dire  que c'est le Tier qui doit soit verser les emballages  ou les
    au point de vente
    *)0  pour dire negatif c'est a dire que c'est le point  de vente qui doit verser les emballage au Tier
     */
    int statutSoldeCompteemballageTier;
    /*
    Il s'agit du Tier qui possede le  compte
     */
    @DBRef
    Tier tierProprietaire;
    /*
    Il s'agit du  type d'emballage  dans le point  de vente ou le tier concerne est client et
    pour lequel  le compte a été crée
     */
    @DBRef
    Typeemballage typeemballage;

    public CompteemballageTier() {
    }

    public CompteemballageTier(String idCompteemballageTier, int soldeCompteemballageTier,
                               int statutSoldeCompteemballageTier, Tier tierProprietaire,
                               Typeemballage typeemballage) {
        this.idCompteemballageTier = idCompteemballageTier;
        this.soldeCompteemballageTier = soldeCompteemballageTier;
        this.statutSoldeCompteemballageTier = statutSoldeCompteemballageTier;
        this.tierProprietaire = tierProprietaire;
        this.typeemballage = typeemballage;
    }

    public String getIdCompteemballageTier() {
        return idCompteemballageTier;
    }

    public void setIdCompteemballageTier(String idCompteemballageTier) {
        this.idCompteemballageTier = idCompteemballageTier;
    }

    public int getSoldeCompteemballageTier() {
        return soldeCompteemballageTier;
    }

    public void setSoldeCompteemballageTier(int soldeCompteemballageTier) {
        this.soldeCompteemballageTier = soldeCompteemballageTier;
    }

    public int getStatutSoldeCompteemballageTier() {
        return statutSoldeCompteemballageTier;
    }

    public void setStatutSoldeCompteemballageTier(int statutSoldeCompteemballageTier) {
        this.statutSoldeCompteemballageTier = statutSoldeCompteemballageTier;
    }

    public Tier getTierProprietaire() {
        return tierProprietaire;
    }

    public void setTierProprietaire(Tier tierProprietaire) {
        this.tierProprietaire = tierProprietaire;
    }

    public Typeemballage getTypeemballage() {
        return typeemballage;
    }

    public void setTypeemballage(Typeemballage typeemballage) {
        this.typeemballage = typeemballage;
    }

    @Override
    public String toString() {
        return "CompteemballageTier{" +
                "idCompteemballageTier='" + idCompteemballageTier + '\'' +
                ", soldeCompteemballageTier=" + soldeCompteemballageTier +
                ", statutSoldeCompteemballageTier=" + statutSoldeCompteemballageTier +
                ", tierProprietaire=" + tierProprietaire +
                ", typeemballage=" + typeemballage +
                '}';
    }
}

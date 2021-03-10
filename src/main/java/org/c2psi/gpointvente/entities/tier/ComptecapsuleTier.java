package org.c2psi.gpointvente.entities.tier;

import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ComptecapsuleTier {
    @Id
    String idComptecapculeTier;
    int soldeComptecapsuleTier;
    /*
    *)1 pour dire positif c'est a dire  que c'est le Tier qui doit soit verser les capsules  ou les
    changer en produit  pour les donner au point de vente
    *)0  pour dire negatif c'est a dire que c'est le point  de vente qui doit verser les capsules ou les
    changer en produit pour les donner au Tier
     */
    int statutSoldeComptecapsuleTier;
    /*
    Il s'agit du Tier qui possede le  compte
     */
    @DBRef
    Tier tierProprietaire;
    /*
    Il s'agit du  produit vendu  dans le point  de vente ou le tier concerne est client et
    pour lequel  le compte a été crée
     */
    @DBRef
    ProduitFormateUnite produitFormateUnite;

    public ComptecapsuleTier() {
    }

    public ComptecapsuleTier(String idComptecapculeTier, int soldeComptecapsuleTier,
                             int statutSoldeComptecapsuleTier, Tier tierProprietaire,
                             ProduitFormateUnite produitFormateUnite) {
        this.idComptecapculeTier = idComptecapculeTier;
        this.soldeComptecapsuleTier = soldeComptecapsuleTier;
        this.statutSoldeComptecapsuleTier = statutSoldeComptecapsuleTier;
        this.tierProprietaire = tierProprietaire;
        this.produitFormateUnite = produitFormateUnite;
    }

    public String getIdComptecapculeTier() {
        return idComptecapculeTier;
    }

    public void setIdComptecapculeTier(String idComptecapculeTier) {
        this.idComptecapculeTier = idComptecapculeTier;
    }

    public int getSoldeComptecapsuleTier() {
        return soldeComptecapsuleTier;
    }

    public void setSoldeComptecapsuleTier(int soldeComptecapsuleTier) {
        this.soldeComptecapsuleTier = soldeComptecapsuleTier;
    }

    public int getStatutSoldeComptecapsuleTier() {
        return statutSoldeComptecapsuleTier;
    }

    public void setStatutSoldeComptecapsuleTier(int statutSoldeComptecapsuleTier) {
        this.statutSoldeComptecapsuleTier = statutSoldeComptecapsuleTier;
    }

    public Tier getTierProprietaire() {
        return tierProprietaire;
    }

    public void setTierProprietaire(Tier tierProprietaire) {
        this.tierProprietaire = tierProprietaire;
    }

    public ProduitFormateUnite getProduitFormateUnite() {
        return produitFormateUnite;
    }

    public void setProduitFormateUnite(ProduitFormateUnite produitFormateUnite) {
        this.produitFormateUnite = produitFormateUnite;
    }

    @Override
    public String toString() {
        return "ComptecapsuleTier{" +
                "idComptecapculeTier='" + idComptecapculeTier + '\'' +
                ", soldeComptecapsuleTier=" + soldeComptecapsuleTier +
                ", statutSoldeComptecapsuleTier=" + statutSoldeComptecapsuleTier +
                ", tierProprietaire=" + tierProprietaire +
                ", produitFormateUnite=" + produitFormateUnite +
                '}';
    }
}

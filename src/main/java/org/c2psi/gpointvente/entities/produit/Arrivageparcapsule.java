package org.c2psi.gpointvente.entities.produit;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapprocapsule;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Arrivageparcapsule {
    String idArrivageparcapsule;
    int quantitecapsulechange;
    int quantitelivree;
    /******************************************************
     * Un arrivage par espece sur un produit est tout de meme
     * un arrivage
     */
    @DBRef
    ArrivageProduitformate arrivageProduitformate;
    /******************************************************
     * Un arrivage par capsule pour un produit peut etre
     * associe a une facture (si l'arrivage est normal) ou
     * a rien si l'arrivage n'est pas normal (ponctuel,
     * decomposition ou recomposition)
     */
    @DBRef
    Factureapprocapsule factureapprocapsule;

    public Arrivageparcapsule() {
    }

    public Arrivageparcapsule(String idArrivageparcapsule, int quantitecapsulechange, int quantitelivree,
                              ArrivageProduitformate arrivageProduitformate,
                              Factureapprocapsule factureapprocapsule) {
        this.idArrivageparcapsule = idArrivageparcapsule;
        this.quantitecapsulechange = quantitecapsulechange;
        this.quantitelivree = quantitelivree;
        this.arrivageProduitformate = arrivageProduitformate;
        this.factureapprocapsule = factureapprocapsule;
    }

    public String getIdArrivageparcapsule() {
        return idArrivageparcapsule;
    }

    public void setIdArrivageparcapsule(String idArrivageparcapsule) {
        this.idArrivageparcapsule = idArrivageparcapsule;
    }

    public int getQuantitecapsulechange() {
        return quantitecapsulechange;
    }

    public void setQuantitecapsulechange(int quantitecapsulechange) {
        this.quantitecapsulechange = quantitecapsulechange;
    }

    public int getQuantitelivree() {
        return quantitelivree;
    }

    public void setQuantitelivree(int quantitelivree) {
        this.quantitelivree = quantitelivree;
    }

    public ArrivageProduitformate getArrivageProduitformate() {
        return arrivageProduitformate;
    }

    public void setArrivageProduitformate(ArrivageProduitformate arrivageProduitformate) {
        this.arrivageProduitformate = arrivageProduitformate;
    }

    public Factureapprocapsule getFactureapprocapsule() {
        return factureapprocapsule;
    }

    public void setFactureapprocapsule(Factureapprocapsule factureapprocapsule) {
        this.factureapprocapsule = factureapprocapsule;
    }
}

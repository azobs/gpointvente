package org.c2psi.gpointvente.entities.produit;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Arrivageparespece {
    @Id
    String idArrivageparespece;
    int quantitelivre;
    double prixachatunitaire;
    /******************************************************
     * Un arrivage par espece sur un produit est tout de meme
     * un arrivage
     */
    @DBRef
    ArrivageProduitformate arrivageProduitformate;
    /******************************************************
     * Un arrivage par espece pour un produit peut etre a
     * associe a une facture (si l'arrivage est normal) ou
     * a rien si l'arrivage n'est pas normal (ponctuel,
     * decomposition ou recomposition)
     */
    @DBRef
    Factureapproespece factureapproespece;

    public Arrivageparespece() {
    }

    public Arrivageparespece(String idArrivageparespece, int quantitelivre, double prixachatunitaire,
                             ArrivageProduitformate arrivageProduitformate,
                             Factureapproespece factureapproespece) {
        this.idArrivageparespece = idArrivageparespece;
        this.quantitelivre = quantitelivre;
        this.prixachatunitaire = prixachatunitaire;
        this.arrivageProduitformate = arrivageProduitformate;
        this.factureapproespece = factureapproespece;
    }

    public String getIdArrivageparespece() {
        return idArrivageparespece;
    }

    public void setIdArrivageparespece(String idArrivageparespece) {
        this.idArrivageparespece = idArrivageparespece;
    }

    public int getQuantitelivre() {
        return quantitelivre;
    }

    public void setQuantitelivre(int quantitelivre) {
        this.quantitelivre = quantitelivre;
    }

    public double getPrixachatunitaire() {
        return prixachatunitaire;
    }

    public void setPrixachatunitaire(double prixachatunitaire) {
        this.prixachatunitaire = prixachatunitaire;
    }

    public ArrivageProduitformate getArrivageProduitformate() {
        return arrivageProduitformate;
    }

    public void setArrivageProduitformate(ArrivageProduitformate arrivageProduitformate) {
        this.arrivageProduitformate = arrivageProduitformate;
    }

    public Factureapproespece getFactureapproespece() {
        return factureapproespece;
    }

    public void setFactureapproespece(Factureapproespece factureapproespece) {
        this.factureapproespece = factureapproespece;
    }
}

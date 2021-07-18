package org.c2psi.gpointvente.entities.produit;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document
public class ArrivageProduitformate {
    @Id
    String idArrivageProduitFormate;
    Date dateheurelivraisonArrivage;
    Date dateperemption;
    Date dateseuilperemption;
    /*********************************************
     * Le typeArrivage depend de comment le produit est
     * entrer dans le stock. Un produit en stock peut arriver
     * Pontuellement ie sans aucune facture: typeArrivage = ponctuel
     * Apres un achat formel chez le fournisseur: typeArrivage = normal
     * Après une decomposition d'un produit deja en stock: typeArrivege = decomposition
     * Apres recomposition d'un ensemble de produit deja en stock: typeArrivage = recomposition
     */
    String typeArrivage;

    @DBRef
    ProduitFormateUnite produitformateConcerne;
    @DBRef
    Pointvente pointvente;

    public ArrivageProduitformate() {
    }

    public ProduitFormateUnite getProduitformateConcerne() {
        return produitformateConcerne;
    }



    public String getIdArrivageProduitFormate() {
        return idArrivageProduitFormate;
    }

    public void setIdArrivageProduitFormate(String idArrivageProduitFormate) {
        this.idArrivageProduitFormate = idArrivageProduitFormate;
    }

    public ArrivageProduitformate(String idArrivageProduitFormate, Date dateheurelivraisonArrivage,
                                   Date dateperemption, Date dateseuilperemption,
                                  String typeArrivage,
                                  ProduitFormateUnite produitformateConcerne, Pointvente pointvente) {
        this.idArrivageProduitFormate = idArrivageProduitFormate;
        this.dateheurelivraisonArrivage = dateheurelivraisonArrivage;
        this.dateperemption = dateperemption;
        this.dateseuilperemption = dateseuilperemption;
        this.typeArrivage = typeArrivage;
        this.produitformateConcerne = produitformateConcerne;
        this.pointvente = pointvente;
    }

    public Date getDateheurelivraisonArrivage() {
        return dateheurelivraisonArrivage;
    }

    public void setDateheurelivraisonArrivage(Date dateheurelivraisonArrivage) {
        this.dateheurelivraisonArrivage = dateheurelivraisonArrivage;
    }




    public Date getDateperemption() {
        return dateperemption;
    }

    public void setDateperemption(Date dateperemption) {
        this.dateperemption = dateperemption;
    }

    public Date getDateseuilperemption() {
        return dateseuilperemption;
    }

    public void setDateseuilperemption(Date dateseuilperemption) {
        this.dateseuilperemption = dateseuilperemption;
    }

    public String getTypeArrivage() {
        return typeArrivage;
    }

    public void setTypeArrivage(String typeArrivage) {
        this.typeArrivage = typeArrivage;
    }

    public void setProduitformateConcerne(ProduitFormateUnite produitformateConcerne) {
        this.produitformateConcerne = produitformateConcerne;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }
}

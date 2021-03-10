package org.c2psi.gpointvente.entities.produit;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.prix.Prixdebase;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Un produitFormateU est un produit dont une unité de vente vient d'etre selectionne.
 * L'administrateur choisit pour un produit formate une unite dans laquelle le produit sera vendu
 * et le resultat de cette configuration est materialise par cette entite
 */
@Document
public class ProduitFormateUnite {
    @Id
    String idPFU;
    int seuilqte;
    int limitebassesemigros;
    int limitebassegros;
    String commentairePFU;
    String codePFU;

    /**
     * Chaque produitFormateU a une unite qui peut permettre de le decomposer grace aux
     * regles de conversion
     */
    @DBRef
    Uniteproduit unitePFU;
    /**
     * Chaque produitFormateUnite concerne un ProduitFormate ie un produit conditionne
     */
    @DBRef
    ProduitFormate produitFormate;

    /**
     * Malgre le fait qu'a partir du produitformate associe on recupere le produit,
     * puis la famille du produit et enfin le point de vente auquel appartient la famille,
     * il faut connaitre directement le point de vente dans lequel le produitformateunite est
     * vendu. C'est une redondance importante. Ainsi, le point de vente lui même va entretenir la
     * liste des produits qu'il vend (liste des produitformateunite) meme comme il a deja la liste des
     * familles des produits qu'il vend.
     */
    @DBRef
    Pointvente pointvente;

    /**
     * Chaque produit une fois formate est associe a une unite pour etre  vendu.
     * Cette association est faite a une date bien precise
     */
    Date datePFU;

    /**
     * Chaque produitformateunite doit avoir un prix de base
     */
    @DBRef
    Prixdebase prixdebase;

    /******
     * Puisque ce produit peut aussi etre en concours a travers ses capsules, il faut associe chaque
     * produit a un comptecapsule
     */
    @DBRef
    ComptecapsulePv comptecapsulePv;

    /******************************************************************************************************
     * Ce champ permettra de suivre la quantite restant du produit dans le point de vente a chaque vente
     * et chaque arrivage. Pour chaque vente il est diminue et a chaque arrivage il est ajoute.
     * En effet, s'il n'existe pas alors pour avoir la quantite d'un produit en stock il faut recuperer
     * la liste de tous les arrivages le concernant et sommer les quantites obtenues. de plus Lors des ventes
     * les quantites vendues seront debitées des différents arrivages et le film des arrivages ne pourra
     * plus etre reconstitué.
     ******************************************************************************************************/
    int quantiteEnStock=0;

    public ProduitFormateUnite() {
    }

    public ProduitFormateUnite(String idPFU, int seuilqte, int limitebassesemigros,
                               int limitebassegros, String commentairePFU, String codePFU,
                               Uniteproduit unitePFU, ProduitFormate produitFormate,
                               Date dateProduitFormatUnite, Prixdebase prixdebase,
                               ComptecapsulePv comptecapsulePv, Pointvente pointvente) {
        this.idPFU = idPFU;
        this.seuilqte = seuilqte;
        this.limitebassesemigros = limitebassesemigros;
        this.limitebassegros = limitebassegros;
        this.commentairePFU = commentairePFU;
        this.codePFU = codePFU;
        this.unitePFU = unitePFU;
        this.produitFormate = produitFormate;
        this.datePFU = dateProduitFormatUnite;
        this.comptecapsulePv = comptecapsulePv;
        this.prixdebase = prixdebase;
        this.pointvente = pointvente;
    }

    public ProduitFormateUnite(int seuilqte, int limitebassesemigros, int limitebassegros,
                               String commentairePFU, String codePFU, Uniteproduit unitePFU,
                               ProduitFormate produitFormate, Date dateProduitFormatUnite,
                               ComptecapsulePv comptecapsulePv, Pointvente pointvente) {
        this.seuilqte = seuilqte;
        this.limitebassesemigros = limitebassesemigros;
        this.limitebassegros = limitebassegros;
        this.commentairePFU = commentairePFU;
        this.codePFU = codePFU;
        this.unitePFU = unitePFU;
        this.produitFormate = produitFormate;
        this.datePFU = dateProduitFormatUnite;
        this.comptecapsulePv = comptecapsulePv;
        this.pointvente = pointvente;
    }

    public String getIdPFU() {
        return idPFU;
    }

    public void setIdPFU(String idPFU) {
        this.idPFU = idPFU;
    }

    public int getSeuilqte() {
        return seuilqte;
    }

    public void setSeuilqte(int seuilqte) {
        this.seuilqte = seuilqte;
    }

    public int getLimitebassesemigros() {
        return limitebassesemigros;
    }

    public void setLimitebassesemigros(int limitebassesemigros) {
        this.limitebassesemigros = limitebassesemigros;
    }

    public int getLimitebassegros() {
        return limitebassegros;
    }

    public void setLimitebassegros(int limitebassegros) {
        this.limitebassegros = limitebassegros;
    }

    public String getCommentairePFU() {
        return commentairePFU;
    }

    public void setCommentairePFU(String commentairePFU) {
        this.commentairePFU = commentairePFU;
    }

    public String getCodePFU() {
        return codePFU;
    }

    public void setCodePFU(String codePFU) {
        this.codePFU = codePFU;
    }

    public Uniteproduit getUnitePFU() {
        return unitePFU;
    }

    public void setUnitePFU(Uniteproduit unitePFU) {
        this.unitePFU = unitePFU;
    }

    public ProduitFormate getProduitFormate() {
        return produitFormate;
    }

    public void setProduitFormate(ProduitFormate produitFormate) {
        this.produitFormate = produitFormate;
    }

    public Date getDateProduitFormatUnite() {
        return datePFU;
    }

    public void setDateProduitFormatUnite(Date dateProduitFormatUnite) {
        this.datePFU = dateProduitFormatUnite;
    }

    public Prixdebase getPrixdebase() {
        return prixdebase;
    }

    public void setPrixdebase(Prixdebase prixdebase) {
        this.prixdebase = prixdebase;
    }

    public ComptecapsulePv getComptecapsulePv() {
        return comptecapsulePv;
    }

    public void setComptecapsulePv(ComptecapsulePv comptecapsulePv) {
        this.comptecapsulePv = comptecapsulePv;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }

    public Date getDatePFU() {
        return datePFU;
    }

    public void setDatePFU(Date datePFU) {
        this.datePFU = datePFU;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    @Override
    public String toString() {
        return "ProduitFormateUnite{" +
                "idPFU='" + idPFU + '\'' +
                ", seuilqte=" + seuilqte +
                ", limitebassesemigros=" + limitebassesemigros +
                ", limitebassegros=" + limitebassegros +
                ", commentairePFU='" + commentairePFU + '\'' +
                ", codePFU='" + codePFU + '\'' +
                ", unitePFU=" + unitePFU +
                ", produitFormate=" + produitFormate +
                ", dateProduitFormatUnite=" + datePFU +
                ", prixdebase=" + prixdebase +
                ", comptecapsulePv=" + comptecapsulePv +
                ", pointvente =" + pointvente.getDenominationPv() +
                ", quantiteEnStock =" + quantiteEnStock +
                '}';
    }
}

package org.c2psi.gpointvente.entities.produit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Produit {
    @Id
    String idProduit;
    String designationProduitFR;
    String designationProduitEN;
    String aliasProduitFR;
    String aliasProduitEN;
    String descriptionProduitFR;
    String descriptionProduitEN;
    int perissable;

    /******************************************************************************
     * Un produit appartient toujours a une famille
     * La famille a son tour appartient toujours a un Pointvente donc
     * on pourra toujours trouver le Pointvente auquel appartient un produit.
     * Un Pointvente entretient donc une liste de famille de Produit
     ******************************************************************************/
    @DBRef
    Famille familleProduit;

    /**************************************************************************
     * Liste des formats utilises pour formate ce produit. Donc il s'agit de
     * la liste des produitformate
     ***************************************************************************/
    @DBRef
    List<ProduitFormate> listofProduitFormate = new ArrayList<ProduitFormate>();

    public Produit() {
    }

    public Produit(String idProduit, String designationProduitFR, String designationProduitEN,
                   String aliasProduitFR, String aliasProduitEN, String descriptionProduitFR,
                   String descriptionProduitEN, int perissable, Famille familleProduit) {
        this.idProduit = idProduit;
        this.designationProduitFR = designationProduitFR;
        this.designationProduitEN = designationProduitEN;
        this.aliasProduitFR = aliasProduitFR;
        this.aliasProduitEN = aliasProduitEN;
        this.descriptionProduitFR = descriptionProduitFR;
        this.descriptionProduitEN = descriptionProduitEN;
        this.perissable = perissable;
        this.familleProduit = familleProduit;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getDesignationProduitFR() {
        return designationProduitFR;
    }

    public void setDesignationProduitFR(String designationProduitFR) {
        this.designationProduitFR = designationProduitFR;
    }

    public String getDesignationProduitEN() {
        return designationProduitEN;
    }

    public void setDesignationProduitEN(String designationProduitEN) {
        this.designationProduitEN = designationProduitEN;
    }

    public String getAliasProduitFR() {
        return aliasProduitFR;
    }

    public void setAliasProduitFR(String aliasProduitFR) {
        this.aliasProduitFR = aliasProduitFR;
    }

    public String getAliasProduitEN() {
        return aliasProduitEN;
    }

    public void setAliasProduitEN(String aliasProduitEN) {
        this.aliasProduitEN = aliasProduitEN;
    }

    public String getDescriptionProduitFR() {
        return descriptionProduitFR;
    }

    public void setDescriptionProduitFR(String descriptionProduitFR) {
        this.descriptionProduitFR = descriptionProduitFR;
    }

    public String getDescriptionProduitEN() {
        return descriptionProduitEN;
    }

    public void setDescriptionProduitEN(String descriptionProduitEN) {
        this.descriptionProduitEN = descriptionProduitEN;
    }

    public int getPerissable() {
        return perissable;
    }

    public void setPerissable(int perissable) {
        this.perissable = perissable;
    }

    public Famille getFamilleProduit() {
        return familleProduit;
    }

    public void setFamilleProduit(Famille familleProduit) {
        this.familleProduit = familleProduit;
    }

    public List<ProduitFormate> getListofProduitFormate() {
        return listofProduitFormate;
    }

    public void setListofProduitFormate(List<ProduitFormate> listofProduitFormate) {
        this.listofProduitFormate = listofProduitFormate;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit='" + idProduit + '\'' +
                ", designationProduitFR='" + designationProduitFR + '\'' +
                ", designationProduitEN='" + designationProduitEN + '\'' +
                ", aliasProduitFR='" + aliasProduitFR + '\'' +
                ", aliasProduitEN='" + aliasProduitEN + '\'' +
                ", descriptionProduitFR='" + descriptionProduitFR + '\'' +
                ", descriptionProduitEN='" + descriptionProduitEN + '\'' +
                ", perissable=" + perissable +
                ", familleProduit=" + familleProduit +
                '}';
    }
}

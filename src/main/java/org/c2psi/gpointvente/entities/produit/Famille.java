package org.c2psi.gpointvente.entities.produit;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Ensemble de produit qui partage une certaine ressemblance. Une certaine similitude
 */
@Document
public class Famille {
    @Id
    String idFamille;
    String designationFamilleFR;
    String designationFamilleEN;
    String aliasFamilleFR;
    String aliasFamilleEN;
    String descriptionFamilleFR;
    String descriptionFamilleEN;
    String codeFamille;

    /**
     * Chaque famille peut etre sous famille d'une et une seule famille parente
     */
    @DBRef
    Famille familleParente;

    /**
     * Chaque famille doit entretenir sa liste de famille fille.
     */
    @DBRef
    List<Famille> listofFamilleFille = new ArrayList<>();

    /**
     * Chaque famille de produit appartient à un Point de vente. Donc c'est l'administrateur
     * du point de vente qui s'en occupe et y met le produit qu'il veut selon son point de vente
     */
    @DBRef
    Pointvente pointvente;

    @DBRef
    List<Produit> listofProduit = new ArrayList<>();

    public Famille() {
    }

    public Famille(String idFamille, String designationFamilleFR, String designationFamilleEN,
                   String aliasFamilleFR, String aliasFamilleEN, String descriptionFamilleFR,
                   String descriptionFamilleEN, String codeFamille, Famille familleParente,
                   Pointvente pointvente) {
        this.idFamille = idFamille;
        this.designationFamilleFR = designationFamilleFR;
        this.designationFamilleEN = designationFamilleEN;
        this.aliasFamilleFR = aliasFamilleFR;
        this.aliasFamilleEN = aliasFamilleEN;
        this.descriptionFamilleFR = descriptionFamilleFR;
        this.descriptionFamilleEN = descriptionFamilleEN;
        this.codeFamille = codeFamille;
        this.familleParente = familleParente;
        this.pointvente = pointvente;
    }

    public Famille(String designationFamilleFR, String designationFamilleEN,
                   String aliasFamilleFR, String aliasFamilleEN, String descriptionFamilleFR,
                   String descriptionFamilleEN, String codeFamille, Famille familleParente,
                   Pointvente pointvente) {
        this.designationFamilleFR = designationFamilleFR;
        this.designationFamilleEN = designationFamilleEN;
        this.aliasFamilleFR = aliasFamilleFR;
        this.aliasFamilleEN = aliasFamilleEN;
        this.descriptionFamilleFR = descriptionFamilleFR;
        this.descriptionFamilleEN = descriptionFamilleEN;
        this.codeFamille = codeFamille;
        this.familleParente = familleParente;
        this.pointvente = pointvente;
    }

    public String getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(String idFamille) {
        this.idFamille = idFamille;
    }

    public String getDesignationFamilleFR() {
        return designationFamilleFR;
    }

    public void setDesignationFamilleFR(String designationFamilleFR) {
        this.designationFamilleFR = designationFamilleFR;
    }

    public String getDesignationFamilleEN() {
        return designationFamilleEN;
    }

    public void setDesignationFamilleEN(String designationFamilleEN) {
        this.designationFamilleEN = designationFamilleEN;
    }

    public String getAliasFamilleFR() {
        return aliasFamilleFR;
    }

    public void setAliasFamilleFR(String aliasFamilleFR) {
        this.aliasFamilleFR = aliasFamilleFR;
    }

    public String getAliasFamilleEN() {
        return aliasFamilleEN;
    }

    public void setAliasFamilleEN(String aliasFamilleEN) {
        this.aliasFamilleEN = aliasFamilleEN;
    }

    public String getDescriptionFamilleFR() {
        return descriptionFamilleFR;
    }

    public void setDescriptionFamilleFR(String descriptionFamilleFR) {
        this.descriptionFamilleFR = descriptionFamilleFR;
    }

    public String getDescriptionFamilleEN() {
        return descriptionFamilleEN;
    }

    public void setDescriptionFamilleEN(String descriptionFamilleEN) {
        this.descriptionFamilleEN = descriptionFamilleEN;
    }

    public String getCodeFamille() {
        return codeFamille;
    }

    public void setCodeFamille(String codeFamille) {
        this.codeFamille = codeFamille;
    }

    public Famille getFamilleParente() {
        return familleParente;
    }

    public void setFamilleParente(Famille familleParente) {
        this.familleParente = familleParente;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }

    public List<Produit> getListofProduit() {
        return listofProduit;
    }

    public void setListofProduit(List<Produit> listofProduit) {
        this.listofProduit = listofProduit;
    }

    public List<Famille> getListofFamilleFille() {
        return listofFamilleFille;
    }

    public void setListofFamilleFille(List<Famille> listofFamilleFille) {
        this.listofFamilleFille = listofFamilleFille;
    }



    @Override
    public String toString() {
        return "Famille{" +
                "idFamille='" + idFamille + '\'' +
                ", designationFamilleFR='" + designationFamilleFR + '\'' +
                ", designationFamilleEN='" + designationFamilleEN + '\'' +
                ", aliasFamilleFR='" + aliasFamilleFR + '\'' +
                ", aliasFamilleEN='" + aliasFamilleEN + '\'' +
                ", descriptionFamilleFR='" + descriptionFamilleFR + '\'' +
                ", descriptionFamilleEN='" + descriptionFamilleEN + '\'' +
                ", codeFamille='" + codeFamille + '\'' +
                ", familleParente=" + familleParente.getCodeFamille() +
                ", pointvente=" + pointvente.getDenominationPv() +
                ", listofProduit=" + listofProduit.size() +
                '}';
    }
}

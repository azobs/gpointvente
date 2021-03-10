package org.c2psi.gpointvente.entities.pv;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Typeemballage {
    @Id
    String idTypeemballage;
    String designationEmballageEN;
    String designationEmballageFR;
    String descriptionEmballageEN;
    String descriptionEmballageFR;
    String couleurphareEmballage;//liste de toutes les couleurs phares séparée par une virgule
    String photoEmballage;
    Double prixEmballage;
    String matiereEmballage; //Plastique, Bouteille  cassable,  Bouteille plastique, etc.
    /*
    *Chaque type d'emballage c'est pour un Point de vente. Chaque point de vente  crée
    * ses types d'emballage à gérer
    */
    @DBRef
    Pointvente pointvente;

    /***
     * Chaque type d'emballage est lie a un compte permettant de controler le nombre
     * d'emballage pour chaque type.
     */
    @DBRef
    CompteemballagePv compteemballagePv;

    public Typeemballage() {
    }


    public Typeemballage(String idTypeemballage, String designationEmballageEN, String designationEmballageFR,
                         String descriptionEmballageEN, String couleurphareEmballage, String descriptionEmballageFR,
                         String photoEmballage, Double prixEmballage, String matiereEmballage,
                         Pointvente pointvente, CompteemballagePv compteemballagePv) {
        this.idTypeemballage = idTypeemballage;
        this.designationEmballageEN = designationEmballageEN;
        this.descriptionEmballageEN = descriptionEmballageEN;
        this.designationEmballageFR = designationEmballageFR;
        this.descriptionEmballageFR = descriptionEmballageFR;
        this.couleurphareEmballage = couleurphareEmballage;
        this.photoEmballage = photoEmballage;
        this.prixEmballage = prixEmballage;
        this.matiereEmballage = matiereEmballage;
        this.pointvente = pointvente;
        this.compteemballagePv = compteemballagePv;
    }

    public Typeemballage(String designationEmballageEN, String descriptionEmballageEN,
                         String designationEmballageFR, String descriptionEmballageFR,
                         String couleurphareEmballage, String photoEmballage,
                         Double prixEmballage, String matiereEmballage, Pointvente pointvente,
                         CompteemballagePv compteemballagePv) {
        this.designationEmballageEN = designationEmballageEN;
        this.descriptionEmballageEN = descriptionEmballageEN;
        this.designationEmballageFR = designationEmballageFR;
        this.descriptionEmballageFR = descriptionEmballageFR;
        this.couleurphareEmballage = couleurphareEmballage;
        this.photoEmballage = photoEmballage;
        this.prixEmballage = prixEmballage;
        this.matiereEmballage = matiereEmballage;
        this.pointvente = pointvente;
        this.compteemballagePv = compteemballagePv;
    }

    public String getIdTypeemballage() {
        return idTypeemballage;
    }

    public void setIdTypeemballage(String idTypeemballage) {
        this.idTypeemballage = idTypeemballage;
    }


    public String getCouleurphareEmballage() {
        return couleurphareEmballage;
    }

    public void setCouleurphareEmballage(String couleurphareEmballage) {
        this.couleurphareEmballage = couleurphareEmballage;
    }

    public String getPhotoEmballage() {
        return photoEmballage;
    }

    public void setPhotoEmballage(String photoEmballage) {
        this.photoEmballage = photoEmballage;
    }

    public Double getPrixEmballage() {
        return prixEmballage;
    }

    public void setPrixEmballage(Double prixEmballage) {
        this.prixEmballage = prixEmballage;
    }

    public String getMatiereEmballage() {
        return matiereEmballage;
    }

    public void setMatiereEmballage(String matiereEmballage) {
        this.matiereEmballage = matiereEmballage;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }

    public String getDesignationEmballageEN() {
        return designationEmballageEN;
    }

    public void setDesignationEmballageEN(String designationEmballageEN) {
        this.designationEmballageEN = designationEmballageEN;
    }

    public String getDesignationEmballageFR() {
        return designationEmballageFR;
    }

    public void setDesignationEmballageFR(String designationEmballageFR) {
        this.designationEmballageFR = designationEmballageFR;
    }

    public String getDescriptionEmballageEN() {
        return descriptionEmballageEN;
    }

    public void setDescriptionEmballageEN(String descriptionEmballageEN) {
        this.descriptionEmballageEN = descriptionEmballageEN;
    }

    public String getDescriptionEmballageFR() {
        return descriptionEmballageFR;
    }

    public void setDescriptionEmballageFR(String descriptionEmballageFR) {
        this.descriptionEmballageFR = descriptionEmballageFR;
    }

    public CompteemballagePv getCompteemballagePv() {
        return compteemballagePv;
    }

    public void setCompteemballagePv(CompteemballagePv compteemballagePv) {
        this.compteemballagePv = compteemballagePv;
    }

    @Override
    public String toString() {
        return "Typeemballage{" +
                "idTypeemballage='" + idTypeemballage + '\'' +
                ", designationEmballageEN='" + designationEmballageEN + '\'' +
                ", designationEmballageFR='" + designationEmballageFR + '\'' +
                ", descriptionEmballageEN='" + descriptionEmballageEN + '\'' +
                ", descriptionEmballageFR='" + descriptionEmballageFR + '\'' +
                ", couleurphareEmballage='" + couleurphareEmballage + '\'' +
                ", photoEmballage='" + photoEmballage + '\'' +
                ", prixEmballage='" + prixEmballage + '\'' +
                ", matiereEmballage='" + matiereEmballage + '\'' +
                ", pointvente=" + pointvente.getDenominationPv() +
                ", compteemballagePv=" + compteemballagePv.toString() +
                '}';
    }
}

package org.c2psi.gpointvente.forms.formsEnreg.pv;

import javax.validation.constraints.*;

public class FormEnregTypeemballage implements java.io.Serializable {
    @NotNull(message = "La designationEN d'un type d'emballage de produit ne peut etre null")
    @NotBlank(message = "La designationEN d'un type d'emballage de produit ne peut etre blanc")
    @NotEmpty(message = "La designationEN d'un type d'emballage de produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designationEN d'un type d'emballage de produit doit avoir au moins 2 " +
            " et au plus 25 caracteres")
    String designationEmballageEN;
    @NotNull(message = "La designationFR d'un type d'emballage de produit ne peut etre null")
    @NotBlank(message = "La designationFR d'un type d'emballage de produit ne peut etre blanc")
    @NotEmpty(message = "La designationFR d'un type d'emballage de produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designationFR d'un type d'emballage de produit doit avoir au moins 2 " +
            " et au plus 25 caracteres")
    String designationEmballageFR;
    String descriptionEmballageEN;
    String descriptionEmballageFR;
    String couleurphareEmballage;//liste de toutes les couleurs phares séparée par une virgule
    String photoEmballage;
    @Min(value=0, message = "Le prix d'un emballage ne saurait être inférieur à 0")
    Double prixEmballage;
    String matiereEmballage;
    @Min(value=0, message = "Le nombre d'emballage initial ne saurait être inférieur à 0")
    int nbreemballageInitial=0;
    @NotNull(message = "L'identifiant du point de vente d'un type d'emballage de produit ne peut etre null")
    @NotBlank(message = "L'identifiant du point de vente d'un type d'emballage de produit ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du point de vente d'un type d'emballage de produit ne peut etre une " +
            " chaine vide")
    String idPointvente;

    public FormEnregTypeemballage() {
    }

    public FormEnregTypeemballage(String designationEmballageEN, String designationEmballageFR,
                                  String descriptionEmballageEN, String descriptionEmballageFR,
                                  String couleurphareEmballage, String photoEmballage, Double prixEmballage,
                                  String matiereEmballage, int nbreemballageInitial, String idPointvente) {
        this.designationEmballageEN = designationEmballageEN;
        this.designationEmballageFR = designationEmballageFR;
        this.descriptionEmballageEN = descriptionEmballageEN;
        this.descriptionEmballageFR = descriptionEmballageFR;
        this.couleurphareEmballage = couleurphareEmballage;
        this.photoEmballage = photoEmballage;
        this.prixEmballage = prixEmballage;
        this.matiereEmballage = matiereEmballage;
        this.idPointvente = idPointvente;
        this.nbreemballageInitial = nbreemballageInitial;
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

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }

    public int getNbreemballageInitial() {
        return nbreemballageInitial;
    }

    public void setNbreemballageInitial(int nbreemballageInitial) {
        this.nbreemballageInitial = nbreemballageInitial;
    }
}

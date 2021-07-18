package org.c2psi.gpointvente.forms;

import javax.validation.constraints.*;

public class FormUpdateTypeemballage implements  java.io.Serializable {
    @NotNull(message = "L'identifiant du typeemballage ne peut etre null")
    @NotBlank(message = "L'identifiant du typeemballage ne peut etre vide")
    @NotEmpty(message = "L'identifiant du typeemballage ne peut etre vide")
    String idTypeemballage;
    @NotNull(message = "La designation du typeemballage ne peut etre null")
    @NotBlank(message = "La designation du typeemballage ne peut etre vide")
    @NotEmpty(message = "La designation du typeemballage ne peut etre vide")
    @Size(min=1, max=15, message="La designation du typeemballage doit avoir au moins 1 et au plus 15 caractères")
    String designationEmballageEN;
    @NotNull(message = "La designation du typeemballage ne peut etre null")
    @NotBlank(message = "La designation du typeemballage ne peut etre vide")
    @NotEmpty(message = "La designation du typeemballage ne peut etre vide")
    @Size(min=1, max=15, message="La designation du typeemballage doit avoir au moins 1 et au plus 15 caractères")
    String designationEmballageFR;
    @NotNull(message = "La description du typeemballage ne peut etre null")
    @NotBlank(message = "La description du typeemballage ne peut etre vide")
    @NotEmpty(message = "La description du typeemballage ne peut etre vide")
    @Size(min=1, max=15, message="La description du typeemballage doit avoir au moins 1 et au plus 15 caractères")
    String descriptionEmballageEN;
    @NotNull(message = "La description du typeemballage ne peut etre null")
    @NotBlank(message = "La description du typeemballage ne peut etre vide")
    @NotEmpty(message = "La description du typeemballage ne peut etre vide")
    @Size(min=1, max=15, message="La description du typeemballage doit avoir au moins 1 et au plus 15 caractères")
    String descriptionEmballageFR;

    String couleurphareEmballage;//liste de toutes les couleurs phares séparée par une virgule
    String photoEmballage;
    @NotNull(message = "La description du typeemballage ne peut etre null")
    @Min(value=0)
    Double prixEmballage;
    String matiereEmballage;

    public FormUpdateTypeemballage() {
    }

    public FormUpdateTypeemballage(String idTypeemballage, String designationEmballageEN,
                                   String designationEmballageFR, String descriptionEmballageEN,
                                   String descriptionEmballageFR, String couleurphareEmballage,
                                   String photoEmballage, Double prixEmballage, String matiereEmballage) {
        this.idTypeemballage = idTypeemballage;
        this.designationEmballageEN = designationEmballageEN;
        this.designationEmballageFR = designationEmballageFR;
        this.descriptionEmballageEN = descriptionEmballageEN;
        this.descriptionEmballageFR = descriptionEmballageFR;
        this.couleurphareEmballage = couleurphareEmballage;
        this.photoEmballage = photoEmballage;
        this.prixEmballage = prixEmballage;
        this.matiereEmballage = matiereEmballage;
    }

    public String getIdTypeemballage() {
        return idTypeemballage;
    }

    public void setIdTypeemballage(String idTypeemballage) {
        this.idTypeemballage = idTypeemballage;
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


}

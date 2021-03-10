package org.c2psi.gpointvente.forms.formsEnreg.produit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormEnregProduit implements java.io.Serializable {
    @NotNull(message = "La designation d'un produit ne peut etre null")
    @NotBlank(message = "La designation d'un produit ne peut etre vide")
    @NotEmpty(message = "La designation d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String designationProduitFR;
    @NotNull(message = "La designation d'un produit ne peut etre null")
    @NotBlank(message = "La designation d'un produit ne peut etre vide")
    @NotEmpty(message = "La designation d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String designationProduitEN;
    @NotNull(message = "L'alias d'un produit ne peut etre null")
    @NotBlank(message = "L'alias d'un produit ne peut etre vide")
    @NotEmpty(message = "L'alias d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String aliasProduitFR;
    @NotNull(message = "L'alias d'un produit ne peut etre null")
    @NotBlank(message = "L'alias d'un produit ne peut etre vide")
    @NotEmpty(message = "L'alias d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String aliasProduitEN;
    @NotNull(message = "La description d'un produit ne peut etre null")
    @NotBlank(message = "La description d'un produit ne peut etre vide")
    @NotEmpty(message = "La description d'un produit ne peut etre une chaine vide")
    @Size(min=2, message="La description d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String descriptionProduitFR;
    @NotNull(message = "La description d'un produit ne peut etre null")
    @NotBlank(message = "La description d'un produit ne peut etre vide")
    @NotEmpty(message = "La description d'un produit ne peut etre une chaine vide")
    @Size(min=2, message="La description d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String descriptionProduitEN;
    int perissable;

    @NotNull(message = "La famille d'un produit ne peut etre null")
    @NotBlank(message = "La famille d'un produit ne peut etre vide")
    @NotEmpty(message = "La famille d'un produit ne peut etre une chaine vide")
    String idFamilleProduit;

    public FormEnregProduit() {
    }

    public FormEnregProduit(String designationProduitFR, String designationProduitEN, String aliasProduitFR,
                            String aliasProduitEN, String descriptionProduitFR, String descriptionProduitEN,
                            int perissable, String idFamilleProduit) {
        this.designationProduitFR = designationProduitFR;
        this.designationProduitEN = designationProduitEN;
        this.aliasProduitFR = aliasProduitFR;
        this.aliasProduitEN = aliasProduitEN;
        this.descriptionProduitFR = descriptionProduitFR;
        this.descriptionProduitEN = descriptionProduitEN;
        this.perissable = perissable;
        this.idFamilleProduit = idFamilleProduit;
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

    public String getIdFamilleProduit() {
        return idFamilleProduit;
    }

    public void setIdFamilleProduit(String idFamilleProduit) {
        this.idFamilleProduit = idFamilleProduit;
    }
}

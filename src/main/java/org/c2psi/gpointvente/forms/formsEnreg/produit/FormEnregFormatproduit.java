package org.c2psi.gpointvente.forms.formsEnreg.produit;

import javax.validation.constraints.*;

public class FormEnregFormatproduit implements java.io.Serializable {
    @NotNull(message = "La designation d'un format de produit FR ne peut etre null")
    @NotBlank(message = "La designation d'un format de produit FR ne peut etre vide")
    @NotEmpty(message = "La designation d'un format de produit FR ne peut etre une chaine vide")
    @Size(min=2, max=30, message="designation d'un format de produit FR doit avoir au moins 2 et au plus 30 caracteres")
    String designationFormatproduitFR;
    @NotNull(message = "La designation d'un format de produit EN ne peut etre null")
    @NotBlank(message = "La designation d'un format de produit EN ne peut etre vide")
    @NotEmpty(message = "La designation d'un format de produit EN ne peut etre une chaine vide")
    @Size(min=2, max=30, message="designation d'un format de produit FR doit avoir au moins 2 et au plus 30 caracteres")
    String designationFormatproduitEN;
    @NotNull(message = "La contenance d'un format de produit EN ne peut etre null")
    @NotBlank(message = "La contenance d'un format de produit EN ne peut etre vide")
    @NotEmpty(message = "La contenance d'un format de produit EN ne peut etre une chaine vide")
    @Size(min=2, max=20, message="contenance d'un format de produit FR doit avoir au moins 2 et au plus 20 caracteres")
    String contenance;
    @NotNull(message = "L'identifiant du point de vente ne peut etre null")
    @NotBlank(message = "L'identifiant du point de vente ne peut etre vide")
    @NotEmpty(message = "L'identifiant du point de vente EN ne peut etre une chaine vide")
    String idPointvente;

    public FormEnregFormatproduit() {
    }

    public FormEnregFormatproduit(String designationFormatproduitFR, String designationFormatproduitEN,
                                  String contenance, String idPointvente) {
        this.designationFormatproduitFR = designationFormatproduitFR;
        this.designationFormatproduitEN = designationFormatproduitEN;
        this.contenance = contenance;
        this.idPointvente = idPointvente;
    }

    public String getDesignationFormatproduitFR() {
        return designationFormatproduitFR;
    }

    public void setDesignationFormatproduitFR(String designationFormatproduitFR) {
        this.designationFormatproduitFR = designationFormatproduitFR;
    }

    public String getDesignationFormatproduitEN() {
        return designationFormatproduitEN;
    }

    public void setDesignationFormatproduitEN(String designationFormatproduitEN) {
        this.designationFormatproduitEN = designationFormatproduitEN;
    }

    public String getContenance() {
        return contenance;
    }

    public void setContenance(String contenance) {
        this.contenance = contenance;
    }

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }
}

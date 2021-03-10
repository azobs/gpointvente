package org.c2psi.gpointvente.forms.formsEnreg.produit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormEnregUniteproduit implements java.io.Serializable {
    @NotNull(message = "Le libelle d'une unite de produit FR ne peut etre null")
    @NotBlank(message = "Le libelle d'une unite de produit FR ne peut etre vide")
    @NotEmpty(message = "Le libelle d'une unite de produit FR ne peut etre une chaine vide")
    @Size(min=2, max=30, message="Le libelle d'une unite de produit FR doit avoir au moins 2 et au plus 30 caracteres")
    String libelleUniteFR;
    @NotNull(message = "Le libelle d'une unite de produit EN ne peut etre null")
    @NotBlank(message = "Le libelle d'une unite de produit EN ne peut etre vide")
    @NotEmpty(message = "Le libelle d'une unite de produit EN ne peut etre une chaine vide")
    @Size(min=2, max=30, message="Le libelle d'une unite de produit EN doit avoir au moins 2 et au plus 30 caracteres")
    String libelleUniteEN;
    @NotNull(message = "L'abbreviation d'une unite de produit EN ne peut etre null")
    @NotBlank(message = "L'abbreviation d'une unite de produit EN ne peut etre vide")
    @NotEmpty(message = "L'abbreviation d'une unite de produit EN ne peut etre une chaine vide")
    @Size(min=2, max=30, message="L'abbreviation d'une unite de produit EN doit avoir au moins 2 et au plus 15 caracteres")
    String abbreviationUniteEN;
    @NotNull(message = "L'abbreviation d'une unite de produit FR ne peut etre null")
    @NotBlank(message = "L'abbreviation d'une unite de produit FR ne peut etre vide")
    @NotEmpty(message = "L'abbreviation d'une unite de produit FR ne peut etre une chaine vide")
    @Size(min=2, max=30, message="L'abbreviation d'une unite de produit FR doit avoir au moins 2 et au plus 30 caracteres")
    String abbreviationUniteFR;
    @NotNull(message = "Le point de vente d'une unite de produit  ne peut etre null")
    @NotBlank(message = "Le point de vente d'une unite de produit ne peut etre vide")
    @NotEmpty(message = "Le point de vente d'une unite de produit ne peut etre une chaine vide")
    String idPointvente;

    public FormEnregUniteproduit() {
    }

    public FormEnregUniteproduit(String libelleUniteFR, String libelleUniteEN, String abbreviationUniteEN,
                                 String abbreviationUniteFR, String idPointvente) {
        this.libelleUniteFR = libelleUniteFR;
        this.libelleUniteEN = libelleUniteEN;
        this.abbreviationUniteEN = abbreviationUniteEN;
        this.abbreviationUniteFR = abbreviationUniteFR;
        this.idPointvente = idPointvente;
    }

    public String getLibelleUniteFR() {
        return libelleUniteFR;
    }

    public void setLibelleUniteFR(String libelleUniteFR) {
        this.libelleUniteFR = libelleUniteFR;
    }

    public String getLibelleUniteEN() {
        return libelleUniteEN;
    }

    public void setLibelleUniteEN(String libelleUniteEN) {
        this.libelleUniteEN = libelleUniteEN;
    }

    public String getAbbreviationUniteEN() {
        return abbreviationUniteEN;
    }

    public void setAbbreviationUniteEN(String abbreviationUniteEN) {
        this.abbreviationUniteEN = abbreviationUniteEN;
    }

    public String getAbbreviationUniteFR() {
        return abbreviationUniteFR;
    }

    public void setAbbreviationUniteFR(String abbreviationUniteFR) {
        this.abbreviationUniteFR = abbreviationUniteFR;
    }

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }
}

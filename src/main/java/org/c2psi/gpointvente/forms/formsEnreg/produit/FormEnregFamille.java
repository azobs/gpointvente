package org.c2psi.gpointvente.forms.formsEnreg.produit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormEnregFamille implements java.io.Serializable {
    @NotNull(message = "La designation d'une famille ne peut etre null")
    @NotBlank(message = "La designation d'une famille de vente ne peut etre vide")
    @NotEmpty(message = "La designation d'une famille ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'une famille doit avoir au moins 2 et au plus 25 caracteres")
    String designationFamilleFR;
    @NotNull(message = "La designation d'une famille ne peut etre null")
    @NotBlank(message = "La designation d'une famille de vente ne peut etre vide")
    @NotEmpty(message = "La designation d'une famille ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'une famille doit avoir au moins 2 et au plus 25 caracteres")
    String designationFamilleEN;
    @NotNull(message = "L'alias d'une famille ne peut etre null")
    @NotBlank(message = "L'alias d'une famille de vente ne peut etre vide")
    @NotEmpty(message = "L'alias d'une famille ne peut etre une chaine vide")
    @Size(min=2, max=25, message="L'alias d'une famille doit avoir au moins 2 et au plus 25 caracteres")
    String aliasFamilleFR;
    @NotNull(message = "L'alias d'une famille ne peut etre null")
    @NotBlank(message = "L'alias d'une famille de vente ne peut etre vide")
    @NotEmpty(message = "L'alias d'une famille ne peut etre une chaine vide")
    @Size(min=2, max=25, message="L'alias d'une famille doit avoir au moins 2 et au plus 25 caracteres")
    String aliasFamilleEN;
    String descriptionFamilleFR;
    String descriptionFamilleEN;
    @NotNull(message = "Le code d'une famille ne peut etre null")
    @NotBlank(message = "Le code d'une famille de vente ne peut etre vide")
    @NotEmpty(message = "Le code d'une famille ne peut etre une chaine vide")
    @Size(min=2, max=25, message="Le code d'une famille doit avoir au moins 2 et au plus 25 caracteres")
    String codeFamille;
    String idFamilleParente;
    @NotNull(message = "L'identifiant du point de vente doit toujours etre préciser")
    @NotBlank(message = "L'identifiant du point de vente doit toujours etre préciser")
    @NotEmpty(message = "L'identifiant du point de vente doit toujours etre préciser")
    String idPointvente;

    public FormEnregFamille() {
    }

    public FormEnregFamille(String designationFamilleFR, String designationFamilleEN, String aliasFamilleFR, String aliasFamilleEN, String descriptionFamilleFR, String descriptionFamilleEN, String codeFamille, String idFamilleParente, String idPointvente) {
        this.designationFamilleFR = designationFamilleFR;
        this.designationFamilleEN = designationFamilleEN;
        this.aliasFamilleFR = aliasFamilleFR;
        this.aliasFamilleEN = aliasFamilleEN;
        this.descriptionFamilleFR = descriptionFamilleFR;
        this.descriptionFamilleEN = descriptionFamilleEN;
        this.codeFamille = codeFamille;
        this.idFamilleParente = idFamilleParente;
        this.idPointvente = idPointvente;
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

    public String getIdFamilleParente() {
        return idFamilleParente;
    }

    public void setIdFamilleParente(String idFamilleParente) {
        this.idFamilleParente = idFamilleParente;
    }

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }
}

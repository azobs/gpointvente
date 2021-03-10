package org.c2psi.gpointvente.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormUpdateDevise {
    @NotNull(message = "L'identifiant de la devise ne peut etre null")
    @NotBlank(message = "L'identifiant de la devise ne peut etre vide")
    @NotEmpty(message = "L'identifiant de la devise ne peut etre vide")
    String idDevise;
    @NotNull(message = "Le libelle en anglais de la devise ne peut etre null")
    @NotBlank(message = "Le libelle en anglais de la devise ne peut etre vide")
    @NotEmpty(message = "Le libelle en anglais de la devise ne peut etre vide")
    @Size(min=1, max=15, message="Le libelle d'une devise doit avoir au moins 1 et au plus 15 caractères")
    String libelleDeviseEN;
    @NotNull(message = "Le libelle en francais de la devise ne peut etre null")
    @NotBlank(message = "Le libelle en francais de la devise ne peut etre vide")
    @NotEmpty(message = "Le libelle en francais de la devise ne peut etre vide")
    @Size(min=1, max=15, message="Le libelle d'une devise doit avoir au moins 1 et au plus 15 caractères")
    String libelleDeviseFR;
    @NotNull(message = "L'abbreviation en anglais de la devise ne peut etre null")
    @NotBlank(message = "L'abbreviation  en anglais de la devise ne peut etre vide")
    @NotEmpty(message = "L'abbreviation  en anglais de la devise ne peut etre vide")
    @Size(min=1, max=5, message="Le libelle d'une devise doit avoir au moins 1 et au plus 5 caractères")
    String abbreviationDeviseEN;
    @NotNull(message = "L'abbreviation en francais de la devise ne peut etre null")
    @NotBlank(message = "L'abbreviation  en francais de la devise ne peut etre vide")
    @NotEmpty(message = "L'abbreviation  en francais de la devise ne peut etre vide")
    @Size(min=1, max=5, message="Le libelle d'une devise doit avoir au moins 1 et au plus 5 caractères")
    @Size(min=1, max=5, message="Le libelle d'une devise doit avoir au moins 1 et au plus 5 caractères")
    String abbreviationDeviseFR;

    String formataffichageDevise;//long moyen ou court

    public FormUpdateDevise() {
    }

    public FormUpdateDevise( String idDevise, String libelleDeviseEN, String libelleDeviseFR,  String abbreviationDeviseEN,
                             String abbreviationDeviseFR, String formataffichageDevise) {
        this.idDevise = idDevise;
        this.libelleDeviseEN = libelleDeviseEN;
        this.libelleDeviseFR = libelleDeviseFR;
        this.abbreviationDeviseEN = abbreviationDeviseEN;
        this.abbreviationDeviseFR = abbreviationDeviseFR;
        this.formataffichageDevise = formataffichageDevise;
    }

    public String getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(String idDevise) {
        this.idDevise = idDevise;
    }

    public String getLibelleDeviseEN() {
        return libelleDeviseEN;
    }

    public void setLibelleDeviseEN(String libelleDeviseEN) {
        this.libelleDeviseEN = libelleDeviseEN;
    }

    public String getLibelleDeviseFR() {
        return libelleDeviseFR;
    }

    public void setLibelleDeviseFR(String libelleDeviseFR) {
        this.libelleDeviseFR = libelleDeviseFR;
    }

    public String getAbbreviationDeviseEN() {
        return abbreviationDeviseEN;
    }

    public void setAbbreviationDeviseEN(String abbreviationDeviseEN) {
        this.abbreviationDeviseEN = abbreviationDeviseEN;
    }

    public String getAbbreviationDeviseFR() {
        return abbreviationDeviseFR;
    }

    public void setAbbreviationDeviseFR(String abbreviationDeviseFR) {
        this.abbreviationDeviseFR = abbreviationDeviseFR;
    }

    public String getFormataffichageDevise() {
        return formataffichageDevise;
    }

    public void setFormataffichageDevise(String formataffichageDevise) {
        this.formataffichageDevise = formataffichageDevise;
    }
}

package org.c2psi.gpointvente.entities.prix;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Devise {
    @Id
    String idDevise;
    String libelleDeviseEN;
    String libelleDeviseFR;
    String abbreviationDeviseEN;
    String abbreviationDeviseFR;
    /*
    FormatAffichage: LongEN; Moyen; Court; LongFR;
    LongEN des dévises: libelle (abbreviation)
    LongFR des dévises: abbreviation (libelle)
    Moyen des dévises: libelle
    Court des dévises: abbreviation
    */
    String formataffichageDevise;

    /**
     * Une Devise c'est toujours pour un point de vente. Chaque admin de point de vente
     * peut créer une nouvelle devise pour son point de vente
     */
    @JsonIgnore
    @DBRef
    Pointvente pointvente;
    /*
    Indique si la devise est une devise par defaut ou pas. Un point de vente ne peut avoir qu'une seule
    devise par defaut.
     */
    boolean deviseParDefaut=false;

    public Devise() {
    }

    public Devise(String idDevise, String libelleDeviseEN, String libelleDeviseFR,
                  String abbreviationDeviseEN, String abbreviationDeviseFR, String formataffichagedevise,
                  Pointvente pointvente) {
        this.idDevise = idDevise;
        this.libelleDeviseEN = libelleDeviseEN;
        this.libelleDeviseFR = libelleDeviseFR;
        this.abbreviationDeviseEN = abbreviationDeviseEN;
        this.abbreviationDeviseFR = abbreviationDeviseFR;
        this.formataffichageDevise = formataffichagedevise;
        this.pointvente = pointvente;
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


    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }

    public boolean isDeviseParDefaut() {
        return deviseParDefaut;
    }

    public void setDeviseParDefaut(boolean deviseParDefaut) {
        this.deviseParDefaut = deviseParDefaut;
    }

    @Override
    public String toString() {
        return "Devise{" +
                "idDevise='" + idDevise + '\'' +
                ", libelleDeviseEN='" + libelleDeviseEN + '\'' +
                ", libelleDeviseFR='" + libelleDeviseFR + '\'' +
                ", abbreviationDeviseEN='" + abbreviationDeviseEN + '\'' +
                ", abbreviationDeviseFR='" + abbreviationDeviseFR + '\'' +
                ", formataffichageDeviseEN='" + formataffichageDevise + '\'' +
                ", pointvente=" + pointvente.getDenominationPv() +
                ", deviseParDefaut=" + deviseParDefaut +
                '}';
    }
}

package org.c2psi.gpointvente.entities.pv;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Adresse {
    @Id
    String idAdresse;
    String numtel1Adr;
    String numtel2Adr;
    String numtel3Adr;
    String emailAdr;
    String quartierAdr;
    String villeAdr;
    String paysAdr;
    String planlocalisationAdr;

    public Adresse() {
    }

    public Adresse(String idAdresse, String numtel1Adr, String numtel2Adr, String numtel3Adr,
                   String emailAdr, String quartierAdr, String villeAdr, String paysAdr,
                   String planlocalisationAdr) {
        this.idAdresse = idAdresse;
        this.numtel1Adr = numtel1Adr;
        this.numtel2Adr = numtel2Adr;
        this.numtel3Adr = numtel3Adr;
        this.emailAdr = emailAdr;
        this.quartierAdr = quartierAdr;
        this.villeAdr = villeAdr;
        this.paysAdr = paysAdr;
        this.planlocalisationAdr = planlocalisationAdr;
    }

    public String getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(String idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getNumtel1Adr() {
        return numtel1Adr;
    }

    public void setNumtel1Adr(String numtel1Adr) {
        this.numtel1Adr = numtel1Adr;
    }

    public String getNumtel2Adr() {
        return numtel2Adr;
    }

    public void setNumtel2Adr(String numtel2Adr) {
        this.numtel2Adr = numtel2Adr;
    }

    public String getNumtel3Adr() {
        return numtel3Adr;
    }

    public void setNumtel3Adr(String numtel3Adr) {
        this.numtel3Adr = numtel3Adr;
    }

    public String getEmailAdr() {
        return emailAdr;
    }

    public void setEmailAdr(String emailAdr) {
        this.emailAdr = emailAdr;
    }

    public String getQuartierAdr() {
        return quartierAdr;
    }

    public void setQuartierAdr(String quartierAdr) {
        this.quartierAdr = quartierAdr;
    }

    public String getVilleAdr() {
        return villeAdr;
    }

    public void setVilleAdr(String villeAdr) {
        this.villeAdr = villeAdr;
    }

    public String getPaysAdr() {
        return paysAdr;
    }

    public void setPaysAdr(String paysAdr) {
        this.paysAdr = paysAdr;
    }

    public String getPlanlocalisationAdr() {
        return planlocalisationAdr;
    }

    public void setPlanlocalisationAdr(String planlocalisationAdr) {
        this.planlocalisationAdr = planlocalisationAdr;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "idAdresse='" + idAdresse + '\'' +
                ", numtel1Adr='" + numtel1Adr + '\'' +
                ", numtel2Adr='" + numtel2Adr + '\'' +
                ", numtel3Adr='" + numtel3Adr + '\'' +
                ", emailAdr='" + emailAdr + '\'' +
                ", quartierAdr='" + quartierAdr + '\'' +
                ", villeAdr='" + villeAdr + '\'' +
                ", paysAdr='" + paysAdr + '\'' +
                ", planlocalisationAdr='" + planlocalisationAdr + '\'' +
                '}';
    }
}

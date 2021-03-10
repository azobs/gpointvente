package org.c2psi.gpointvente.entities.pv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
public class Entreprise {
    @Id
    String idEntreprise;
    String regimeEntr;
    String raisonsocialeEntr;
    String descriptionEntr;
    String logoEntr;
    String deviseEntr;
    @Indexed(unique=true)
    String sigleEntr;
    @JsonIgnore
    @DBRef
    Collection<Pointvente> listofPointvente = new ArrayList<Pointvente>();
    @Transient
    int nbrePointvente = listofPointvente.size();

    public Entreprise() {
    }

    public Entreprise(String idEntreprise, String regimeEntr, String raisonsocialeEntr,
                      String descriptionEntr, String logoEntr, String deviseEntr, String sigleEntr,
                      Collection<Pointvente> listofPointvente, int nbrePointvente) {
        this.idEntreprise = idEntreprise;
        this.regimeEntr = regimeEntr;
        this.raisonsocialeEntr = raisonsocialeEntr;
        this.descriptionEntr = descriptionEntr;
        this.logoEntr = logoEntr;
        this.deviseEntr = deviseEntr;
        this.sigleEntr = sigleEntr;
        this.listofPointvente = listofPointvente;
        this.nbrePointvente = nbrePointvente;
    }

    public Entreprise(String regimeEntr, String raisonsocialeEntr, String descriptionEntr,
                      String logoEntr, String deviseEntr, String sigleEntr,
                      Collection<Pointvente> listofPointvente) {
        this.regimeEntr = regimeEntr;
        this.raisonsocialeEntr = raisonsocialeEntr;
        this.descriptionEntr = descriptionEntr;
        this.logoEntr = logoEntr;
        this.deviseEntr = deviseEntr;
        this.sigleEntr = sigleEntr;
        this.listofPointvente = listofPointvente;
    }

    public Entreprise(String regimeEntr, String raisonsocialeEntr, String descriptionEntr,
                      String logoEntr, String deviseEntr, String sigleEntr) {
        this.regimeEntr = regimeEntr;
        this.raisonsocialeEntr = raisonsocialeEntr;
        this.descriptionEntr = descriptionEntr;
        this.logoEntr = logoEntr;
        this.deviseEntr = deviseEntr;
        this.sigleEntr = sigleEntr;
    }



    public String getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(String idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getRegimeEntr() {
        return regimeEntr;
    }

    public void setRegimeEntr(String regimeEntr) {
        this.regimeEntr = regimeEntr;
    }

    public String getRaisonsocialeEntr() {
        return raisonsocialeEntr;
    }

    public void setRaisonsocialeEntr(String raisonsocialeEntr) {
        this.raisonsocialeEntr = raisonsocialeEntr;
    }

    public String getDescriptionEntr() {
        return descriptionEntr;
    }

    public void setDescriptionEntr(String descriptionEntr) {
        this.descriptionEntr = descriptionEntr;
    }

    public String getLogoEntr() {
        return logoEntr;
    }

    public void setLogoEntr(String logoEntr) {
        this.logoEntr = logoEntr;
    }

    public String getDeviseEntr() {
        return deviseEntr;
    }

    public void setDeviseEntr(String deviseEntr) {
        this.deviseEntr = deviseEntr;
    }

    public String getSigleEntr() {
        return sigleEntr;
    }

    public void setSigleEntr(String sigleEntr) {
        this.sigleEntr = sigleEntr;
    }

    public Collection<Pointvente> getListofPointvente() {

        return listofPointvente;
    }

    public void setListofPointvente(Collection<Pointvente> listofPointvente) {
        this.listofPointvente = listofPointvente;
    }

    public int getNbrePointvente() {
        return listofPointvente.size();
    }

    public void setNbrePointvente(int nbrePointvente) {
        this.nbrePointvente = listofPointvente.size();
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "idEntreprise='" + idEntreprise + '\'' +
                ", regimeEntr='" + regimeEntr + '\'' +
                ", raisonsocialeEntr='" + raisonsocialeEntr + '\'' +
                ", descriptionEntr='" + descriptionEntr + '\'' +
                ", logoEntr='" + logoEntr + '\'' +
                ", deviseEntr='" + deviseEntr + '\'' +
                ", sigleEntr='" + sigleEntr + '\'' +
                ", Nombre de point de vente ='" + listofPointvente.size()  +
                "'}";
    }
}

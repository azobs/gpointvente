package org.c2psi.gpointvente.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormUpdateEntreprise implements java.io.Serializable {
    String idEntreprise;
    /*
    message='{cle}' ou cle represente la cle du message dans le ressourceBundle
     */
    @NotNull(message = "le regime ne peut etre null")
    @NotBlank(message = "le regime ne peut etre vide")
    @NotEmpty(message = "le regime ne peut etre une chaine vide")
    @Size(min=2, max=25, message="le regime doit avoir au moins 2 et au plus 25 caracteres")
    String regimeEntr;
    String raisonsocialeEntr;
    String descriptionEntr;
    String logoEntr;
    String deviseEntr;
    String sigleEntr;

    public FormUpdateEntreprise(String idEntreprise, String regimeEntr, String raisonsocialeEntr,
                                String descriptionEntr, String logoEntr, String deviseEntr,
                                String sigleEntr) {
        this.idEntreprise = idEntreprise;
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
}

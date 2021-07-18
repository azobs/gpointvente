package org.c2psi.gpointvente.forms.formsEnreg.pv;

import javax.validation.constraints.*;

public class FormEnregAdresse implements java.io.Serializable {
    @NotNull(message = "Le premier numero de telephone dans une adresse ne peut etre null")
    @NotBlank(message = "Le premier numero de telephone dans une adresse ne peut etre vide")
    @NotEmpty(message = "Le premier numero de telephone dans une adresse ne peut etre une chaine vide")
    @Size(min=9, max=13, message="Le numero de telephone doit avoir au moins 9 et au plus 13 caracteres")
    String numtel1Adr;
    @Size(min=9, max=13, message="Le numero de telephone doit avoir au moins 9 et au plus 13 caracteres")
    String numtel2Adr;
    @Size(min=9, max=13, message="Le numero de telephone doit avoir au moins 9 et au plus 13 caracteres")
    String numtel3Adr;
    @Email(message = "L'adresse email saisi n'est pas valide")
    String emailAdr;
    String quartierAdr;
    String villeAdr;
    String paysAdr;
    String planlocalisationAdr;

    public FormEnregAdresse() {
    }

    public FormEnregAdresse(String numtel1Adr, String numtel2Adr, String numtel3Adr, String emailAdr, String quartierAdr, String villeAdr, String paysAdr, String planlocalisationAdr) {
        this.numtel1Adr = numtel1Adr;
        this.numtel2Adr = numtel2Adr;
        this.numtel3Adr = numtel3Adr;
        this.emailAdr = emailAdr;
        this.quartierAdr = quartierAdr;
        this.villeAdr = villeAdr;
        this.paysAdr = paysAdr;
        this.planlocalisationAdr = planlocalisationAdr;
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
}

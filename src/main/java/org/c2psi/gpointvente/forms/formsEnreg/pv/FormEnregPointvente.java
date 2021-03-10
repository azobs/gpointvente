package org.c2psi.gpointvente.forms.formsEnreg.pv;


import javax.validation.constraints.*;

public class FormEnregPointvente implements java.io.Serializable {
    String descriptionPv;
    @NotNull(message = "La denominiation d'un point de vente ne peut etre null")
    @NotBlank(message = "La denominiation d'un point de vente ne peut etre vide")
    @NotEmpty(message = "La denominiation d'un point de vente ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La denominiation d'un point de vente doit avoir au moins 2 et au plus 25 caracteres")
    String denominationPv;
    String idAdresse;
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
    Double soldeInitialCompteprincipal;
    @NotNull(message = "L'identifiant de l'entreprise pour laquelle le point de vente est enregistre ne peut etre null")
    @NotBlank(message = "L'identifiant de l'entreprise pour laquelle le point de vente est enregistre ne peut etre vide")
    @NotEmpty(message = "L'identifiant de l'entreprise pour laquelle le point de vente est enregistre ne peut etre vide")
    String idEntreprise;

    public FormEnregPointvente(String descriptionPv, String idAdresse, String quartierAdr,
                               String villeAdr, String paysAdr, String planlocalisationAdr,
                               Double soldeInitialCompteprincipal, String idEntreprise) {
        this.descriptionPv = descriptionPv;
        this.denominationPv = denominationPv;
        this.idAdresse = idAdresse;
        this.numtel1Adr = numtel1Adr;
        this.numtel2Adr = numtel2Adr;
        this.numtel3Adr = numtel3Adr;
        this.emailAdr = emailAdr;
        this.quartierAdr = quartierAdr;
        this.villeAdr = villeAdr;
        this.paysAdr = paysAdr;
        this.planlocalisationAdr = planlocalisationAdr;
        this.soldeInitialCompteprincipal = soldeInitialCompteprincipal;
        this.idEntreprise = idEntreprise;
    }

    public FormEnregPointvente() {
    }

    public String getDescriptionPv() {
        return descriptionPv;
    }

    public void setDescriptionPv(String descriptionPv) {
        this.descriptionPv = descriptionPv;
    }

    public String getDenominationPv() {
        return denominationPv;
    }

    public void setDenominationPv(String denominationPv) {
        this.denominationPv = denominationPv;
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

    public Double getSoldeInitialCompteprincipal() {
        return soldeInitialCompteprincipal;
    }

    public void setSoldeInitialCompteprincipal(Double soldeInitialCompteprincipal) {
        this.soldeInitialCompteprincipal = soldeInitialCompteprincipal;
    }

    public String getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(String idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
}

package org.c2psi.gpointvente.forms;

import javax.validation.constraints.*;

public class FormUpdateAdresse implements java.io.Serializable{
    /*
    Le proprietaire d'une adresse peut etre un pointvente ou un utilisateur
     */
    @NotNull(message = "L'identifiant du proprietaite d'une adresse ne peut etre null")
    @NotBlank(message = "L'identifiant du proprietaite d'une adresse ne peut etre vide")
    String idPropAdresse;
    @NotNull(message = "Le premier numero de telephone dans une adresse ne peut etre null")
    @NotBlank(message = "Le premier numero de telephone dans une adresse ne peut etre vide")
    String idAdresseAModifier;
    @NotNull(message = "Le premier numero de telephone dans une adresse ne peut etre null")
    @NotBlank(message = "Le premier numero de telephone dans une adresse ne peut etre vide")
    @NotEmpty(message = "Le premier numero de telephone dans une adresse ne peut etre une chaine vide")
    @Size(min=9, max=13, message="Le numero de telephone doit avoir au moins 9 et au plus 13 caracteres")
    String newnumtel1Adr;
    @Size(min=9, max=13, message="Le numero de telephone doit avoir au moins 9 et au plus 13 caracteres")
    String newnumtel2Adr;
    @Size(min=9, max=13, message="Le numero de telephone doit avoir au moins 9 et au plus 13 caracteres")
    String newnumtel3Adr;
    @Email(message = "L'adresse email saisi n'est pas valide")
    String newemailAdr;
    String newquartierAdr;
    String newvilleAdr;
    String newpaysAdr;
    String newplanlocalisationAdr;


    public FormUpdateAdresse() {
    }

    public FormUpdateAdresse(String idPropAdresse, String idAdresseAModifier, String newnumtel1Adr, String newnumtel2Adr,
                             String newnumtel3Adr, String newemailAdr, String newquartierAdr,
                             String newvilleAdr, String newpaysAdr, String newplanlocalisationAdr) {
        this.idPropAdresse = idPropAdresse;
        this.idAdresseAModifier = idAdresseAModifier;
        this.newnumtel1Adr = newnumtel1Adr;
        this.newnumtel2Adr = newnumtel2Adr;
        this.newnumtel3Adr = newnumtel3Adr;
        this.newemailAdr = newemailAdr;
        this.newquartierAdr = newquartierAdr;
        this.newvilleAdr = newvilleAdr;
        this.newpaysAdr = newpaysAdr;
        this.newplanlocalisationAdr = newplanlocalisationAdr;
    }

    public String getIdAdresseAModifier() {
        return idAdresseAModifier;
    }

    public void setIdAdresseAModifier(String idAdresseAModifier) {
        this.idAdresseAModifier = idAdresseAModifier;
    }

    public String getNewnumtel1Adr() {
        return newnumtel1Adr;
    }

    public void setNewnumtel1Adr(String newnumtel1Adr) {
        this.newnumtel1Adr = newnumtel1Adr;
    }

    public String getNewnumtel2Adr() {
        return newnumtel2Adr;
    }

    public void setNewnumtel2Adr(String newnumtel2Adr) {
        this.newnumtel2Adr = newnumtel2Adr;
    }

    public String getNewnumtel3Adr() {
        return newnumtel3Adr;
    }

    public void setNewnumtel3Adr(String newnumtel3Adr) {
        this.newnumtel3Adr = newnumtel3Adr;
    }

    public String getNewemailAdr() {
        return newemailAdr;
    }

    public void setNewemailAdr(String newemailAdr) {
        this.newemailAdr = newemailAdr;
    }

    public String getNewquartierAdr() {
        return newquartierAdr;
    }

    public void setNewquartierAdr(String newquartierAdr) {
        this.newquartierAdr = newquartierAdr;
    }

    public String getNewvilleAdr() {
        return newvilleAdr;
    }

    public void setNewvilleAdr(String newvilleAdr) {
        this.newvilleAdr = newvilleAdr;
    }

    public String getNewpaysAdr() {
        return newpaysAdr;
    }

    public void setNewpaysAdr(String newpaysAdr) {
        this.newpaysAdr = newpaysAdr;
    }

    public String getNewplanlocalisationAdr() {
        return newplanlocalisationAdr;
    }

    public void setNewplanlocalisationAdr(String newplanlocalisationAdr) {
        this.newplanlocalisationAdr = newplanlocalisationAdr;
    }

    public String getIdPropAdresse() {
        return idPropAdresse;
    }

    public void setIdPropAdresse(String idPropAdresse) {
        this.idPropAdresse = idPropAdresse;
    }
}

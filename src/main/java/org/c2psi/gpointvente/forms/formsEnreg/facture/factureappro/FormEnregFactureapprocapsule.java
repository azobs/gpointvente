package org.c2psi.gpointvente.forms.formsEnreg.facture.factureappro;

import javax.validation.constraints.*;

public class FormEnregFactureapprocapsule implements java.io.Serializable {
    @NotNull(message = "Le numero de la facture ne peut etre null")
    @NotBlank(message = "Le numero de la facture ne peut etre blanc")
    @NotEmpty(message = "Le numero de la facture ne peut etre une chaine vide")
    @Size(min=2, max=25, message="Le numero de la facture doit avoir au moins 2 et au plus 25 caracteres")
    String numeroFacture;
    @NotNull(message = "La date et l'heure de la facture ne peut etre null")
    @NotBlank(message = "La date et l'heure de la facture ne peut etre blanc")
    @NotEmpty(message = "La date et l'heure de la facture ne peut etre une chaine vide")
    @Size(max=20, message="La date et l'heure de la facture doit avoir au plus 20 caracteres yyyy-MM-dd HH:mm:ss")
    String dateheureFacture;
    String observation;
    @NotNull(message = "Le nom du fournisseur de la facture ne peut etre null")
    @NotBlank(message = "Le nom du fournisseur de la facture ne peut etre blanc")
    @NotEmpty(message = "Le nom du fournisseur de la facture ne peut etre une chaine vide")
    @Size(min=2, max=25, message="Le nom du fournisseur de la facture doit avoir au moins 2 et au plus 25 caracteres")
    String nomFournisseur;

    /************************
     * Champ concernant la factureapprocapsule associe
     */
    @Min(value=0, message = "L'estimation de la valeur des capsules d'une facture ne saurait etre inferieur a 0")
    double estimationvaleur;
    @Min(value=0, message = "Le nombre de capsule changé d'une facture ne saurait etre inferieur a 0")
    int nbrecapsulechange;
    @Min(value=0, message = "Le nombre de capsule à changer d'une facture ne saurait etre inferieur a 0")
    int nbrecapsuleAchange;

    public FormEnregFactureapprocapsule() {
    }

    public FormEnregFactureapprocapsule(String numeroFacture, String dateheureFacture, String observation,
                                        String nomFournisseur, double estimationvaleur, int nbrecapsulechange,
                                        int nbrecapsuleAchange) {
        this.numeroFacture = numeroFacture;
        this.dateheureFacture = dateheureFacture;
        this.observation = observation;
        this.nomFournisseur = nomFournisseur;
        this.estimationvaleur = estimationvaleur;
        this.nbrecapsulechange = nbrecapsulechange;
        this.nbrecapsuleAchange = nbrecapsuleAchange;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public String getDateheureFacture() {
        return dateheureFacture;
    }

    public void setDateheureFacture(String dateheureFacture) {
        this.dateheureFacture = dateheureFacture;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public double getEstimationvaleur() {
        return estimationvaleur;
    }

    public void setEstimationvaleur(double estimationvaleur) {
        this.estimationvaleur = estimationvaleur;
    }

    public int getNbrecapsulechange() {
        return nbrecapsulechange;
    }

    public void setNbrecapsulechange(int nbrecapsulechange) {
        this.nbrecapsulechange = nbrecapsulechange;
    }

    public int getNbrecapsuleAchange() {
        return nbrecapsuleAchange;
    }

    public void setNbrecapsuleAchange(int nbrecapsuleAchange) {
        this.nbrecapsuleAchange = nbrecapsuleAchange;
    }
}

package org.c2psi.gpointvente.forms.formsEnreg.facture.factureappro;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class FormEnregFactureapproespece implements java.io.Serializable {
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

    /********************
     * Champ concernant la factureapproespece
     */
    @Min(value=0, message = "Le montant attendu d'une facture ne saurait etre inferieur a 0")
    double montantAttendu;
    @Min(value=0, message = "Le montant attendu d'une facture ne saurait etre inferieur a 0")
    double montantVerse;

    public FormEnregFactureapproespece() {
    }

    public FormEnregFactureapproespece( String numeroFacture,  String dateheureFacture, String observation,
                                        String nomFournisseur, double montantAttendu, double montantVerse) {
        this.numeroFacture = numeroFacture;
        this.dateheureFacture = dateheureFacture;
        this.observation = observation;
        this.nomFournisseur = nomFournisseur;
        this.montantAttendu = montantAttendu;
        this.montantVerse = montantVerse;
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

    public double getMontantAttendu() {
        return montantAttendu;
    }

    public void setMontantAttendu(double montantAttendu) {
        this.montantAttendu = montantAttendu;
    }

    public double getMontantVerse() {
        return montantVerse;
    }

    public void setMontantVerse(double montantVerse) {
        this.montantVerse = montantVerse;
    }
}

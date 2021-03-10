package org.c2psi.gpointvente.forms.formsEnreg.tier;


import javax.validation.constraints.*;

public class FormEnregFournisseur implements java.io.Serializable{
    @NotNull(message = "Le nom d'un fournisseur ne peut etre null")
    @NotBlank(message = "Le nom d'un fournisseur ne peut etre blanc")
    @NotEmpty(message = "Le nom d'un fournisseur ne peut etre une chaine vide")
    @Size(min=2, max=25, message="Le nom d'un fournisseur doit avoir au moins 2 et au plus 25 caracteres")
    String nomsFournisseur;
    @NotNull(message = "L'alias d'un fournisseur ne peut etre null")
    @NotBlank(message = "L'alias d'un fournisseur ne peut etre blanc")
    @NotEmpty(message = "L'alias d'un fournisseur ne peut etre une chaine vide")
    @Size(min=2, max=25, message="L'alias d'un fournisseur doit avoir au moins 2 et au plus 25 caracteres")
    String aliasFournisseur;
    @NotNull(message = "La langue d'un fournisseur ne peut etre null")
    @NotBlank(message = "La langue d'un fournisseur ne peut etre blanc")
    @NotEmpty(message = "La langue d'un fournisseur ne peut etre une chaine vide")
    @Size(min=2, max=25, message="Le nom d'un fournisseur doit avoir au moins 2 et au plus 25 caracteres")
    String languepardefautFournisseur;
    String observation;
    String idAdresse;
    @NotNull(message = "L'identifiant du point de vente du fournisseur ne peut etre null")
    String idPointvente;

    public FormEnregFournisseur() {
    }

    public FormEnregFournisseur(String nomsTier, String aliasTier, String languepardefautTier,
                                String observation, String idAdresse,
                                String idPointvente) {
        this.nomsFournisseur = nomsTier;
        this.aliasFournisseur = aliasTier;
        this.languepardefautFournisseur = languepardefautTier;
        this.observation = observation;
        this.idAdresse = idAdresse;
        this.idPointvente = idPointvente;
    }

    public String getNomsFournisseur() {
        return nomsFournisseur;
    }

    public void setNomsFournisseur(String nomsFournisseur) {
        this.nomsFournisseur = nomsFournisseur;
    }

    public String getAliasFournisseur() {
        return aliasFournisseur;
    }

    public void setAliasFournisseur(String aliasFournisseur) {
        this.aliasFournisseur = aliasFournisseur;
    }

    public String getLanguepardefautFournisseur() {
        return languepardefautFournisseur;
    }

    public void setLanguepardefautFournisseur(String languepardefautFournisseur) {
        this.languepardefautFournisseur = languepardefautFournisseur;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(String idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }
}

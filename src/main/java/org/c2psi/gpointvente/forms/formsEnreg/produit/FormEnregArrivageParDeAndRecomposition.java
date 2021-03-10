package org.c2psi.gpointvente.forms.formsEnreg.produit;

import javax.validation.constraints.*;

public class FormEnregArrivageParDeAndRecomposition implements java.io.Serializable{
    @NotBlank(message = "La date de peremption du produit ne peut etre blanc")
    @NotEmpty(message = "La date de peremption du produit ne peut etre une chaine vide")
    @Size(max=20, message="La date de peremption du produit doit avoir au plus 20 caracteres yyyy-MM-dd")
    String dateperemption;
    @NotBlank(message = "La date seuil de peremption du produit ne peut etre blanc")
    @NotEmpty(message = "La date seuil de peremption du produit ne peut etre une chaine vide")
    @Size(max=20, message="La date seuil de peremption du produit doit avoir au plus 20 caracteres yyyy-MM-dd")
    String dateseuilperemption;
    @Positive(message = "La quantite de produit doit toujours etre une valeur positive")
    int quantiteADeOrRecomposer;
    @NotNull(message = "L'identifiant du produit source ie celui qu'on va decomposer ou utiliser " +
            "pour recomposer ne peut etre null")
    @NotBlank(message = "L'identifiant du produit source ie celui qu'on va decomposer ou utiliser " +
            "pour recomposer ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du produit source ie celui qu'on va decomposer ou utiliser " +
            "pour recomposer ne peut etre une chaine vide")
    String idproduitFormateUniteSource;
    @NotNull(message = "L'identifiant du produit destination ie celui qu'on va obtenir apres decomposition ou" +
            "apres recomposition ne peut etre null")
    @NotBlank(message = "L'identifiant du produit destination ie celui qu'on va destination ie celui qu'on va obtenir apres decomposition ou\" +\n" +
            " apres recomposition ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du produit destination ie destination ie celui qu'on va obtenir apres decomposition ou\" +\n" +
            " apres recomposition")
    String idproduitFormateUniteDestination;
    @NotNull(message = "L'identifiant du point de vente ne peut etre null")
    @NotBlank(message = "L'identifiant du point de vente ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du point de vente ne peut etre une chaine vide")
    String idPointvente;

    public FormEnregArrivageParDeAndRecomposition() {
    }

    public FormEnregArrivageParDeAndRecomposition(int quantiteADeOrRecomposer, String idproduitFormateUniteSource, String idproduitFormateUniteDestination, String idPointvente) {
        this.quantiteADeOrRecomposer = quantiteADeOrRecomposer;
        this.idproduitFormateUniteSource = idproduitFormateUniteSource;
        this.idproduitFormateUniteDestination = idproduitFormateUniteDestination;
        this.idPointvente = idPointvente;
    }

    public int getQuantiteADeOrRecomposer() {
        return quantiteADeOrRecomposer;
    }

    public void setQuantiteADeOrRecomposer(int quantiteADeOrRecomposer) {
        this.quantiteADeOrRecomposer = quantiteADeOrRecomposer;
    }

    public String getIdproduitFormateUniteSource() {
        return idproduitFormateUniteSource;
    }

    public void setIdproduitFormateUniteSource(String idproduitFormateUniteSource) {
        this.idproduitFormateUniteSource = idproduitFormateUniteSource;
    }

    public String getIdproduitFormateUniteDestination() {
        return idproduitFormateUniteDestination;
    }

    public void setIdproduitFormateUniteDestination(String idproduitFormateUniteDestination) {
        this.idproduitFormateUniteDestination = idproduitFormateUniteDestination;
    }

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }

    public String getDateperemption() {
        return dateperemption;
    }

    public void setDateperemption(String dateperemption) {
        this.dateperemption = dateperemption;
    }

    public String getDateseuilperemption() {
        return dateseuilperemption;
    }

    public void setDateseuilperemption(String dateseuilperemption) {
        this.dateseuilperemption = dateseuilperemption;
    }
}

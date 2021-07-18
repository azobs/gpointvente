package org.c2psi.gpointvente.forms.formsEnreg.prix;

import javax.validation.constraints.*;

public class FormEnregPrixdebase implements java.io.Serializable {
    @Min(value=0, message = "Le prix d'achat moyen ne saurait être inférieur à 0")
    double prixdachatmoyen;
    @Min(value=0, message = "Le prix de gros moyen de vente ne saurait être inférieur à 0")
    double prixdegrosmoyen;
    @Min(value=0, message = "Le prix de semi gros moyen de vente ne saurait être inférieur à 0")
    double prixdesemigrosmoyen;
    @Min(value=0, message = "Le prix de détail moyen de vente ne saurait être inférieur à 0")
    double prixdedetailmoyen;
    @Min(value=0, message = "La ristourne attendu après l'achat d'un produit ne peut etre inférieur à 0")
    double ristourneattendu;
    @Min(value=0, message = "la précompte ou le bénéfice direct à la vente ne saurait être inférieur à 0")
    double precompteattendu;
    @NotNull(message = "La designation d'un produit ne peut etre null")
    @NotBlank(message = "La designation d'un produit ne peut etre blanc")
    @NotEmpty(message = "La designation d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String formataffichageprix;

    @NotNull(message = "L'identifiant de la devise du prix ne peut etre null")
    @NotBlank(message = "L'identifiant de la devise ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de la devise ne peut etre une chaine vide")
    String idDevisePrix;
    @NotNull(message = "L'identifiant du produit pour lequel le prix est donné ne peut etre null")
    @NotBlank(message = "L'identifiant du produit pour lequel le prix est donné ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du produit pour lequel le prix est donné ne peut etre une chaine vide")
    String idProduitFormateUniteConcerne;
    @NotNull(message = "L'identifiant du point de vente pour lequel le prix est donné ne peut etre null")
    @NotBlank(message = "L'identifiant du point de vente pour lequel le prix est donné ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du point de vente pour lequel le prix est donné ne peut etre une chaine vide")
    String idPointvente;

    public FormEnregPrixdebase() {
    }

    public FormEnregPrixdebase(double prixdachatmoyen, double prixdegrosmoyen, double prixdesemigrosmoyen,
                               double prixdedetailmoyen, double ristourneattendu, double precompteattendu,
                               String formataffichageprix, String idDevisePrix,
                               String idProduitFormateUniteConcerne, String idPointvente) {
        this.prixdachatmoyen = prixdachatmoyen;
        this.prixdegrosmoyen = prixdegrosmoyen;
        this.prixdesemigrosmoyen = prixdesemigrosmoyen;
        this.prixdedetailmoyen = prixdedetailmoyen;
        this.ristourneattendu = ristourneattendu;
        this.precompteattendu = precompteattendu;
        this.formataffichageprix = formataffichageprix;
        this.idDevisePrix = idDevisePrix;
        this.idProduitFormateUniteConcerne = idProduitFormateUniteConcerne;
        this.idPointvente = idPointvente;
    }

    public double getPrixdachatmoyen() {
        return prixdachatmoyen;
    }

    public void setPrixdachatmoyen(double prixdachatmoyen) {
        this.prixdachatmoyen = prixdachatmoyen;
    }

    public double getPrixdegrosmoyen() {
        return prixdegrosmoyen;
    }

    public void setPrixdegrosmoyen(double prixdegrosmoyen) {
        this.prixdegrosmoyen = prixdegrosmoyen;
    }

    public double getPrixdesemigrosmoyen() {
        return prixdesemigrosmoyen;
    }

    public void setPrixdesemigrosmoyen(double prixdesemigrosmoyen) {
        this.prixdesemigrosmoyen = prixdesemigrosmoyen;
    }

    public double getPrixdedetailmoyen() {
        return prixdedetailmoyen;
    }

    public void setPrixdedetailmoyen(double prixdedetailmoyen) {
        this.prixdedetailmoyen = prixdedetailmoyen;
    }

    public double getRistourneattendu() {
        return ristourneattendu;
    }

    public void setRistourneattendu(double ristourneattendu) {
        this.ristourneattendu = ristourneattendu;
    }

    public double getPrecompteattendu() {
        return precompteattendu;
    }

    public void setPrecompteattendu(double precompteattendu) {
        this.precompteattendu = precompteattendu;
    }

    public String getFormataffichageprix() {
        return formataffichageprix;
    }

    public void setFormataffichageprix(String formataffichageprix) {
        this.formataffichageprix = formataffichageprix;
    }

    public String getIdDevisePrix() {
        return idDevisePrix;
    }

    public void setIdDevisePrix(String idDevisePrix) {
        this.idDevisePrix = idDevisePrix;
    }

    public String getIdProduitFormateUniteConcerne() {
        return idProduitFormateUniteConcerne;
    }

    public void setIdProduitFormateUniteConcerne(String idProduitFormateUniteConcerne) {
        this.idProduitFormateUniteConcerne = idProduitFormateUniteConcerne;
    }

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }
}

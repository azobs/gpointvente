package org.c2psi.gpointvente.forms.formsEnreg.prix;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FormEnregPrixspecial implements java.io.Serializable {
    @NotNull(message = "L'identifiant du produit pour lequel le prix special est donné ne peut etre null")
    @NotBlank(message = "L'identifiant du produit pour lequel le prix special est donné ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du produit pour lequel le prix special est donné ne peut etre une chaine vide")
    String idProduitFormateUnite;
    @NotNull(message = "L'identifiant de la devise dans laquelle le prix special est donne ne peut etre null")
    @NotBlank(message = "L'identifiant de la devise dans laquelle le prix special est donne ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de la devise dans laquelle le prix special est donne ne peut etre une chaine vide")
    String idDevisePrix;
    @Min(value=0, message = "Le prix d'achat moyen ne saurait être inférieur à 0")
    double prixdachatmoyen;
    @Min(value=0, message = "Le prix de gros moyen ne saurait être inférieur à 0")
    double prixdegrosmoyen;
    @Min(value=0, message = "Le prix de semi gros moyen ne saurait être inférieur à 0")
    double prixdesemigrosmoyen;
    @Min(value=0, message = "Le prix de details moyen ne saurait être inférieur à 0")
    double prixdedetailmoyen;
    @Min(value=0, message = "La ristourne attendu ne saurait être inférieur à 0")
    double ristourneattendu;
    @Min(value=0, message = "La precompte attendu ne saurait être inférieur à 0")
    double precompteattendu;
    @Min(value=0, message = "La limite basse de vente en gros ne saurait être inférieur à 0")
    int limitebassegros;
    @Min(value=0, message = "La limite basse de vente en semi gros ne saurait être inférieur à 0")
    int limitebassesemigros;


    public FormEnregPrixspecial(String idProduitFormateUnite, String idDevisePrix,  double prixdachatmoyen,
                                double prixdegrosmoyen, double prixdesemigrosmoyen, double prixdedetailmoyen,
                                double ristourneattendu, double precompteattendu, int limitebassegros,
                                int limitebassesemigros) {
        this.idProduitFormateUnite = idProduitFormateUnite;
        this.idDevisePrix = idDevisePrix;
        this.prixdachatmoyen = prixdachatmoyen;
        this.prixdegrosmoyen = prixdegrosmoyen;
        this.prixdesemigrosmoyen = prixdesemigrosmoyen;
        this.prixdedetailmoyen = prixdedetailmoyen;
        this.ristourneattendu = ristourneattendu;
        this.precompteattendu = precompteattendu;
        this.limitebassegros = limitebassegros;
        this.limitebassesemigros = limitebassesemigros;
    }

    public String getIdDevisePrix() {
        return idDevisePrix;
    }

    public void setIdDevisePrix(String idDevisePrix) {
        this.idDevisePrix = idDevisePrix;
    }

    public String getIdProduitFormateUnite() {
        return idProduitFormateUnite;
    }

    public void setIdProduitFormateUnite(String idProduitFormateUnite) {
        this.idProduitFormateUnite = idProduitFormateUnite;
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

    public int getLimitebassegros() {
        return limitebassegros;
    }

    public void setLimitebassegros(int limitebassegros) {
        this.limitebassegros = limitebassegros;
    }

    public int getLimitebassesemigros() {
        return limitebassesemigros;
    }

    public void setLimitebassesemigros(int limitebassesemigros) {
        this.limitebassesemigros = limitebassesemigros;
    }
}

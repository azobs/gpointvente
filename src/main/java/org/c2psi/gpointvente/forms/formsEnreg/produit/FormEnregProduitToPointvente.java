package org.c2psi.gpointvente.forms.formsEnreg.produit;

import javax.validation.constraints.*;

public class FormEnregProduitToPointvente implements java.io.Serializable{
    /*
    *Donnee du ProduitFormateUnite: Il y a la date mais elle est automatiquement trouvee
    * c'est pas l'utilisateur qui la précise
     */
    @Min(value=0, message = "Le seuil de quantite ne saurait être inférieur à 0")
    int seuilqte;
    @Min(value=0, message = "La limite basse de vente en semi gros ne saurait être inférieur à 0")
    int limitebassesemigros;
    @Min(value=0, message = "La limite basse de vente en gros ne saurait être inférieur à 0")
    int limitebassegros;
    String commentairePFU;
    @NotNull(message = "Le code du produit dans le point de vente ne peut etre null")
    @NotBlank(message = "Le code du produit dans le point de vente ne peut etre vide")
    @NotEmpty(message = "Le code du produit dans le point de vente ne peut etre vide")
    @Size(min=1, max=15, message="Le code du produit dans le point de vente doit avoir " +
            "au moins 1 et au plus 15 caractères")
    String codePFU;

    /*
     *Il faut deja connaitre pour quel Pointvente le produit sera ajouter
     */
    @NotNull(message = "L'identifiant  du point de vente ne peut etre null")
    @NotBlank(message = "L'identifiant du point de vente ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du point de vente ne peut etre vide")
    String idPointvente;

    /*
    *Pour avoir un produit dans un point de vente il faut qu'on connaisse le produit associe
     */
    @NotNull(message = "La designation d'un produit ne peut etre null")
    @NotBlank(message = "La designation d'un produit ne peut etre vide")
    @NotEmpty(message = "La designation d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String designationProduitFR;
    @NotNull(message = "La designation d'un produit ne peut etre null")
    @NotBlank(message = "La designation d'un produit ne peut etre vide")
    @NotEmpty(message = "La designation d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String designationProduitEN;
    @NotNull(message = "L'alias d'un produit ne peut etre null")
    @NotBlank(message = "L'alias d'un produit ne peut etre vide")
    @NotEmpty(message = "L'alias d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String aliasProduitFR;
    @NotNull(message = "L'alias d'un produit ne peut etre null")
    @NotBlank(message = "L'alias d'un produit ne peut etre vide")
    @NotEmpty(message = "L'alias d'un produit ne peut etre une chaine vide")
    @Size(min=2, max=25, message="La designation d'un produit doit avoir au moins 2 et au plus 25 caracteres")
    String aliasProduitEN;
    @Size(max=75, message="La description d'un produit doit avoir au moins 2 caracteres")
    String descriptionProduitFR;
    @Size(max=75, message="La description d'un produit doit avoir au moins 2 caracteres")
    String descriptionProduitEN;
    int perissable;

    @NotNull(message = "La famille d'un produit ne peut etre null")
    @NotBlank(message = "La famille d'un produit ne peut etre blanc")
    @NotEmpty(message = "La famille d'un produit ne peut etre une chaine vide")
    String idFamilleProduit;

    /*
     *Tous les produits dans les point de vente sont formate selon un certain format Ce formatage doit
     * etre fait pendant l'enregistrement du produit
     */
    String photoPF;
    @NotNull(message = "L'identifiant du format d'un produit ne peut etre null")
    @NotBlank(message = "L'identifiant du format  d'un produit ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du format  d'un produit ne peut etre une chaine vide")
    String idFormat;

    /*
    *Tous les produits formate ne peuvent pas etre vendu sans etre mesurer. Il faut donc enregistrer les
    * unités dans lesquel le produitformate sera vendu
     */
    @NotNull(message = "L'identifiant de l'unite du produit dans le point de vente ne peut etre null")
    @NotBlank(message = "L'identifiant de l'unite du produit dans le point de vente ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de l'unite du produit dans le point de vente ne peut etre vide")
    String idUniteproduit;

    /*
    *Pour enregistrer un produit dans le point de vente il faut connaitre son prix de base
     */
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
    @NotNull(message = "L'identifiant de la devise du prix dans le point de vente ne peut etre null")
    @NotBlank(message = "L'identifiant de la devise du prix du produit dans le point de vente ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de la devise du prix du produit dans le point de vente ne peut etre vide")
    String idDeviseprix;
    @Min(value=0, message = "Le nombre de capsule gagnant pour le produit ne peut etre <0")
    int nbrecapsuleInitial;

    public FormEnregProduitToPointvente() {
    }

    public FormEnregProduitToPointvente(int seuilqte, int limitebassesemigros, int limitebassegros,
                                        String commentairePFU, String codePFU, String idPointvente,
                                        String designationProduitFR, String designationProduitEN,
                                        String aliasProduitFR, String aliasProduitEN, String descriptionProduitFR,
                                        String descriptionProduitEN, int perissable, String idFamilleProduit,
                                        String photoPF, String idFormat, String idUniteproduit,
                                        double prixdachatmoyen, double prixdegrosmoyen,
                                        double prixdesemigrosmoyen, double prixdedetailmoyen,
                                        double ristourneattendu, double precompteattendu,
                                        String formataffichageprix, String idDeviseprix, int nbrecapsuleInitial) {
        this.seuilqte = seuilqte;
        this.limitebassesemigros = limitebassesemigros;
        this.limitebassegros = limitebassegros;
        this.commentairePFU = commentairePFU;
        this.codePFU = codePFU;
        this.idPointvente = idPointvente;
        this.designationProduitFR = designationProduitFR;
        this.designationProduitEN = designationProduitEN;
        this.aliasProduitFR = aliasProduitFR;
        this.aliasProduitEN = aliasProduitEN;
        this.descriptionProduitFR = descriptionProduitFR;
        this.descriptionProduitEN = descriptionProduitEN;
        this.perissable = perissable;
        this.idFamilleProduit = idFamilleProduit;
        this.photoPF = photoPF;
        this.idFormat = idFormat;
        this.idUniteproduit = idUniteproduit;
        this.prixdachatmoyen = prixdachatmoyen;
        this.prixdegrosmoyen = prixdegrosmoyen;
        this.prixdesemigrosmoyen = prixdesemigrosmoyen;
        this.prixdedetailmoyen = prixdedetailmoyen;
        this.ristourneattendu = ristourneattendu;
        this.precompteattendu = precompteattendu;
        this.formataffichageprix = formataffichageprix;
        this.idDeviseprix = idDeviseprix;
        this.nbrecapsuleInitial = nbrecapsuleInitial;
    }

    public int getSeuilqte() {
        return seuilqte;
    }

    public void setSeuilqte(int seuilqte) {
        this.seuilqte = seuilqte;
    }

    public int getLimitebassesemigros() {
        return limitebassesemigros;
    }

    public void setLimitebassesemigros(int limitebassesemigros) {
        this.limitebassesemigros = limitebassesemigros;
    }

    public int getLimitebassegros() {
        return limitebassegros;
    }

    public void setLimitebassegros(int limitebassegros) {
        this.limitebassegros = limitebassegros;
    }

    public String getCommentairePFU() {
        return commentairePFU;
    }

    public void setCommentairePFU(String commentairePFU) {
        this.commentairePFU = commentairePFU;
    }

    public String getCodePFU() {
        return codePFU;
    }

    public void setCodePFU(String codePFU) {
        this.codePFU = codePFU;
    }

    public String getIdUniteproduit() {
        return idUniteproduit;
    }

    public void setIdUniteproduit(String idUniteproduit) {
        this.idUniteproduit = idUniteproduit;
    }

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }

    public String getDesignationProduitFR() {
        return designationProduitFR;
    }

    public void setDesignationProduitFR(String designationProduitFR) {
        this.designationProduitFR = designationProduitFR;
    }

    public String getDesignationProduitEN() {
        return designationProduitEN;
    }

    public void setDesignationProduitEN(String designationProduitEN) {
        this.designationProduitEN = designationProduitEN;
    }

    public String getAliasProduitFR() {
        return aliasProduitFR;
    }

    public void setAliasProduitFR(String aliasProduitFR) {
        this.aliasProduitFR = aliasProduitFR;
    }

    public String getAliasProduitEN() {
        return aliasProduitEN;
    }

    public void setAliasProduitEN(String aliasProduitEN) {
        this.aliasProduitEN = aliasProduitEN;
    }

    public String getDescriptionProduitFR() {
        return descriptionProduitFR;
    }

    public void setDescriptionProduitFR(String descriptionProduitFR) {
        this.descriptionProduitFR = descriptionProduitFR;
    }

    public String getDescriptionProduitEN() {
        return descriptionProduitEN;
    }

    public void setDescriptionProduitEN(String descriptionProduitEN) {
        this.descriptionProduitEN = descriptionProduitEN;
    }

    public int getPerissable() {
        return perissable;
    }

    public void setPerissable(int perissable) {
        this.perissable = perissable;
    }

    public String getIdFamilleProduit() {
        return idFamilleProduit;
    }

    public void setIdFamilleProduit(String idFamilleProduit) {
        this.idFamilleProduit = idFamilleProduit;
    }

    public String getPhotoPF() {
        return photoPF;
    }

    public void setPhotoPF(String photoPF) {
        this.photoPF = photoPF;
    }

    public String getIdFormat() {
        return idFormat;
    }

    public void setIdFormat(String idFormat) {
        this.idFormat = idFormat;
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

    public String getIdDeviseprix() {
        return idDeviseprix;
    }

    public void setIdDeviseprix(String idDeviseprix) {
        this.idDeviseprix = idDeviseprix;
    }

    public int getNbrecapsuleInitial() {
        return nbrecapsuleInitial;
    }

    public void setNbrecapsuleInitial(int nbrecapsuleInitial) {
        this.nbrecapsuleInitial = nbrecapsuleInitial;
    }
}

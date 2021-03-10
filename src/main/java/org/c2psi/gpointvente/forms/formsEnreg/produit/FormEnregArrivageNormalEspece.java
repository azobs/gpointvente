package org.c2psi.gpointvente.forms.formsEnreg.produit;

import javax.validation.constraints.*;
import java.util.Date;

public class FormEnregArrivageNormalEspece implements java.io.Serializable{
    @NotNull(message = "La date et l'heure de la livraison ne peut etre null")
    @NotBlank(message = "La date et l'heure de la livraison ne peut etre blanc")
    @NotEmpty(message = "La date et l'heure de la livraison ne peut etre une chaine vide")
    @Size(max=20, message="La date et l'heure de la livraison doit avoir au plus 20 caracteres yyyy-MM-dd HH:mm:ss")
    String dateheurelivraisonArrivage;
    @Positive(message = "Le prix d'achat unitaire doit toujours etre une valeur positive")
    double prixachatunitaire;
    @NotBlank(message = "La date de peremption du produit ne peut etre blanc")
    @NotEmpty(message = "La date de peremption du produit ne peut etre une chaine vide")
    @Size(max=20, message="La date de peremption du produit doit avoir au plus 20 caracteres yyyy-MM-dd")
    String dateperemption;
    @NotBlank(message = "La date seuil de peremption du produit ne peut etre blanc")
    @NotEmpty(message = "La date seuil de peremption du produit ne peut etre une chaine vide")
    @Size(max=20, message="La date seuil de peremption du produit doit avoir au plus 20 caracteres yyyy-MM-dd")
    String dateseuilperemption;
    @Positive(message = "la quantite livrée doit être une valeur positive")
    int quantitelivree;
    @NotNull(message = "L'identifiant du produit ne peut etre null")
    @NotBlank(message = "L'identifiant du produit ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du produit ne peut etre une chaine vide")
    String idproduitFormateUnite;
    @NotNull(message = "L'identifiant de la facture appro espece ne peut etre null")
    @NotBlank(message = "L'identifiant de la facture appro espece ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de la facture appro espece ne peut etre une chaine vide")
    String idFactureapproespece;
    @NotNull(message = "L'identifiant du point de vente ne peut etre null")
    @NotBlank(message = "L'identifiant du point de vente ne peut etre blanc")
    @NotEmpty(message = "L'identifiant du point de vente ne peut etre une chaine vide")
    String idPointvente;

    public FormEnregArrivageNormalEspece() {
    }

    public FormEnregArrivageNormalEspece(String dateheurelivraisonArrivage, double prixachatunitaire,
                                         String dateperemption, String dateseuilperemption,
                                         int quantitelivree, String idproduitFormateUnite,
                                         String idFactureapproespece, String idPointvente) {
        this.dateheurelivraisonArrivage = dateheurelivraisonArrivage;
        this.prixachatunitaire = prixachatunitaire;
        this.dateperemption = dateperemption;
        this.dateseuilperemption = dateseuilperemption;
        this.quantitelivree = quantitelivree;
        this.idproduitFormateUnite = idproduitFormateUnite;
        this.idFactureapproespece = idFactureapproespece;
        this.idPointvente = idPointvente;
    }

    public String getDateheurelivraisonArrivage() {
        return dateheurelivraisonArrivage;
    }

    public void setDateheurelivraisonArrivage(String dateheurelivraisonArrivage) {
        this.dateheurelivraisonArrivage = dateheurelivraisonArrivage;
    }

    public double getPrixachatunitaire() {
        return prixachatunitaire;
    }

    public void setPrixachatunitaire(double prixachatunitaire) {
        this.prixachatunitaire = prixachatunitaire;
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

    public int getQuantitelivree() {
        return quantitelivree;
    }

    public void setQuantitelivree(int quantitelivree) {
        this.quantitelivree = quantitelivree;
    }

    public String getIdproduitFormateUnite() {
        return idproduitFormateUnite;
    }

    public void setIdproduitFormateUnite(String idproduitFormateUnite) {
        this.idproduitFormateUnite = idproduitFormateUnite;
    }

    public String getIdFactureapproespece() {
        return idFactureapproespece;
    }

    public void setIdFactureapproespece(String idFactureapproespece) {
        this.idFactureapproespece = idFactureapproespece;
    }

    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }
}

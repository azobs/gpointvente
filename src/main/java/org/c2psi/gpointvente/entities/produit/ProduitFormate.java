package org.c2psi.gpointvente.entities.produit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/****************************************************************************************
 * Un produit peut etre vendu sur plusieurs Conditionnement (formats).                  *
 * Donc apres avoir enregistre un produit, il faut enregistrer ses différents           *
 * conditionnements (Formatproduit) et associe le produit a chacun de ces               *
 * conditionnement pour créer un objet de cette classe. Donc en fait                    *
 * Un ProduitFormate est un produit qui est dans un certain conditionnement.            *
 * Un produit peut etre dans plus d'un conditionnement. Et dans chacun de ces           *
 * conditionnement, le produit a une physionnomie qui peut etre reconnu via une         *
 * photos.                                                                              *
 * NB: Lorsqu'un produit est conditionne (ProduitFormate) il est vendu selon une        *
 * certaine Unite. Il faut donc aussi enregistrer ces unités pour former le             *
 * ProduitFormateUnite: C'est cet objet qui correspond a un produit ou un article du    *
 * point de vue de l'administrateur ou d'un vendeur dans un point de vente.             *
 ****************************************************************************************/
@Document
public class ProduitFormate {
    @Id
    String idPF;
    String photoPF;

    /**
     * Un produitFormate concerne toujours un produit
     * D'ailleurs c'est un produit qu'on formate
     */
    @DBRef
    Produit produitAFormate;
    /**
     * Un produitFormate concerne toujours un format
     * Le format qui sera utilise pour formater
     */
    @DBRef
    Formatproduit formatPF;
    /**
     * Date a partir de laquelle  le format a ete associe  au produit
     * Sachant que le format n'est qu'un conditionnement du produit.
     */
    Date dateFormatage;

    /*******************************************************************************
     * Liste des unites utilises pour vendre le produit formate. Donc il s'agit de
     * la liste des produitformateunite
     * En effet, une fois le produit formate on va le vendre soit en 1 à 1 (en unite)
     * soit en les regroupant en un certain nombre (12, 24, 6, etc.) avant d'etre
     * vendu. Apres regroupement on peut les introduires dans types d'emballage
     * (casier12, casier24, carton12, etc). Les types d'emballage sont geres aussi
     * par le systeme
     *******************************************************************************/
    List<ProduitFormateUnite> listofProduitFormateUnite = new ArrayList<ProduitFormateUnite>();

    public ProduitFormate() {
    }

    public ProduitFormate(String idPF, String photoPF, Produit produitAFormate,
                          Formatproduit formatPF, Date dateFormatage) {
        this.idPF = idPF;
        this.photoPF = photoPF;
        this.produitAFormate = produitAFormate;
        this.formatPF = formatPF;
        this.dateFormatage = dateFormatage;
    }

    public ProduitFormate(String photoPF, Produit produitAFormate, Formatproduit formatPF,
                          Date dateFormatage) {
        this.photoPF = photoPF;
        this.produitAFormate = produitAFormate;
        this.formatPF = formatPF;
        this.dateFormatage = dateFormatage;
    }

    public String getIdPF() {
        return idPF;
    }

    public void setIdPF(String idPF) {
        this.idPF = idPF;
    }

    public String getPhotoPF() {
        return photoPF;
    }

    public void setPhotoPF(String photoPF) {
        this.photoPF = photoPF;
    }

    public Produit getProduitAFormate() {
        return produitAFormate;
    }

    public void setProduitAFormate(Produit produitAFormate) {
        this.produitAFormate = produitAFormate;
    }

    public Formatproduit getFormatPF() {
        return formatPF;
    }

    public void setFormatPF(Formatproduit formatPF) {
        this.formatPF = formatPF;
    }

    public Date getDateFormatage() {
        return dateFormatage;
    }

    public void setDateFormatage(Date dateFormatage) {
        this.dateFormatage = dateFormatage;
    }

    @Override
    public String toString() {
        return "ProduitFormate{" +
                "idPF='" + idPF + '\'' +
                ", photoPF='" + photoPF + '\'' +
                ", produitAFormate=" + produitAFormate +
                ", formatPF=" + formatPF +
                ", dateFormatage=" + dateFormatage +
                '}';
    }
}

package org.c2psi.gpointvente.entities.produit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/***********************************************************
 * Le Formatproduit correspond au conditionnement          *
 * qu'on peut donner a un produit dans un point de vente   *
 * Chaque conditionnement peut avoir une designation qui   *
 * peut etre differente dans les 02 langues.               *
 ***********************************************************/
@Document
public class Formatproduit {
    @Id
    String idFormatproduit;
    String designationFormatproduitFR;
    String designationFormatproduitEN;
    String contenance;

    /**********************************************************
     * Chaque format de produit appartient a un point de vente
     * et l'administrateur du point de vente peut en cree. ces
     * format peuvent etre utilise pour formater les produits
     * avant de les mettre dans les unites de mesure et de les
     * vendre
     **********************************************************/
    @JsonIgnore
    @DBRef
    Pointvente pointvente;

    public Formatproduit() {
    }

    public Formatproduit(String idFormatproduit, String designationFormatproduitFR,
                         String designationFormatproduitEN, String contenance, Pointvente pointvente) {
        this.idFormatproduit = idFormatproduit;
        this.designationFormatproduitFR = designationFormatproduitFR;
        this.designationFormatproduitEN = designationFormatproduitEN;
        this.contenance = contenance;
        this.pointvente = pointvente;
    }

    public String getIdFormatproduit() {
        return idFormatproduit;
    }

    public void setIdFormatproduit(String idFormatproduit) {
        this.idFormatproduit = idFormatproduit;
    }

    public String getDesignationFormatproduitFR() {
        return designationFormatproduitFR;
    }

    public void setDesignationFormatproduitFR(String designationFormatproduitFR) {
        this.designationFormatproduitFR = designationFormatproduitFR;
    }

    public String getDesignationFormatproduitEN() {
        return designationFormatproduitEN;
    }

    public void setDesignationFormatproduitEN(String designationFormatproduitEN) {
        this.designationFormatproduitEN = designationFormatproduitEN;
    }

    public String getContenance() {
        return contenance;
    }

    public void setContenance(String contenance) {
        this.contenance = contenance;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }
}

package org.c2psi.gpointvente.entities.pv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Document
public class Pointvente {
    @Id
    String idPointvente;
    String descriptionPv;
    String denominationPv;
    @DBRef
    Entreprise entreprisePv;
    @DBRef
    Adresse adressePv;
    /*
    *Chaque point de vente a une liste de devise qu'il peut utilise parmi lesquelle il y une par défaut.
    * Donc parmi toutes les devises qu'elle utilise,
    * elle doit avoir une devise par défaut qu'elle utilise. Grace aux règle de conversion, elle
    * peut utiliser ses autres devises enregistrées dans le système
     */
    @JsonIgnore
    @DBRef
    Collection<Devise> listofDevisePv = new ArrayList<Devise>();

    /******
     * Chaque point de vente a une liste de type d'emballage (les casiers par exemple) qui
     * doivent être gerer par la plateforme
     */
    @JsonIgnore
    @DBRef
    Collection<Typeemballage> listofTypeemballagePv = new ArrayList<Typeemballage>();

    /******
     * Chaque point de vente a une liste de format de produit (60cl, 65cl, 33cl, etc.) qui
     * doivent être gerer par la plateforme
     */
    @JsonIgnore
    @DBRef
    Collection<Formatproduit> listofFormatproduitPv = new ArrayList<Formatproduit>();

    /******
     * Chaque point de vente a une liste d'unite de produit (C12, C6, C24, etc) qui
     * doivent être gerer par la plateforme.Ces unites sont utilisées pour mesurer et vendre les produits formates
     */
    @JsonIgnore
    @DBRef
    Collection<Uniteproduit> listofUniteproduitPv = new ArrayList<Uniteproduit>();

    /***********
     * Chaque point de vente entretient une liste des familles des produits qu'il va vendre.
     */
    @JsonIgnore
    @DBRef
    Collection<Famille> listofFamilleproduitPv = new ArrayList<>();

    /***********
     * Chaque point de vente entretient une liste des produits qu'il va vendre. Ainsi à partir d'un
     * point de vente on peut avoir la liste de tous les produits qu'il vend en consultant simplement cette liste.
     */
    @JsonIgnore
    @DBRef
    Collection<ProduitFormateUnite> listofProduitFormateUnite = new ArrayList<>();


    /*
    Chaque point de  vente a un compte principal pour gerer les especes
     */
    @DBRef
    Compteprincipal compteprincipalPv;

    public Pointvente() {
    }

    public Pointvente(String idPointvente, String descriptionPv, String denominationPv, Entreprise entreprisePv,
                      Adresse adressePv,  Compteprincipal compteprincipal) {
        this.idPointvente = idPointvente;
        this.descriptionPv = descriptionPv;
        this.denominationPv = denominationPv;
        this.entreprisePv = entreprisePv;
        this.adressePv = adressePv;
        this.compteprincipalPv = compteprincipal;
    }

    public Pointvente(String descriptionPv, String denominationPv, Entreprise entreprisePv,
                      Adresse adressePv, Compteprincipal compteprincipal) {
        this.descriptionPv = descriptionPv;
        this.denominationPv = denominationPv;
        this.entreprisePv = entreprisePv;
        this.adressePv = adressePv;
        this.compteprincipalPv = compteprincipal;
    }



    public Pointvente(String descriptionPv, String denominationPv, Entreprise entreprisePv,
                      Compteprincipal compteprincipal) {
        this.descriptionPv = descriptionPv;
        this.denominationPv = denominationPv;
        this.entreprisePv = entreprisePv;
        this.compteprincipalPv = compteprincipal;
    }



    public String getIdPointvente() {
        return idPointvente;
    }

    public void setIdPointvente(String idPointvente) {
        this.idPointvente = idPointvente;
    }

    public String getDescriptionPv() {
        return descriptionPv;
    }

    public void setDescriptionPv(String descriptionPv) {
        this.descriptionPv = descriptionPv;
    }

    public String getDenominationPv() {
        return denominationPv;
    }

    public void setDenominationPv(String denominationPv) {
        this.denominationPv = denominationPv;
    }

    public Entreprise getEntreprisePv() {
        return entreprisePv;
    }

    public void setEntreprisePv(Entreprise entreprisePv) {
        this.entreprisePv = entreprisePv;
    }

    public Adresse getAdressePv() {
        return adressePv;
    }

    public void setAdressePv(Adresse adressePv) {
        this.adressePv = adressePv;
    }

    public Collection<Devise> getListofDevisePv() {
        return listofDevisePv;
    }

    public void setListofDevisePv(Collection<Devise> listofDevisePv) {
        this.listofDevisePv = listofDevisePv;
    }

    public Collection<Typeemballage> getListofTypeemballagePv() {
        return listofTypeemballagePv;
    }

    public void setListofTypeemballagePv(Collection<Typeemballage> listofTypeemballagePv) {
        this.listofTypeemballagePv = listofTypeemballagePv;
    }

    public Compteprincipal getCompteprincipalPv() {
        return compteprincipalPv;
    }

    public void setCompteprincipalPv(Compteprincipal compteprincipalPv) {
        this.compteprincipalPv = compteprincipalPv;
    }

    public Devise getDeviseParDefaut(){
        for(Devise d : listofDevisePv){
            if(d.isDeviseParDefaut()){
                return d;
            }
        }
        return null;
    }

    public Collection<Famille> getListofFamilleproduitPv() {
        return listofFamilleproduitPv;
    }

    public void setListofFamilleproduitPv(Collection<Famille> listofFamilleproduitPv) {
        this.listofFamilleproduitPv = listofFamilleproduitPv;
    }

    public Collection<Formatproduit> getListofFormatproduitPv() {
        return listofFormatproduitPv;
    }

    public void setListofFormatproduitPv(Collection<Formatproduit> listofFormatproduitPv) {
        this.listofFormatproduitPv = listofFormatproduitPv;
    }

    public Collection<ProduitFormateUnite> getListofProduitFormateUnite() {
        return listofProduitFormateUnite;
    }

    public void setListofProduitFormateUnite(Collection<ProduitFormateUnite> listofProduitFormateUnite) {
        this.listofProduitFormateUnite = listofProduitFormateUnite;
    }

    public Collection<Uniteproduit> getListofUniteproduitPv() {
        return listofUniteproduitPv;
    }

    public void setListofUniteproduitPv(Collection<Uniteproduit> listofUniteproduitPv) {
        this.listofUniteproduitPv = listofUniteproduitPv;
    }

    @Override
    public String toString() {
        String devise = Optional.of(getDeviseParDefaut()).isPresent()
                ?Optional.of(getDeviseParDefaut()).get().toString()
                :" ";
        return "Pointvente{" +
                "idPointvente='" + idPointvente + '\'' +
                ", descriptionPv='" + descriptionPv + '\'' +
                ", denominationPv='" + denominationPv + '\'' +
                ", entreprisePv=" + entreprisePv +
                ", adressePv=" + adressePv +
                ", devisePv=" + devise +
                ", compteprincipalPv=" + compteprincipalPv.getSoldeespece() +
                '}';
    }
}

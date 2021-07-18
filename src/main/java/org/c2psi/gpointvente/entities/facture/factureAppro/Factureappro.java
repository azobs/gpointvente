package org.c2psi.gpointvente.entities.facture.factureAppro;

import org.c2psi.gpointvente.entities.produit.ArrivageProduitformate;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.c2psi.gpointvente.entities.facture.Facture;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Il s'agit des factures d'approvisionnement. A chaque approvisionnement il y a une facture dont
 * l'enregistrement permettra d'introduire les articles achetés dans le stock du point de vente.
 * les approvisionnements peuvent etre realise apres un achat (avec des especes) ou un changement de capsule
 */
@Document
public class Factureappro {
    @Id
    String idFactureappro;
    String observationFactureappro;
    String numeroFacture;
    Date dateFactureappro;
    Date dateheureenregFactureappro;
    /*******************************************************************************
     * L'approvisionnement se fait generalement a travers une facture lorsqu'il est
     * normal. Or cet arrivage peut etre issu d'un achat avec l'argent en espece ou
     * alors d'un achat avec les capsules. d'ou le type de facture appro
     * typeFactureappro = Espece si la facture sera regle avec les especes
     * typeFactureappro = Capsule si la facture sera regle avec les capsules
     */
    String typeFactureappro;

    /**
     * Chaque factureappro est donne par un fournisseur
     */
    @DBRef
    Fournisseur fournisseurConcerne;
    /**
     * Chaque factureappro est d'abord une facture
     */
    @DBRef
    Facture factureAssocie;

    /*****************************************************
     * Chaque facture approvisionnement a une liste des arrivages de produit formate unite
     * qui figure sur la factureappro. car un arrivage produit formate unite concerne
     * uniquement un produitformateunite
     */
    List<ArrivageProduitformate> listofArrivageProduitformate = new ArrayList<>();

    public Factureappro() {
    }

    public Factureappro(String idFactureappro, String observationFactureappro, String numeroFacture, Date dateFactureappro, Date dateheureenregFactureappro, String typeFactureappro, Fournisseur fournisseurConcerne, Facture factureAssocie) {
        this.idFactureappro = idFactureappro;
        this.observationFactureappro = observationFactureappro;
        this.numeroFacture = numeroFacture;
        this.dateFactureappro = dateFactureappro;
        this.dateheureenregFactureappro = dateheureenregFactureappro;
        this.typeFactureappro = typeFactureappro;
        this.fournisseurConcerne = fournisseurConcerne;
        this.factureAssocie = factureAssocie;
    }

    public String getIdFactureappro() {
        return idFactureappro;
    }

    public void setIdFactureappro(String idFactureappro) {
        this.idFactureappro = idFactureappro;
    }

    public String getObservationFactureappro() {
        return observationFactureappro;
    }

    public void setObservationFactureappro(String observationFactureappro) {
        this.observationFactureappro = observationFactureappro;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Date getDateFactureappro() {
        return dateFactureappro;
    }

    public void setDateFactureappro(Date dateFactureappro) {
        this.dateFactureappro = dateFactureappro;
    }



    public String getTypeFactureappro() {
        return typeFactureappro;
    }

    public void setTypeFactureappro(String typeFactureappro) {
        this.typeFactureappro = typeFactureappro;
    }

    public Fournisseur getFournisseurConcerne() {
        return fournisseurConcerne;
    }

    public void setFournisseurConcerne(Fournisseur fournisseurConcerne) {
        this.fournisseurConcerne = fournisseurConcerne;
    }

    public Facture getFactureAssocie() {
        return factureAssocie;
    }

    public void setFactureAssocie(Facture factureAssocie) {
        this.factureAssocie = factureAssocie;
    }

    public Date getDateheureenregFactureappro() {
        return dateheureenregFactureappro;
    }

    public void setDateheureenregFactureappro(Date dateheureenregFactureappro) {
        this.dateheureenregFactureappro = dateheureenregFactureappro;
    }

    public List<ArrivageProduitformate> getListofArrivageProduitformate() {
        return listofArrivageProduitformate;
    }

    public void setListofArrivageProduitformate(List<ArrivageProduitformate> listofArrivageProduitformate) {
        this.listofArrivageProduitformate = listofArrivageProduitformate;
    }
}

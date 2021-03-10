package org.c2psi.gpointvente.entities.facture.factureAppro;

import org.c2psi.gpointvente.entities.produit.Arrivageparespece;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
public class Factureapproespece {
    @Id
    String idFactureapproespece;
    double montantattendu;
    double montantverse;

    /**
     * Une factureapproespece est d'abord une factureappro
     */
    @DBRef
    Factureappro factureapproAssocie;

    /*******************************************
     * La liste des arrivages espece contenu dans cette facture
     */
    @DBRef
    Collection<Arrivageparespece> listofArrivageespece = new ArrayList<>();

    public Factureapproespece() {
    }

    public Factureapproespece(String idFactureapproespece, double montantattendu, double montantverse,
                              Factureappro factureapproAssocie) {
        this.idFactureapproespece = idFactureapproespece;
        this.montantattendu = montantattendu;
        this.montantverse = montantverse;
        this.factureapproAssocie = factureapproAssocie;
    }

    public String getIdFactureapproespece() {
        return idFactureapproespece;
    }

    public void setIdFactureapproespece(String idFactureapproespece) {
        this.idFactureapproespece = idFactureapproespece;
    }

    public double getMontantattendu() {
        return montantattendu;
    }

    public void setMontantattendu(double montantattendu) {
        this.montantattendu = montantattendu;
    }

    public double getMontantverse() {
        return montantverse;
    }

    public void setMontantverse(double montantverse) {
        this.montantverse = montantverse;
    }

    public Factureappro getFactureapproAssocie() {
        return factureapproAssocie;
    }

    public void setFactureapproAssocie(Factureappro factureapproAssocie) {
        this.factureapproAssocie = factureapproAssocie;
    }

    public Collection<Arrivageparespece> getListofArrivageespece() {
        return listofArrivageespece;
    }

    public void setListofArrivageespece(Collection<Arrivageparespece> listofArrivageespece) {
        this.listofArrivageespece = listofArrivageespece;
    }
}

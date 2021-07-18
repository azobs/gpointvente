package org.c2psi.gpointvente.entities.facture.factureAppro;

import org.c2psi.gpointvente.entities.produit.Arrivageparcapsule;
import org.c2psi.gpointvente.entities.produit.Arrivageparespece;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
public class Factureapprocapsule {
    @Id
    String idfactureapprocapsule;
    double estimationvaleur;
    int nbrecapsulechange;
    int nbrecapsuleAchange;

    /**
     * Une FactureapproCapsule est associe a une Factureappro
     */
    @DBRef
    Factureappro factureapproAssocie;

    /**
     * Une FactureapproCapsule a une liste des arrivages par capsule
     */
    @DBRef
    Collection<Arrivageparcapsule> listofArrivagecapsule = new ArrayList<>();

    public Factureapprocapsule() {
    }

    public Factureapprocapsule(String idfactureapprocapsule, double estimationvaleur, int nbrecapsulechange,
                               int nbrecapsuleAchange, Factureappro factureapproAssocie) {
        this.idfactureapprocapsule = idfactureapprocapsule;
        this.estimationvaleur = estimationvaleur;
        this.nbrecapsulechange = nbrecapsulechange;
        this.nbrecapsuleAchange = nbrecapsuleAchange;
        this.factureapproAssocie = factureapproAssocie;
    }

    public String getIdfactureapprocapsule() {
        return idfactureapprocapsule;
    }

    public void setIdfactureapprocapsule(String idfactureapprocapsule) {
        this.idfactureapprocapsule = idfactureapprocapsule;
    }

    public double getEstimationvaleur() {
        return estimationvaleur;
    }

    public void setEstimationvaleur(double estimationvaleur) {
        this.estimationvaleur = estimationvaleur;
    }

    public int getNbrecapsulechange() {
        return nbrecapsulechange;
    }

    public void setNbrecapsulechange(int nbrecapsulechange) {
        this.nbrecapsulechange = nbrecapsulechange;
    }

    public int getNbrecapsuleAchange() {
        return nbrecapsuleAchange;
    }

    public void setNbrecapsuleAchange(int nbrecapsuleAchange) {
        this.nbrecapsuleAchange = nbrecapsuleAchange;
    }

    public Factureappro getFactureapproAssocie() {
        return factureapproAssocie;
    }

    public void setFactureapproAssocie(Factureappro factureapproAssocie) {
        this.factureapproAssocie = factureapproAssocie;
    }

    public Collection<Arrivageparcapsule> getListofArrivagecapsule() {
        return listofArrivagecapsule;
    }

    public void setListofArrivagecapsule(Collection<Arrivageparcapsule> listofArrivagecapsule) {
        this.listofArrivagecapsule = listofArrivagecapsule;
    }
}

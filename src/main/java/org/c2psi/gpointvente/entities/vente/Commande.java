package org.c2psi.gpointvente.entities.vente;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.c2psi.gpointvente.entities.user.Vendeur;
import org.c2psi.gpointvente.entities.tier.Client;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Tout achat est realise apres une commande qui elle doit etre enregistree au prealable
 */
@Document
public class Commande {
    @Id
    String idCommande;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    Date dateCommande;
    int etatCommande;
    String commentaireCommande;
    String typeCommande;
    String statutCommande;
    String numeroCommande;

    /**
     * Client ayant commandee
     */
    @DBRef
    Client clientConcerne;
    /**
     * Vendeur qui enregistre et s'occupe de la commande
     */
    @DBRef
    Vendeur vendeur;

    public Commande() {
    }

    public Commande(String idCommande, Date dateCommande, int etatCommande, String commentaireCommande,
                    String typeCommande, String statutCommande, String numeroCommande, Client clientConcerne,
                    Vendeur vendeur) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.etatCommande = etatCommande;
        this.commentaireCommande = commentaireCommande;
        this.typeCommande = typeCommande;
        this.statutCommande = statutCommande;
        this.numeroCommande = numeroCommande;
        this.clientConcerne = clientConcerne;
        this.vendeur = vendeur;
    }

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(int etatCommande) {
        this.etatCommande = etatCommande;
    }

    public String getCommentaireCommande() {
        return commentaireCommande;
    }

    public void setCommentaireCommande(String commentaireCommande) {
        this.commentaireCommande = commentaireCommande;
    }

    public String getTypeCommande() {
        return typeCommande;
    }

    public void setTypeCommande(String typeCommande) {
        this.typeCommande = typeCommande;
    }

    public String getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(String statutCommande) {
        this.statutCommande = statutCommande;
    }

    public String getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public Client getClientConcerne() {
        return clientConcerne;
    }

    public void setClientConcerne(Client clientConcerne) {
        this.clientConcerne = clientConcerne;
    }

    public Vendeur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }
}

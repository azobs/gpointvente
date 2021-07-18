package org.c2psi.gpointvente.entities.facture.factureVente;

import org.c2psi.gpointvente.entities.vente.Commande;
import org.c2psi.gpointvente.entities.facture.Facture;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Toutes les ventes sont repertoriees sur une facture
 */
@Document
public class Facturevente {
    @Id
    String idFacturevente;
    String numeroFacturevente;
    /**
     * Une facturevente peut etre: capsule (le client va acheter avec des capsules) ou espece
     */
    String typeFacturevente;

    /**
     * Facture associe a la vente
     */
    @DBRef
    Facture factureAssocie;
    /**
     * Commande associe a la facturevente
     */
    @DBRef
    Commande commandeAssocie;

    public Facturevente() {
    }

    public Facturevente(String idFacturevente, String numeroFacturevente, String typeFacturevente,
                        Facture factureAssocie, Commande commandeAssocie) {
        this.idFacturevente = idFacturevente;
        this.numeroFacturevente = numeroFacturevente;
        this.typeFacturevente = typeFacturevente;
        this.factureAssocie = factureAssocie;
        this.commandeAssocie = commandeAssocie;
    }

    public String getIdFacturevente() {
        return idFacturevente;
    }

    public void setIdFacturevente(String idFacturevente) {
        this.idFacturevente = idFacturevente;
    }

    public String getNumeroFacturevente() {
        return numeroFacturevente;
    }

    public void setNumeroFacturevente(String numeroFacturevente) {
        this.numeroFacturevente = numeroFacturevente;
    }

    public String getTypeFacturevente() {
        return typeFacturevente;
    }

    public void setTypeFacturevente(String typeFacturevente) {
        this.typeFacturevente = typeFacturevente;
    }

    public Facture getFactureAssocie() {
        return factureAssocie;
    }

    public void setFactureAssocie(Facture factureAssocie) {
        this.factureAssocie = factureAssocie;
    }

    public Commande getCommandeAssocie() {
        return commandeAssocie;
    }

    public void setCommandeAssocie(Commande commandeAssocie) {
        this.commandeAssocie = commandeAssocie;
    }
}

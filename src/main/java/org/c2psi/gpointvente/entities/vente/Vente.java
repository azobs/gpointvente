package org.c2psi.gpointvente.entities.vente;

import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Dans une commande on peut avoir plusieurs produits. Lorsque la commande est validee et servie,
 * des ventes sont generee pour chaque produit figurant dans la facture
 */
@Document
public class Vente {
    @Id
    String idVente;
    int quantitevendu;
    String observationVente;
    String typeVente;

    /**
     * Chaque vente figure dans une commande
     */
    @DBRef
    Commande commandeConcerne;
    /**
     * Produit concernee par la vente
     */
    @DBRef
    ProduitFormateUnite produitFormateUniteConcerne;

    public Vente() {
    }

    public Vente(String idVente, int quantitevendu, String observationVente, String typeVente,
                 Commande commandeConcerne, ProduitFormateUnite produitFormateUniteConcerne) {
        this.idVente = idVente;
        this.quantitevendu = quantitevendu;
        this.observationVente = observationVente;
        this.typeVente = typeVente;
        this.commandeConcerne = commandeConcerne;
        this.produitFormateUniteConcerne = produitFormateUniteConcerne;
    }

    public String getIdVente() {
        return idVente;
    }

    public void setIdVente(String idVente) {
        this.idVente = idVente;
    }

    public int getQuantitevendu() {
        return quantitevendu;
    }

    public void setQuantitevendu(int quantitevendu) {
        this.quantitevendu = quantitevendu;
    }

    public String getObservationVente() {
        return observationVente;
    }

    public void setObservationVente(String observationVente) {
        this.observationVente = observationVente;
    }

    public String getTypeVente() {
        return typeVente;
    }

    public void setTypeVente(String typeVente) {
        this.typeVente = typeVente;
    }

    public Commande getCommandeConcerne() {
        return commandeConcerne;
    }

    public void setCommandeConcerne(Commande commandeConcerne) {
        this.commandeConcerne = commandeConcerne;
    }

    public ProduitFormateUnite getProduitFormatePVConcerne() {
        return produitFormateUniteConcerne;
    }

    public void setProduitFormatePVConcerne(ProduitFormateUnite produitFormateUniteConcerne) {
        this.produitFormateUniteConcerne = produitFormateUniteConcerne;
    }
}

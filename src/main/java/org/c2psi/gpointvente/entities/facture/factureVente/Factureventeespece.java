package org.c2psi.gpointvente.entities.facture.factureVente;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Factureventeespece {
    @Id
    String idFactureventeespece;
    int montantattenduFacturevente;
    int montantverseFacturevente;

    /**
     *Chaque factureventeespece est d'abord une facturevente qui elle est une facture
     */
    @DBRef
    Facturevente factureventeAssocie;

    public Factureventeespece() {
    }

    public Factureventeespece(String idFactureventeespece, int montantattenduFacturevente,
                              int montantverseFacturevente, Facturevente factureventeAssocie) {
        this.idFactureventeespece = idFactureventeespece;
        this.montantattenduFacturevente = montantattenduFacturevente;
        this.montantverseFacturevente = montantverseFacturevente;
        this.factureventeAssocie = factureventeAssocie;
    }

    public String getIdFactureventeespece() {
        return idFactureventeespece;
    }

    public void setIdFactureventeespece(String idFactureventeespece) {
        this.idFactureventeespece = idFactureventeespece;
    }

    public int getMontantattenduFacturevente() {
        return montantattenduFacturevente;
    }

    public void setMontantattenduFacturevente(int montantattenduFacturevente) {
        this.montantattenduFacturevente = montantattenduFacturevente;
    }

    public int getMontantverseFacturevente() {
        return montantverseFacturevente;
    }

    public void setMontantverseFacturevente(int montantverseFacturevente) {
        this.montantverseFacturevente = montantverseFacturevente;
    }

    public Facturevente getFactureventeAssocie() {
        return factureventeAssocie;
    }

    public void setFactureventeAssocie(Facturevente factureventeAssocie) {
        this.factureventeAssocie = factureventeAssocie;
    }
}

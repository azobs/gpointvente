package org.c2psi.gpointvente.entities.prix;

import org.c2psi.gpointvente.entities.prix.Devise;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RegleconversionDevise {
    @Id
    String idRegleconversionDevise;
    Double facteurconversionDevise;

    @DBRef
    Devise devisemultiple;
    @DBRef
    Devise devisesousmultiple;

    public RegleconversionDevise() {
    }

    public RegleconversionDevise(String idRegleconversionDevise, Double facteurconversionDevise,
                                 Devise devisemultiple, Devise devisesousmultiple) {
        this.idRegleconversionDevise = idRegleconversionDevise;
        this.facteurconversionDevise = facteurconversionDevise;
        this.devisemultiple = devisemultiple;
        this.devisesousmultiple = devisesousmultiple;
    }

    public String getIdRegleconversionDevise() {
        return idRegleconversionDevise;
    }

    public void setIdRegleconversionDevise(String idRegleconversionDevise) {
        this.idRegleconversionDevise = idRegleconversionDevise;
    }

    public Double getFacteurconversionDevise() {
        return facteurconversionDevise;
    }

    public void setFacteurconversionDevise(Double facteurconversionDevise) {
        this.facteurconversionDevise = facteurconversionDevise;
    }

    public Devise getDevisemultiple() {
        return devisemultiple;
    }

    public void setDevisemultiple(Devise devisemultiple) {
        this.devisemultiple = devisemultiple;
    }

    public Devise getDevisesousmultiple() {
        return devisesousmultiple;
    }

    public void setDevisesousmultiple(Devise devisesousmultiple) {
        this.devisesousmultiple = devisesousmultiple;
    }
}

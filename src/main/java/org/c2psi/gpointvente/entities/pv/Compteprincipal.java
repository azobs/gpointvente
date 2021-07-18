package org.c2psi.gpointvente.entities.pv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Compteprincipal {
    @Id
    String idCompteprincipal;
    Double soldeespece;

    /**
     * Un Compteprincipal appartient a un Pointvente
     */
    @JsonIgnore
    @DBRef
    Pointvente pointvente;

    public Compteprincipal() {
    }

    public Compteprincipal(String idCompteprincipal, Double soldeespece, Pointvente pointvente) {
        this.idCompteprincipal = idCompteprincipal;
        this.soldeespece = soldeespece;
        this.pointvente = pointvente;
    }

    public Compteprincipal(Double soldeespece) {
        this.soldeespece = soldeespece;
    }

    public String getIdCompteprincipal() {
        return idCompteprincipal;
    }

    public void setIdCompteprincipal(String idCompteprincipal) {
        this.idCompteprincipal = idCompteprincipal;
    }

    public Double getSoldeespece() {
        return soldeespece;
    }

    public void setSoldeespece(Double soldeespece) {
        this.soldeespece = soldeespece;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }

    @Override
    public String toString() {
        try {
            return "Compteprincipal{" +
                    "idCompteprincipal='" + idCompteprincipal + '\'' +
                    ", soldeespece=" + soldeespece +
                    ", pointvente= denomination(" + pointvente.getDenominationPv() + ")" +
                    '}';
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Compteprincipal{" +
                    "idCompteprincipal='" + idCompteprincipal + '\'' +
                    ", soldeespece=" + soldeespece +
                    '}';
        }
    }
}

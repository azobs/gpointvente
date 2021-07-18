package org.c2psi.gpointvente.entities.pv;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CompteemballagePv {
    @Id
    String idCompteemballagePV;
    int soldeinitial;
    String commentaire;



    public CompteemballagePv() {
    }

    public CompteemballagePv(String idCompteemballagePV, int soldeinitial, String commentaire) {
        this.idCompteemballagePV = idCompteemballagePV;
        this.soldeinitial = soldeinitial;
        this.commentaire = commentaire;

    }

    public CompteemballagePv(int soldeinitial, String commentaire) {
        this.soldeinitial = soldeinitial;
        this.commentaire = commentaire;
    }

    public String getIdCompteemballagePV() {
        return idCompteemballagePV;
    }

    public void setIdCompteemballagePV(String idCompteemballagePV) {
        this.idCompteemballagePV = idCompteemballagePV;
    }

    public int getSoldeinitial() {
        return soldeinitial;
    }

    public void setSoldeinitial(int soldeinitial) {
        this.soldeinitial = soldeinitial;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }



    @Override
    public String toString() {
        return "CompteemballagePv{" +
                "idCompteemballagePV='" + idCompteemballagePV + '\'' +
                ", soldeinitial=" + soldeinitial +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}

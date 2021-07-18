package org.c2psi.gpointvente.entities.prix;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Prixdebase {
    @Id
    String idPrixdebase;
    double prixdachatmoyen;
    double prixdegrosmoyen;
    double prixdesemigrosmoyen;
    double prixdedetailmoyen;
    double ristourneattendu;
    double precompteattendu;
    /*
    FormatAffichage: Long;  MoyenGSG; MoyenSGG; MoyenSGD; MoyenGD; CourtG; courtSG; courtD
    Long des prix: prix de gros, de sémi gros puis de détail
    MoyenGSG des prix: prix de gros puis de semi gros
    MoyenSGG des prix: prix de semi gros puis de gros
    MoyenSGD des prix: prix de semi gros puis de détail
    MoyenGD des prix: prix de gros puis de détail
    CourtG des prix: prix de gros
    CourtSG des prix: prix de semi gros
    CourtD des prix: prix de détail
     */
    String formataffichageprix;

    /**
     * Devise dans laquelle le prix est enregistree
     */
    @DBRef
    Devise devisePrix;


    /**
     * D'un prix de base decoule plusieurs prix speciaux applicable aux clients
     */
    @DBRef
    List<Prixspecial> listofPrixspecial = new ArrayList<>();

    public Prixdebase() {
    }

    public Prixdebase(String idPrixdebase, double prixdachatmoyen, double prixdegrosmoyen, double prixdesemigrosmoyen,
                      double prixdedetailmoyen, double ristourneattendu, double precompteattendu, String formataffichageprix,
                      Devise devisePrix) {
        this.idPrixdebase = idPrixdebase;
        this.prixdachatmoyen = prixdachatmoyen;
        this.prixdegrosmoyen = prixdegrosmoyen;
        this.prixdesemigrosmoyen = prixdesemigrosmoyen;
        this.prixdedetailmoyen = prixdedetailmoyen;
        this.ristourneattendu = ristourneattendu;
        this.precompteattendu = precompteattendu;
        this.formataffichageprix = formataffichageprix;
        this.devisePrix = devisePrix;
    }

    public String getIdPrixdebase() {
        return idPrixdebase;
    }

    public void setIdPrixdebase(String idPrixdebase) {
        this.idPrixdebase = idPrixdebase;
    }

    public double getPrixdachatmoyen() {
        return prixdachatmoyen;
    }

    public void setPrixdachatmoyen(double prixdachatmoyen) {
        this.prixdachatmoyen = prixdachatmoyen;
    }

    public double getPrixdegrosmoyen() {
        return prixdegrosmoyen;
    }

    public void setPrixdegrosmoyen(double prixdegrosmoyen) {
        this.prixdegrosmoyen = prixdegrosmoyen;
    }

    public double getPrixdesemigrosmoyen() {
        return prixdesemigrosmoyen;
    }

    public void setPrixdesemigrosmoyen(double prixdesemigrosmoyen) {
        this.prixdesemigrosmoyen = prixdesemigrosmoyen;
    }

    public double getPrixdedetailmoyen() {
        return prixdedetailmoyen;
    }

    public void setPrixdedetailmoyen(double prixdedetailmoyen) {
        this.prixdedetailmoyen = prixdedetailmoyen;
    }

    public double getRistourneattendu() {
        return ristourneattendu;
    }

    public void setRistourneattendu(double ristourneattendu) {
        this.ristourneattendu = ristourneattendu;
    }

    public double getPrecompteattendu() {
        return precompteattendu;
    }

    public void setPrecompteattendu(double precompteattendu) {
        this.precompteattendu = precompteattendu;
    }

    public String getFormataffichageprix() {
        return formataffichageprix;
    }

    public void setFormataffichageprix(String formataffichageprix) {
        this.formataffichageprix = formataffichageprix;
    }

    public Devise getDevisePrix() {
        return devisePrix;
    }

    public void setDevisePrix(Devise devisePrix) {
        this.devisePrix = devisePrix;
    }

    public List<Prixspecial> getListofPrixspecial() {
        return listofPrixspecial;
    }

    public void setListofPrixspecial(List<Prixspecial> listofPrixspecial) {
        this.listofPrixspecial = listofPrixspecial;
    }
}

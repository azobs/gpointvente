package org.c2psi.gpointvente.entities.prix;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Prixspecial {
    @Id
    String idPrixspecial;
    double  prixdachatmoyen;
    double prixdegrosmoyen;
    double prixdesemigrosmoyen;
    double prixdedetailmoyen;
    double ristourneattendu;
    double precompteattendu;
    int limitebassegros;
    int limitebassesemigros;

    /**
     * Un Prixspecial est toujours associe a un prixdebase
     */
    @DBRef
    Prixdebase prixdebaseAssocie;

    /******
     * Un prixspecial bien qu'associe a un prixdebase a sa propre devise
     */
    @DBRef
    Devise devise;

    public Prixspecial() {
    }

    public Prixspecial(String idPrixspecial, double prixdachatmoyen, double prixdegrosmoyen, double prixdesemigrosmoyen,
                       double prixdedetailmoyen, double ristourneattendu, double precompteattendu, int limitebassegros,
                       int limitebassesemigros, Prixdebase prixdebaseAssocie, Devise devise) {
        this.idPrixspecial = idPrixspecial;
        this.prixdachatmoyen = prixdachatmoyen;
        this.prixdegrosmoyen = prixdegrosmoyen;
        this.prixdesemigrosmoyen = prixdesemigrosmoyen;
        this.prixdedetailmoyen = prixdedetailmoyen;
        this.ristourneattendu = ristourneattendu;
        this.precompteattendu = precompteattendu;
        this.limitebassegros = limitebassegros;
        this.limitebassesemigros = limitebassesemigros;
        this.prixdebaseAssocie = prixdebaseAssocie;
        this.devise = devise;
    }

    public String getIdPrixspecial() {
        return idPrixspecial;
    }

    public void setIdPrixspecial(String idPrixspecial) {
        this.idPrixspecial = idPrixspecial;
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

    public void setPrecompteattendu(int precompteattendu) {
        this.precompteattendu = precompteattendu;
    }

    public int getLimitebassegros() {
        return limitebassegros;
    }

    public void setLimitebassegros(int limitebassegros) {
        this.limitebassegros = limitebassegros;
    }

    public int getLimitebassesemigros() {
        return limitebassesemigros;
    }

    public void setLimitebassesemigros(int limitebassesemigros) {
        this.limitebassesemigros = limitebassesemigros;
    }

    public Prixdebase getPrixdebaseAssocie() {
        return prixdebaseAssocie;
    }

    public void setPrixdebaseAssocie(Prixdebase prixdebaseAssocie) {
        this.prixdebaseAssocie = prixdebaseAssocie;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }
}

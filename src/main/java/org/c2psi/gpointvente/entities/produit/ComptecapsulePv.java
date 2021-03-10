package org.c2psi.gpointvente.entities.produit;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ComptecapsulePv {
    @Id
    String idComptecapsulePv;
    int soldecapsulePv;

    public ComptecapsulePv() {
    }

    public ComptecapsulePv(String idComptecapsulePv, int soldecapsulePv, Pointvente pointvente,
                           ProduitFormateUnite produitFormateUnite) {
        this.idComptecapsulePv = idComptecapsulePv;
        this.soldecapsulePv = soldecapsulePv;
    }

    public ComptecapsulePv(int soldecapsulePv, Pointvente pointvente,
                           ProduitFormateUnite produitFormateUnite) {
        this.soldecapsulePv = soldecapsulePv;
    }

    public String getIdComptecapsulePv() {
        return idComptecapsulePv;
    }

    public void setIdComptecapsulePv(String idComptecapsulePv) {
        this.idComptecapsulePv = idComptecapsulePv;
    }

    public int getSoldecapsulePv() {
        return soldecapsulePv;
    }

    public void setSoldecapsulePv(int soldecapsulePv) {
        this.soldecapsulePv = soldecapsulePv;
    }



    @Override
    public String toString() {
        return "ComptecapsulePv{" +
                "idComptecapsulePv='" + idComptecapsulePv + '\'' +
                ", soldecapsulePv=" + soldecapsulePv +
                '}';
    }
}

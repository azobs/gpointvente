package org.c2psi.gpointvente.entities.vente;

import org.c2psi.gpointvente.entities.pv.CompteemballagePv;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationemballagePv {
    @Id
    String idOperationemballage;
    int nbreenmvt;

    /**
     * Une operationemballage concerne toujours un compteemballagePV
     */
    @DBRef
    CompteemballagePv compteemballagePV;

    public OperationemballagePv() {
    }

    public OperationemballagePv(String idOperationemballage, int nbreenmvt, CompteemballagePv compteemballagePV) {
        this.idOperationemballage = idOperationemballage;
        this.nbreenmvt = nbreenmvt;
        this.compteemballagePV = compteemballagePV;
    }

    public String getIdOperationemballage() {
        return idOperationemballage;
    }

    public void setIdOperationemballage(String idOperationemballage) {
        this.idOperationemballage = idOperationemballage;
    }

    public int getNbreenmvt() {
        return nbreenmvt;
    }

    public void setNbreenmvt(int nbreenmvt) {
        this.nbreenmvt = nbreenmvt;
    }

    public CompteemballagePv getCompteemballagePV() {
        return compteemballagePV;
    }

    public void setCompteemballagePV(CompteemballagePv compteemballagePV) {
        this.compteemballagePV = compteemballagePV;
    }
}

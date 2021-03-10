package org.c2psi.gpointvente.entities.vente;

import org.c2psi.gpointvente.entities.pv.Compteprincipal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationespecePv {
    @Id
    String idOperationespece;
    int montantenmvt;

    /**
     * Une operationespece concerne toujours un compteespece
     */
    @DBRef
    Compteprincipal compteprincipal;

    public OperationespecePv() {
    }

    public OperationespecePv(String idOperationespece, int montantenmvt, Compteprincipal compteprincipal) {
        this.idOperationespece = idOperationespece;
        this.montantenmvt = montantenmvt;
        this.compteprincipal = compteprincipal;
    }

    public String getIdOperationespece() {
        return idOperationespece;
    }

    public void setIdOperationespece(String idOperationespece) {
        this.idOperationespece = idOperationespece;
    }

    public int getMontantenmvt() {
        return montantenmvt;
    }

    public void setMontantenmvt(int montantenmvt) {
        this.montantenmvt = montantenmvt;
    }

    public Compteprincipal getCompteprincipal() {
        return compteprincipal;
    }

    public void setCompteprincipal(Compteprincipal compteprincipal) {
        this.compteprincipal = compteprincipal;
    }
}

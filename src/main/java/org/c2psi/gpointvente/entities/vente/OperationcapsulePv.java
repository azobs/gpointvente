package org.c2psi.gpointvente.entities.vente;

import org.c2psi.gpointvente.entities.produit.ComptecapsulePv;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationcapsulePv {
    @Id
    String idOperationcapsulePv;
    int nbrecapsuleenmvtPv;

    /**
     * Une operationcapsulepv concerne toujours un comptecapsule
     */
    @DBRef
    ComptecapsulePv comptecapsulePv;

    /**
     * Une operationcapsulepv est  d'abord une operationPv
     */
    @DBRef
    OperationPv operationPv;


}

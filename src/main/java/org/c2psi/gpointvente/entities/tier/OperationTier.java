package org.c2psi.gpointvente.entities.tier;

import org.c2psi.gpointvente.entities.user.Employe;
import org.c2psi.gpointvente.entities.Operation;
import org.c2psi.gpointvente.entities.facture.Facture;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationTier {
    @Id
    String idOperationTier;
    /*
    *Une operationTier est d'abord une operation
    */
    @DBRef
    Operation operation;
    /*
     *Une operationTier peut concerner une facture
     */
    @DBRef
    Facture facture;
    /*
     *Une operationTier est toujours effectue par un employe
     */
    @DBRef
    Employe employe;

}

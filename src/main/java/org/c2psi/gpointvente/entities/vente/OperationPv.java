package org.c2psi.gpointvente.entities.vente;

import org.c2psi.gpointvente.entities.Operation;
import org.c2psi.gpointvente.entities.user.Utilisateur;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationPv {
    @Id
    String idOperationPv;
    /*
    *Une operation est  toujours  realise par un utilisateur soit un super admin
    * soit un administrateur du point de vente soit un employe
     */
    @DBRef
    Utilisateur user;
    /*
    *Une operationPv est d'abord une operation
     */
    @DBRef
    Operation operation;

}

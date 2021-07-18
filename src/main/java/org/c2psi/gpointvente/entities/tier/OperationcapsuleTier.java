package org.c2psi.gpointvente.entities.tier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationcapsuleTier {
    @Id
    String idOperationcapsuleTier;
    int nbrecapsuleenmvtTier;

    /**
     * Une operationcapsuleTier concerne toujours un comptecapsule
     */
    @DBRef
    ComptecapsuleTier comptecapsuleTier;

    /**
     * Une operationcapsuleTier est  d'abord une operationTier
     */
    @DBRef
    OperationTier operationTier;
}

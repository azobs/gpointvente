package org.c2psi.gpointvente.entities.tier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationespeceTier {
    @Id
    String idOperationespeceTier;
    int nbreespeceenmvtTier;

    /**
     * Une operationespeceTier concerne toujours un compteespece
     */
    @DBRef
    CompteespeceTier compteespeceTier;

    /**
     * Une operationespeceTier est  d'abord une operationTier
     */
    @DBRef
    OperationTier operationTier;
}

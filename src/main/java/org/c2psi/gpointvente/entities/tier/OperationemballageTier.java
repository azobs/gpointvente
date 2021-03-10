package org.c2psi.gpointvente.entities.tier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OperationemballageTier {
    @Id
    String idOperationemballageTier;
    int nbreemballageenmvtTier;

    /**
     * Une operationemballageTier concerne toujours un compteemballageTier
     */
    @DBRef
    CompteemballageTier compteemballageTier;

    /**
     * Une operationemballageTier est  d'abord une operationTier
     */
    @DBRef
    OperationTier operationTier;
}

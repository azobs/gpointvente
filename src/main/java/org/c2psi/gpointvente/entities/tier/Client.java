package org.c2psi.gpointvente.entities.tier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
    @Id
    String idClient;
    String typeClient;

    /**
     * Un client est un tier
     */
    @DBRef
    Tier tierClient;

    public Client() {
    }

    public Client(String idClient, String typeClient, Tier tierClient) {
        this.idClient = idClient;
        this.typeClient = typeClient;
        this.tierClient = tierClient;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public Tier getTierClient() {
        return tierClient;
    }

    public void setTierClient(Tier tierClient) {
        this.tierClient = tierClient;
    }
}

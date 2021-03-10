package org.c2psi.gpointvente.entities.prix;

import org.c2psi.gpointvente.entities.tier.Client;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class PrixspecialClient {
    String idPrixspecialClient;

    /**
     * Un prixspecialClient concerne un prixspecial
     */
    @DBRef
    Prixspecial prixspecialAccorde;
    /**
     * Un prixspecialclient conerne un client (celui qui bénéficie du prixspecial)
     */
    @DBRef
    Client clientConcerne;

    public PrixspecialClient() {
    }

    public PrixspecialClient(String idPrixspecialClient, Prixspecial prixspecialAccorde,
                             Client clientConcerne) {
        this.idPrixspecialClient = idPrixspecialClient;
        this.prixspecialAccorde = prixspecialAccorde;
        this.clientConcerne = clientConcerne;
    }

    public String getIdPrixspecialClient() {
        return idPrixspecialClient;
    }

    public void setIdPrixspecialClient(String idPrixspecialClient) {
        this.idPrixspecialClient = idPrixspecialClient;
    }

    public Prixspecial getPrixspecialAccorde() {
        return prixspecialAccorde;
    }

    public void setPrixspecialAccorde(Prixspecial prixspecialAccorde) {
        this.prixspecialAccorde = prixspecialAccorde;
    }

    public Client getClientConcerne() {
        return clientConcerne;
    }

    public void setClientConcerne(Client clientConcerne) {
        this.clientConcerne = clientConcerne;
    }
}

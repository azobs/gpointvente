package org.c2psi.gpointvente.services.facture.factureappro;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapprocapsule;
import org.c2psi.gpointvente.entities.produit.Arrivageparcapsule;

import java.util.Optional;

public interface FactureapprocapsuleService {
    Optional<Factureapprocapsule> findFactureapprocapsuleByIdFactureapprocapsule(String idFactureapprocapsule);
    Factureapprocapsule saveFactureapprocapsule(double estimationValeur, int nbrecapsuleAchange,
                                                int nbrecapsuleChange, Factureappro factureappro);
    int addArrivageparcapsuleToFactureapprocaspule(Arrivageparcapsule arrivageparcapsule,
                                                   Factureapprocapsule factureapprocapsule);
}

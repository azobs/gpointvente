package org.c2psi.gpointvente.dao.facture.factureAppro;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapprocapsule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FactureapprocapsuleRepository extends MongoRepository<Factureapprocapsule, String> {
    Optional<Factureapprocapsule> findFactureapprocapsuleByIdfactureapprocapsule(
            String idFactureapprocapsule);
    List<Factureapprocapsule> findAllByFactureapproAssocie(Factureappro factureappro);
}

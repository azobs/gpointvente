package org.c2psi.gpointvente.dao.facture.factureAppro;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FactureapproespeceRepository extends MongoRepository<Factureapproespece, String> {
    Optional<Factureapproespece> findFactureapproespeceByIdFactureapproespece(String idFactureapproespece);
    List<Factureapproespece> findAllByFactureapproAssocie(Factureappro factureappro);

}

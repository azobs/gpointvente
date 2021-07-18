package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.c2psi.gpointvente.entities.produit.Arrivageparespece;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ArrivageparespeceRepository extends MongoRepository<Arrivageparespece, String> {
    Optional<Arrivageparespece> findArrivageparespeceByIdArrivageparespece(String idArrivageparespece);
    List<Arrivageparespece> findAllByFactureapproespece(Factureapproespece factureapproespece);
}

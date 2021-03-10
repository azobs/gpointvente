package org.c2psi.gpointvente.dao.tier;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.c2psi.gpointvente.entities.tier.Tier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FournisseurRepository extends MongoRepository<Fournisseur, String> {
    Optional<Fournisseur> findFournisseurByIdFournisseur(String idFournisseur);
    List<Fournisseur> findFournisseurByTierFournisseur(Tier tierFournisseur);
}

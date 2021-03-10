package org.c2psi.gpointvente.dao.tier;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.tier.Fournir;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FournirRepository extends MongoRepository<Fournir, String> {
    Optional<Fournir> findFournirByIdFournir(String idFournir);
    List<Fournir> findAllByFournisseurAndPointvente(Fournisseur fournisseur, Pointvente pointvente);
    List<Fournir> findAllByPointvente(Pointvente pointvente);
}

package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface FamilleRepository extends MongoRepository<Famille, String> {
    Optional<Famille> findFamilleByIdFamille(String idFamille);
    List<Famille> findAllByCodeFamilleAndPointventeOrderByCodeFamille(String codeFamille, Pointvente pointvente);
}

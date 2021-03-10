package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UniteproduitRepository extends MongoRepository<Uniteproduit, String> {
    Optional<Uniteproduit> findUniteproduitByIdUnite(String uniteproduit);
    List<Uniteproduit> findAllByAbbreviationUniteENAndLibelleUniteENAndPointventeOrderByAbbreviationUniteEN(
            String abbreviationUniteEN, String libelleUniteEN, Pointvente pointvente);
    List<Uniteproduit> findAllByAbbreviationUniteFRAndLibelleUniteFRAndPointventeOrderByAbbreviationUniteFR(
            String abbreviationUniteFR, String libelleUniteFR, Pointvente pointvente);
    List<Uniteproduit> findAllByIdUniteAndPointvente(String idUnite, Pointvente pointvente);
}

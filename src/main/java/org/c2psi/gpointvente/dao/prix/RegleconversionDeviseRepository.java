package org.c2psi.gpointvente.dao.prix;

import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.prix.RegleconversionDevise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface RegleconversionDeviseRepository extends MongoRepository<RegleconversionDevise, String> {
    Optional<RegleconversionDevise> getRegleconversionDeviseByIdRegleconversionDevise(
            String idRegleconversionDevise);

    Optional<RegleconversionDevise>
    getRegleconversionDeviseByDevisemultipleIdDeviseAndDevisesousmultipleIdDevise(
            String idDevisemultiple, String idDevisesousmultiple);

    Optional<RegleconversionDevise> findAllByDevisemultipleAndDevisesousmultiple(Devise deviseMultiple,
                                                                                 Devise deviseSousMultiple);

}

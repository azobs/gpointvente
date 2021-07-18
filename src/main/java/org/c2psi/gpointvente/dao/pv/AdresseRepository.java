package org.c2psi.gpointvente.dao.pv;

import org.c2psi.gpointvente.entities.pv.Adresse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface AdresseRepository extends MongoRepository<Adresse, String> {
    Optional<Adresse> findAdresseByIdAdresse(String idAdresse);
}

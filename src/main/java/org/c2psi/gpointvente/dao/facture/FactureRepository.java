package org.c2psi.gpointvente.dao.facture;

import org.c2psi.gpointvente.entities.facture.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FactureRepository extends MongoRepository<Facture, String> {
}

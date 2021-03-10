package org.c2psi.gpointvente.dao.pv;

import org.c2psi.gpointvente.entities.pv.CompteemballagePv;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteemballagePvRepository extends MongoRepository<CompteemballagePv, String> {
}

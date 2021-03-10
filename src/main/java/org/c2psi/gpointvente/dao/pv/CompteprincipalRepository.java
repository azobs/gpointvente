package org.c2psi.gpointvente.dao.pv;

import org.c2psi.gpointvente.entities.pv.Compteprincipal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteprincipalRepository extends MongoRepository<Compteprincipal, String> {

}

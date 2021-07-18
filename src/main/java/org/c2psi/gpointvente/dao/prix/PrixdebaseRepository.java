package org.c2psi.gpointvente.dao.prix;

import org.c2psi.gpointvente.entities.prix.Prixdebase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PrixdebaseRepository extends MongoRepository<Prixdebase, String> {
    Optional<Prixdebase> findPrixdebaseByIdPrixdebase(String idPrixdebase);
}

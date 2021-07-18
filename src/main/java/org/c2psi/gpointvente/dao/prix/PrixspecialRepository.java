package org.c2psi.gpointvente.dao.prix;

import org.c2psi.gpointvente.entities.prix.Prixspecial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PrixspecialRepository extends MongoRepository<Prixspecial, String> {
    Optional<Prixspecial> findPrixspecialByIdPrixspecial(String idPrixspecial);
}

package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.produit.RegleconversionUnite;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RegleconversionUniteRepository extends MongoRepository<RegleconversionUnite, String> {
    Optional<RegleconversionUnite> findRegleconversionUniteByIdRcU(String idRcU);
    List<RegleconversionUnite> findAllByUnitemultipleAndUnitesousmultiple(Uniteproduit uniteMultiple,
                                                                          Uniteproduit unitesousMultiple);

}

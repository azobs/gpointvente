package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProduitFormateUniteRepository extends MongoRepository<ProduitFormateUnite, String> {
    Optional<ProduitFormateUnite> findProduitFormateUniteByIdPFU(String idPFU);
    List<ProduitFormateUnite> findAllByCodePFUAndPointventeOrderByCodePFU(String codePFU, Pointvente pointvente);
    List<ProduitFormateUnite> findAllByProduitFormateAndUnitePFU(ProduitFormate produitFormate, Uniteproduit unitePFU);
}

package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProduitFormateRepository extends MongoRepository<ProduitFormate, String> {
    Optional<ProduitFormate> findProduitFormateByIdPF(String idPF);
    List<ProduitFormate> findAllByProduitAFormateAndFormatPF(Produit produitAformate, Formatproduit formatPF);
}

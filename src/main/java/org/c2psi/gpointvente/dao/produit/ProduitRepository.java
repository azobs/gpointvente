package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProduitRepository extends MongoRepository<Produit, String> {
    Optional<Produit> findProduitByIdProduit(String idProduit);
    List<Produit> findAllByDesignationProduitENAndFamilleProduitOrderByDesignationProduitEN(String designationProduitEN, Famille familleProduit);
    List<Produit> findAllByDesignationProduitFRAndFamilleProduitOrderByDesignationProduitFR(String designationProduitFR, Famille familleProduit);
}

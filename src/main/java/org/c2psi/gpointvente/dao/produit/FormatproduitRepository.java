package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface FormatproduitRepository extends MongoRepository<Formatproduit, String> {
    Optional<Formatproduit> findFormatproduitByIdFormatproduit(String idFormatproduit);
    List<Formatproduit> findAllByContenanceAndDesignationFormatproduitENAndPointventeOrderByContenance(
            String contenance, String designationFormatproduitEN, Pointvente pointvente);
    List<Formatproduit> findAllByContenanceAndDesignationFormatproduitFRAndPointventeOrderByContenance(
            String contenance, String designationFormatproduitFR, Pointvente pointvente);
}

package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.produit.ArrivageProduitformate;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ArrivageProduitformateRepository extends MongoRepository<ArrivageProduitformate, String> {
    Optional<ArrivageProduitformate> findArrivageProduitformateByIdArrivageProduitFormate(
            String idArrivageproduitformate);
    List<ArrivageProduitformate> findAllByProduitformateConcerneAndTypeArrivageAndDateheurelivraisonArrivage(
            ProduitFormateUnite produitformateConcerne, String typeArrivage, Date dateheurelivraisonArrivage
    );


}

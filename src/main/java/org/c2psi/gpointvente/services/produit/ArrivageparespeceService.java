package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.c2psi.gpointvente.entities.produit.ArrivageProduitformate;
import org.c2psi.gpointvente.entities.produit.Arrivageparespece;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.exceptions.produit.QuantiteProduitIndisponibleException;
import org.c2psi.gpointvente.exceptions.produit.RegleconversionNotFoundException;

import java.util.Optional;

public interface ArrivageparespeceService {
    int isFactureapproespeceValide(Factureapproespece factureapproespece);
    int isArrivageProduitformateValide(ArrivageProduitformate arrivageProduitformate);


    Optional<Arrivageparespece> findArrivageparespeceByIdArrivageparespece(String idArrivageparespece);

    Arrivageparespece saveArrivageparespeceNormal(int quantitelivree, double prixunitaire,
                                            ArrivageProduitformate arrivageProduitformate,
                                            Factureapproespece factureapproespece);
    Arrivageparespece saveArrivageparespecePonctuel(int quantitelivree, double prixunitaire,
                                                  ArrivageProduitformate arrivageProduitformate);
    Arrivageparespece saveArrivageparespeceDecomposition(ProduitFormateUnite produitFormateUniteSource,
                                                         ProduitFormateUnite produitFormateUniteDestination,
                                                         ArrivageProduitformate arrivageProduitformate,
                                                         int quantiteADecomposer)
            throws QuantiteProduitIndisponibleException, RegleconversionNotFoundException;
    Arrivageparespece saveArrivageparespeceRecomposition(ProduitFormateUnite produitFormateUniteSource,
                                                         ProduitFormateUnite produitFormateUniteDestination,
                                                         ArrivageProduitformate arrivageProduitformate,
                                                         int quantiteARecomposer)
            throws QuantiteProduitIndisponibleException, RegleconversionNotFoundException;
}

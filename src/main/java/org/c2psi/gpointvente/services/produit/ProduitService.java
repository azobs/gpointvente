package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.c2psi.gpointvente.exceptions.pv.DesignationProduitNonUniqueInFamilleException;

public interface ProduitService {
    int isDesignationProduitENUniqueInFamille(String designationProduitEN, Famille familleProduit);
    int isDesignationProduitFRUniqueInFamille(String designationProduitFR, Famille familleProduit);
    int addProduitFormateToProduit(ProduitFormate produitFormate, Produit produit);
    Produit getProduitByIdProduit(String idProduit);
    Produit saveProduit(String designationProduitFR, String designationProduitEN, String aliasProduitFR,
                        String aliasProduitEN, String descriptionProduitFR, String descriptionProduitEN,
                        int perissable, Famille familleProduit)
            throws DesignationProduitNonUniqueInFamilleException;
}

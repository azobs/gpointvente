package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateNonUniqueException;

import java.util.Date;

public interface ProduitFormateService {
    /*******************************
     * retourne 1 si le produit passe en parametre a deja ete formate avec le format de produit passe
     * en parametre sinon il retourne 0
     * @param produit
     * @param formatproduit
     * @return
     */
    int isProduitFormateUniqueInPointvente(Produit produit, Formatproduit formatproduit);

    /*******************************
     * Un formatage est valide si le produit et le format appartiennent tous au même point de vente.
     * @param produit
     * @param formatproduit
     * @return 1 si le formatage est valide
     *         0 si le produit et le format sont dans des points de vente différent
     */
    int isProduitFormateValide(Produit produit, Formatproduit formatproduit);
    ProduitFormate saveProduitFormate(Produit produit, Formatproduit formatproduit, Date dateFormatage, String photoPF)
            throws ProduitFormateNonUniqueException, ProduitFormateMalFormedException;

    ProduitFormate saveProduitFormate(ProduitFormate produitFormate);
}

package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.prix.Prixdebase;
import org.c2psi.gpointvente.entities.produit.ComptecapsulePv;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateUniteMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateUniteNonUniqueException;

import java.util.Date;
import java.util.Optional;

public interface ProduitFormateUniteService {
    /***************************************************************************************************
     * Indique si la quantite passe en parametre est disponible en stock pour le produit passe en
     * parametre
     * @param produitFormateUnite
     * @param quantite
     * @return
     */
    boolean isQuantiteProduitDisponible(ProduitFormateUnite produitFormateUnite, int quantite);
    /*********************
     * Retourne 1 si le produitFormate passe en parametre est deja mesure avec l'unite passe en parametre
     * @param produitFormate
     * @param uniteproduit
     * @return 1 si l'association du produitFormate et de l'unite n'existe pas encore
     *         0 sinon
     */
    int isProduitFormateUniteUniqueInPointvente(ProduitFormate produitFormate, Uniteproduit uniteproduit);

    /************************
     * Verifie que le produitFormate et l'Uniteproduit qu'on veut associe appartiennent tous au meme point de vente
     * @param produitFormate
     * @param uniteproduit
     * @return 1 si c'est l'association des 02 n'existait pas encore
     *         0 sinon
     */
    int isProduitFormateUniteValide(ProduitFormate produitFormate, Uniteproduit uniteproduit);

    ProduitFormateUnite saveProduitFormateUnite(int seuilqte, int limitebassesemigros, int limitebassegros,
                                                String commentairePFU, String codePFU, ProduitFormate produitFormate,
                                                Uniteproduit uniteproduit, Pointvente pointvente, Prixdebase prixdebase,
                                                ComptecapsulePv comptecapsulePv, Date datePFU)
            throws ProduitFormateUniteNonUniqueException, ProduitFormateUniteMalFormedException;
    ProduitFormateUnite saveProduitFormateUnite(ProduitFormateUnite produitFormateUnite);
    Optional<ProduitFormateUnite> getProduitFormateUniteByIdPFU(String idPFU);

}

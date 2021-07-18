package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.entities.pv.Compteprincipal;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.pv.UnchangeableCompteprincipalOfPointventeException;
import org.c2psi.gpointvente.exceptions.pv.UnchangeableProprietaireOfCompteprincipalException;

public interface CompteprincipalService {
    Compteprincipal saveCompteprincipal(Double soldeespece);
    Compteprincipal updateCompteprincipal(String idCompteprincipal, Double newsoldeespece);
    Compteprincipal updateCompteprincipal(Compteprincipal compteprincipal);
    Compteprincipal getCompteprincipal(String idCompteprincipal);

    /***
     * Cette methode va definir comme proprietaire du compte principal passe en parametre le point de vente
     * passe en parametre.
     * Si ce compte a deja un point de vente different de celui passe en parametre,
     * une exception est lance de type UnchangeableProprietaireOfCompteprincipalException.
     * Si plutot c'est le point de vente qui a deja un compteprincipal différent de celui passe en parametre,
     * une exception de type UnchangeableCompteprincipalOfPointventeException
     *
     * @param compteprincipal
     * @param pointvente
     * @return
     * @throws UnchangeableProprietaireOfCompteprincipalException
     * @throws UnchangeableCompteprincipalOfPointventeException
     */
    int AssocierCompteprincipalAPointvente(Compteprincipal compteprincipal, Pointvente pointvente) throws
            UnchangeableProprietaireOfCompteprincipalException, UnchangeableCompteprincipalOfPointventeException;

}

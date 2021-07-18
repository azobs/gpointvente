package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.entities.pv.Entreprise;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.pv.EntrepriseNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.SigleEntrepriseNonUniqueException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EntrepriseService {

    /*********************************************************
     * FONCTION PERMETTANT D'ENREGISTRER DANS LA BD
     *********************************************************/

    /**
     * Enregistre une entreprise dans le systeme dont les donnees sont passe en parametre.
     * Retourne L'objet Entreprise enregistre ou leve une exception de type EntrepriseException en
     * cas d'erreur.
     * @param regimeEntr
     * @param raisonsocialeEntr
     * @param descriptionEntr
     * @param logoEntr
     * @param deviseEntr
     * @param sigleEntr
     * @return
     * @throws SigleEntrepriseNonUniqueException
     */
    Entreprise saveEntreprise(String regimeEntr, String raisonsocialeEntr, String descriptionEntr,
                              String  logoEntr, String deviseEntr, String sigleEntr)
            throws SigleEntrepriseNonUniqueException;

    /**
     * Met a jour l'entreprise passe en parametre avec les données de l'objet entModifie pris
     * en parametre. L'entreprise a modifie est identifié par son identifiant passe en parametre.
     * L'entreprise  modifie est retourne ou une exception indiquant le type d'erreur rencontré.
     * Precondition: le sigle de l'entreprise doit etre unique
     * @param idoldEntreprise
     * @param newregimeEntr
     * @param newraisonsocialeEntr
     * @param newdescriptionEntr
     * @param newlogoEntr
     * @param newdeviseEntr
     * @param newsigleEntr
     * @return
     * @throws EntrepriseNotFoundException
     * @throws SigleEntrepriseNonUniqueException
     */
    Entreprise updateEntreprise(String idoldEntreprise, String newregimeEntr, String newraisonsocialeEntr,
                                String newdescriptionEntr, String  newlogoEntr, String newdeviseEntr,
                                String newsigleEntr)
            throws EntrepriseNotFoundException, SigleEntrepriseNonUniqueException;

    /*************************************************************
     * FONCTION DE SUPPRESSION DES DONNEES EN BD
     *************************************************************/

    /**
     * Supprime l'entreprise dont l'identifiant est passe en parametre
     * Retourne 1 lorsque la suppression s'est deroule avec succes.
     * Si l'entreprise n'est pas trouve une exception l'indiquant est levee
     * @param idEntreprise
     * @return
     * @throws EntrepriseNotFoundException
     */
    int deleteEntreprise(String idEntreprise) throws EntrepriseNotFoundException;

    /**********************************************************************************
     * FONCTION DE RECHERCHE DES DONNEES ET DES LISTES DE DONNEES EN BD
     **********************************************************************************/

    /**
     * Retourne l'entreprise dont l'identifiant est passe en paramètre ou leve une
     * exception lorsqu'aucune entreprise n'existe avec cet identifiant
     * @param idEntreprise
     * @return
     * @throws EntrepriseNotFoundException
     */
    Entreprise getEntrepriseById(String idEntreprise) throws EntrepriseNotFoundException;

    /**
     * Retourne l'entreprise qui a pour sigle celui passe en parametre. Une exception est levee si
     * aucune entreprise ne correspond à ce sigle
     * @param sigleEntreprise
     * @return
     * @throws EntrepriseNotFoundException
     */
    Entreprise getEntrepriseBySigle(String sigleEntreprise) throws EntrepriseNotFoundException;

    /**
     * Retourne la liste des points de vente d'une entreprise dans un certain ordre.
     * @param idEntreprise
     * @param ordre
     * @return
     */
    List<Pointvente> getListofPointvente (String idEntreprise, int ordre);

    /**
     * Retourne page par page la liste des points de vente d'une entreprise dans un certain ordre.
     * @param idEntreprise
     * @param numPage
     * @param taillePage
     * @param ordre
     * @return
     */
    Page<Pointvente> getPageofPointvente (String idEntreprise, int numPage, int taillePage, int ordre);

    /**
     * Retourne la liste de toutes les entreprises  gere par le système dans un
     * certain ordre.
     * @param ordre
     * @return
     */
    List<Entreprise> getListofEntreprise(int ordre);

    /**
     * Retourne page par page la liste de toutes les entreprises  gere par le système dans un
     * certain ordre.
     * @param ordre
     * @return
     */
    Page<Entreprise> getPageofEntreprise(int numPage, int taillePage, int ordre);

    /**********************************************
     * FONCTION DE MANIPULATION DES DONNEES EN BD
     **********************************************/

    /**
     * permet d'ajouter le point de vente passe en paramètre a l'entreprise passe en parametre.
     * retourne 1 si l'ajout a été effectué avec succes et 0 sinon
     * @param pointvente
     * @param entreprise
     * @return
     */
    int addPointventeToEntreprise(Pointvente pointvente, Entreprise entreprise);

    /***********************************************
     * FONCTION DE VERIFICATION DES DONNEES EN BD
     ***********************************************/

    /**
     * Retourne 1 si le point de vente pris en parametre est deja ajouter dans l'entreprise prise
     * en parametre. 0 sinon
     * @param pointvente
     * @param entreprise
     * @return
     */
    int isPointventeOfEntreprise(Pointvente pointvente, Entreprise entreprise);

    /***
     * Retourne 1 si une entreprise existe avec le sigle passe en parametre
     * et 0 sinon
     * @param sigle
     * @return
     */
    int isSigleEntrUnique(String sigle);


}

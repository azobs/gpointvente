package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.produit.*;
import org.c2psi.gpointvente.entities.pv.*;
import org.c2psi.gpointvente.exceptions.pv.AdresseNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.DenominationPvNonUniqueInEntrepriseException;
import org.c2psi.gpointvente.exceptions.prix.DeviseNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.PointventeNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PointventeService {

    /***
     * Cette methode permet d'enregistrer un point de vente d'une entreprise dans le système.
     * 02 point de vente ne peuvent pas avoir la même dénomination dans une même entreprise.
     * @param descriptionPv
     * @param denominationPv
     * @param adressePv
     * @param compteprincipalPv
     * @param entreprise
     * @return
     * @throws DenominationPvNonUniqueInEntrepriseException
     */
    Pointvente savePointvente(String descriptionPv, String denominationPv, Adresse adressePv,
                              Compteprincipal compteprincipalPv, Entreprise entreprise)
            throws DenominationPvNonUniqueInEntrepriseException;

    Pointvente savePointvente(Pointvente pointvente);

    /****
     * Cette methode met a jour les parametres propres au point de vente sans toucher au document lie
     * @param idPointventeAModifie
     * @param newDescriptionPv
     * @param newDenominationPv
     * @return
     * @throws DenominationPvNonUniqueInEntrepriseException
     */
    Pointvente updateParamPointvente(String idPointventeAModifie, String newDescriptionPv, String newDenominationPv)
            throws PointventeNotFoundException, DenominationPvNonUniqueInEntrepriseException;

    /***
     * Cette methode reinitialise le compte principal d'un Point de vente. Cette reinitialisation provoque
     * une opération qui devrait etre enregistré depuis le service des operations. On connait l'identifiant
     * du point de vente et la nouvelle valeur du compte
     * @param idPointventeAModifie
     * @param newValeur
     * @return
     */
    int resetSoldeCompteprincipal(String idPointventeAModifie, Double newValeur);

    /****
     * Modifie l'adresse d'un point de vente. Le point de vente est identifie par son id et la nouvelle
     * adresse est dans l'objet newAdressePv
     * @param idPointventeAModifieAdresse
     * @param newnumtel1Adr
     * @param newnumtel2Adr
     * @param newnumtel3Adr
     * @param newemailAdr
     * @param newquartierAdr
     * @param newvilleAdr
     * @param newpaysAdr
     * @param newplanlocalisationAdr
     * @return
     * @throws PointventeNotFoundException
     * @throws AdresseNotFoundException
     */
    int updateAdressePointvente(String idPointventeAModifieAdresse, String newnumtel1Adr, String newnumtel2Adr,
                                String newnumtel3Adr, String newemailAdr, String newquartierAdr,
                                String newvilleAdr, String newpaysAdr, String newplanlocalisationAdr)
            throws PointventeNotFoundException, AdresseNotFoundException;

    int addDeviseToPointvente(Devise devise, Pointvente pointvente);

    int addTypeemballageToPointvente(Typeemballage typeemballage, Pointvente pointvente);

    int addFamilleToPointvente(Famille familleproduit, Pointvente pointvente);

    int addFormatproduitToPointvente(Formatproduit formatproduit, Pointvente pointvente);

    int addProduitFormateUniteToPointvente(ProduitFormateUnite produitFormateUnite, Pointvente pointvente);

    int addUniteproduitToPointvente(Uniteproduit uniteproduit, Pointvente pointvente);

    int updateDevisePointvente(String idPointventeAModifieDevise, String newlibelleDeviseEN,
                               String newlibelleDeviseFR, String newabbreviationDeviseEN,
                               String newabbreviationFR, String newformataffichageDeviseEN,
                               String newformataffichageDeviseFR)
            throws PointventeNotFoundException, DeviseNotFoundException;


    int deletePointvente(String idPointvente);

    /**
     * Retourne 1 si le point de vente pris en parametre est le dernier point de vente
     * de l'entreprise prise en paramètre et 0 sinon
     * @param pv
     * @param ent
     * @return
     */
    int isLastPointventeInEntreprise(Pointvente pv, Entreprise ent);

    /**
     * Retourne 1 si le point de vente  pris en parametre est bel et bien le point de vente de l'entreprise
     * prise en parametre.
     * @param pv
     * @param ent
     * @return
     */
    int isPointventeOfEntreprise(Pointvente pv, Entreprise ent);

    /**
     * Retourne le point  de vente  dont l'identifiant est passe en parametre et null si
     * aucun point  de  vente ne correspond a  cet identifiant
     * @param idPointvente
     * @return
     */
    Pointvente getPointventeById(String idPointvente);

    /**
     * Chaque point de vente a une denomination unique dans une entreprise. Cette methode retourne
     * le point de vente dont la denomination est passe en parametre et appartenant a l'entreprise
     * passe en parametre.
     * Elle retourne null si aucun point  de vente dans l'entreprise passe en parametre n'a
     * comme denomination celle  passe en parametre
     * @param denomination
     * @param ent
     * @return
     */
    Pointvente getPointventeByDenominationInEntreprise (String denomination, Entreprise ent);

    /**
     * Retourne le nombre de point  de vente de l'entreprise prise en parametre
     * @param entreprise
     * @return
     */
    int getNombrePointventeEntreprise(Entreprise entreprise);

    /**
     * Retourne la liste de tous les points de vente quelque soit  l'entreprise dans l'ordre
     * préciser en paramètre. ce parametre ordre est indique dans la classe ConstanteOrdre
     * @param ordre
     * @return
     */
    List<Pointvente> getlistofpointvente(int ordre);

    /****
     * Retourne la liste des point de vente de l'entreprise passe en parametre dans un certain ordre
     * @param idEntreprise
     * @param ordre
     * @return
     */
    List<Pointvente> getlistofpointventeofentreprise(String idEntreprise, int ordre);

    public Page<Pointvente> getpageofpointventeofentreprise(String idEntreprise, int numPage, int taillePage,
                                                            int ordre);

    /**
     * retourne la liste des points de vente dont la  denomination contient le motcle passe en
     * parametre dans un certain ordre.
     * @param motcle
     * @param ordre
     * @return
     */
    List<Pointvente> getlistofpointvente(String motcle, int ordre);

    List<Pointvente> getlistofpointventeofentreprise(String idEntreprise, String motcle, int ordre);

    /**
     * Retourne page par page la liste de tous les points de vente quelque soit  l'entreprise dans l'ordre
     * préciser en paramètre. ce parametre ordre est indique dans la classe ConstanteOrdre
     * @param numPage
     * @param taillePage
     * @param ordre
     * @return
     */
    Page<Pointvente> getpageofpointvente(int numPage, int taillePage, int ordre);

    /**
     * retourne page par page la liste des points de vente dont la  denomination contient le motcle passe en
     * parametre dans un certain ordre.
     * @param motCle
     * @param numPage
     * @param taillePage
     * @param ordre
     * @return
     */
    Page<Pointvente> getpageofpointvente(String motCle, int numPage, int taillePage, int ordre);



    /*
    Concernant les types d'emballage pris en charge par  le  point de vente
     */

    /**
     * Elle enregistre le type d'emballage passe  en parametre pour le Point de vente passe en
     * parametre
     * Chaque point de ventepeut avoir un certain type d'emballage qu'il desire gerer les entrees et
     * les  sorties. Cette methode permet de les enregistrer dans le  système pour chaque point de vente
     * @param typeemballage
     * @param pointvente
     * @return
     */
    Typeemballage saveTypeemballage(Typeemballage typeemballage, Pointvente pointvente);

    /**
     * Mettre a jour  le type d'emballage dont l'identifiant est passe en parametre. Les nouvelles
     * donnes sont dans l'objet newtypeemballage passe  en parametre
     * @param idOldTypeemballage
     * @param newtypeemballage
     * @return
     */
    Typeemballage updateTypeemballage(String idOldTypeemballage, Typeemballage newtypeemballage);

    /**
     * Retourne la liste des types d'emballage gérés au niveau du point  de vente pris en parametre
     * dans l'ordre specifie en parametre
     * @param pv
     * @param ordre
     * @return
     */
    List<Typeemballage> getListofTypeemballagedePointvente(Pointvente pv, int ordre);

    /**
     * Retourne page par page la liste des types d'emballage gérés au niveau du point  de vente pris en parametre
     * dans l'ordre specifie en parametre
     * @param pv
     * @param numPage
     * @param taillepage
     * @param ordre
     * @return
     */
    Page<Typeemballage> getPageofTypeemballagedePointvente(Pointvente pv, int numPage,
                                                           int taillepage, int ordre);

    /**
     * Supprime un type d'emballage du système. Le type d'emballage en question ne sera plus
     * pris en compte parmi les type d'emballage gere par le point de vente ou il  etait gere
     * @param typeemballage
     * @return
     */
    int deleteTypeemballage(Typeemballage typeemballage);

    /**
    Gestion des comptes associes  a un point de vente
     */
    /**
     * Gestion des comptes emballage (Un compte pour chaque type d'emballage du point de vente)
     */
    /**
     * Enregistre un compteemballage pour le point de vente et le type d'emballage  passe
     * en parametre.
     * @param pointvente
     * @param typeemballage
     * @return
     */
    CompteemballagePv saveCompteemballagePv(Pointvente pointvente, Typeemballage typeemballage);

    /**
     * Supprime le compteemballage cree pour un type d'emballage dans un point  de vente donne
     * @param compteemballagePV
     * @return
     */
    int deleteCompteemballagePv(CompteemballagePv compteemballagePV);

    /**
     * Retourne le  solde d'un compte de type d'emballage dans un point de vente.  Le compte
     * d'emballage est pris en parametre et son solde  represente le nombre d'emballage de ce
     * type que possede le point de vente  proprietaire de ce compte
     * @param compteemballagePv
     * @return
     */
    int getSoldeCompteemballagePv(CompteemballagePv compteemballagePv);

    /**
     * Mettre a jour le solde d'un compte de type d'emballage
     * @param compteemballagePv
     * @return
     */
    int updateSoldeCompteemballagePv (CompteemballagePv compteemballagePv);

    /**
     * Retourne le compteemballage associe au point de vente et au  type d'emballage pris en
     * parametre
     * @param pointvente
     * @param typeemballage
     * @return
     */
    CompteemballagePv getCompteemballagePv(Pointvente pointvente, Typeemballage typeemballage);

    /**
     * Retourne la liste des comptes d'emballage du point  de vente pris en parametre dans un certain
     * ordre.
     * @param pointvente
     * @param ordre
     * @return
     */
    List<CompteemballagePv> getListofCompteemballagePv(Pointvente pointvente, int ordre);

    /**
     * Retourne page par page la liste des comptes d'emballage du point  de vente pris en parametre dans un certain
     *   ordre.
     * @param pointvente
     * @param numPage
     * @param taillePage
     * @param ordre
     * @return
     */
    Page<CompteemballagePv> getPageofCompteemballagePv(Pointvente pointvente, int numPage,
                                                       int taillePage, int ordre);

    /**
     *Gestion des comptes capsule  (Un compte capsule pour chaque produit vendu dans
     *le point  de vente)
     */

    /**
     * Enregistre un comptecapsule  pour le point de vente et le  produitformatunite passe en
     * parametre (produitformatunite  correspond a  un produit vendu  dans un point  de vente)
     * @param pointvente
     * @param produitFormateUnite
     * @return
     */
    ComptecapsulePv saveComptecapsulePv(Pointvente pointvente,
                                        ProduitFormateUnite produitFormateUnite);

    /**
     * Supprimer un comptecapsule du  système. retourne 1 si la suppression s'est bien passe et  0
     * sinon
     * @param comptecapsulePv
     * @return
     */
    int deleteComptecapsulePv(ComptecapsulePv comptecapsulePv);

    /**
     * Retourne le solde du compte capsule passe en parametre
     * @param comptecapsulePv
     * @return
     */
    int getSoldeComptecapsulePv(ComptecapsulePv comptecapsulePv);

    /**
     * Met a jour le  solde  du compte capsule passe en parametre.
     * retourne 1 si cette mise a jour s'est bien passe et  0 sinon.
     * @param comptecapsulePv
     * @return
     */
    int updateSoldeComptecapsulePv(ComptecapsulePv  comptecapsulePv);

    /**
     * Retourne le  compte  capsule associe au point de  vente et au produitformateunite passe
     * en parametre ou null s'il n'existe pas
     * @param pointvente
     * @param produitFormateUnite
     * @return
     */
    ComptecapsulePv  getComptecapsulePv(Pointvente pointvente,
                                        ProduitFormateUnite produitFormateUnite);

    /**
     * Retourne la liste  de tous les comptecapsules associe au point  de vente passe en parametre
     * dans un certain ordre
     * @param pointvente
     * @param ordre
     * @return
     */
    List<ComptecapsulePv> getListofComptecapsulePv(Pointvente pointvente, int ordre);

    /**
     * Retourne page par page la liste  de tous les comptecapsules associe au point de vente passe en parametre
     * dans un certain ordre.
     * @param pointvente
     * @param numPage
     * @param taillePage
     * @param ordre
     * @return
     */
    Page<ComptecapsulePv> getPageofComptecapsulePv(Pointvente pointvente, int numPage,
                                                       int taillePage, int ordre);

    /**
     * Gestion  des comptes espece (Chaque point  de vente a un compte principal pour gerer les entrées
     * et les sorties d'argent par des moyens non lie a l'achat ou la vente)
     */

    /**
     * Enregistre le  compte principal du point de vente passe en parametre
     * Elle retourne le compteprincipal créé ou null  si aucun compte n'a été créé
     * @param pointvente
     * @return
     */
    Compteprincipal saveCompteprincipal(Pointvente pointvente);

    /**
     * Supprime le compte principal passe en parametre. Retourne 1 si la suppression s'est  bien
     * passe et 0 sinon.
     * @param compteprincipal
     * @return
     */
    int deleteCompteprincipal(Compteprincipal compteprincipal);

    /**
     * Retourne le solde du compte principal passe en parametre
     * @param compteprincipal
     * @return
     */
    int getSoldeCompteprincipal(Compteprincipal compteprincipal);

    /**
     * Met a  jour le solde du compte principale passe en parametre  et
     * retourne 1 si cette mise à jour s'est bien passe. 0 sinon
     * @param compteprincipal
     * @return
     */
    int updateSoldeCompteprincipal(Compteprincipal compteprincipal);

    /**
     * Retourne le compte  principal  associe  au point de vente passe en parametre.
     * Elle retourne le Compteprincipal en question ou null si aucun compte n'est associe.
     * @param pointvente
     * @return
     */
    Compteprincipal  getCompteprincipal(Pointvente pointvente);

    /****
     * Retourne 1 si la denomination prise en parametre sera unique parmi les denominations des points de vente
     * de l'entreprise prise en parametre
     * @param entreprise
     * @return
     */
    int isDenominationPvUniqueInEntreprise(String denomination, Entreprise entreprise);

}

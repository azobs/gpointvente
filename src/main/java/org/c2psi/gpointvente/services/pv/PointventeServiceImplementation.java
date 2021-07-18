package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.constantes.ConstanteOrdre;
import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.dao.produit.PointventeRepository;
import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.produit.*;
import org.c2psi.gpointvente.entities.pv.*;
import org.c2psi.gpointvente.exceptions.pv.AdresseNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.DenominationPvNonUniqueInEntrepriseException;
import org.c2psi.gpointvente.exceptions.prix.DeviseNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.PointventeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PointventeServiceImplementation implements PointventeService {
    @Autowired
    PointventeRepository pointventeRepository;
    @Autowired
    AdresseService adresseService;


    @Override
    public Pointvente savePointvente(String descriptionPv, String denominationPv, Adresse adressePv,
                                     Compteprincipal compteprincipalPv, Entreprise entreprise)
            throws DenominationPvNonUniqueInEntrepriseException {
        /*
        Il faut d'abord verifier que la denomination du point de vente sera unique parmi les denomination des
        point de vente de l'entreprise passe en parametre
         */
        /*List<Pointvente> listofPvAvecDenomination =
                pointventeRepository.findAllByDenominationPvOrderByDenominationPv(denominationPv);
        for(Pointvente pv : listofPvAvecDenomination){
            if(pv.getEntreprisePv().getSigleEntr().equalsIgnoreCase(entreprise.getSigleEntr())){*/
                /*
                On a trouve que la denomination passe en parametre correspond a celle d'un point de vente
                dans la meme entreprise donc on leve une exception
                 */
                /*throw new DenominationPvNonUniqueInEntrepriseException("Un point de vente de la meme " +
                        "entreprise a deja la denomination choisie");
            }
        }*/

        if(this.isDenominationPvUniqueInEntreprise(denominationPv, entreprise)==0)
            throw new DenominationPvNonUniqueInEntrepriseException("Exception levee: " +
                    "Un point de vente de la meme entreprise a deja la denomination choisie");

        Pointvente pointvente = new Pointvente();
        pointvente.setEntreprisePv(entreprise);
        pointvente.setAdressePv(adressePv);
        pointvente.setCompteprincipalPv(compteprincipalPv);
        pointvente.setDenominationPv(denominationPv);
        pointvente.setDescriptionPv(descriptionPv);
        Pointvente pointventeEnregistre = pointventeRepository.save(pointvente);
        /*
        On doit ajouter le point de vente en question dans la liste des points de vente de l'entreprise
         */
        //entreprise.getListofPointvente().add(pointventeEnregistre);
        return pointventeEnregistre;
    }

    @Override
    public Pointvente savePointvente(Pointvente pointvente){
        return pointventeRepository.save(pointvente);
    }


    @Override
    public Pointvente updateParamPointvente(String idPointventeAModifie,
                                            String newDescriptionPv, String newDenominationPv)
            throws DenominationPvNonUniqueInEntrepriseException, PointventeNotFoundException {
        Optional<Pointvente> pointventeAModifier =
                pointventeRepository.findPointventeByIdPointvente(idPointventeAModifie);
        if(pointventeAModifier.isPresent()){
            /*
            On a retrouve le point de vente. On verifie si c'est la denomination qu'on souhaite changer
             */
            if(pointventeAModifier.get().getDenominationPv().equalsIgnoreCase(newDenominationPv)){
                /*
                Alors on va aussi changer la denomination donc on doit verifie qu'elle sera unique dans
                l'entreprise
                 */
                List<Pointvente> listofPvAvecDenomination =
                        pointventeRepository.findAllByDenominationPvOrderByDenominationPv(newDenominationPv);
                for(Pointvente pv : listofPvAvecDenomination){
                    Entreprise entreprise = pointventeAModifier.get().getEntreprisePv();
                    if(pv.getEntreprisePv().getSigleEntr().equalsIgnoreCase(entreprise.getSigleEntr())){
                        /*
                        On a trouve que la denomination passe en parametre correspond a celle d'un point de vente
                        dans la meme entreprise donc on leve une exception
                         */
                        throw new DenominationPvNonUniqueInEntrepriseException("Un point de vente de la meme " +
                                "entreprise a deja la denomination choisie");
                    }
                }
                /*
                On peut effectuer la mise a jour sans succes car si on est ici alors aucun probleme
                 */
                pointventeAModifier.get().setDescriptionPv(newDescriptionPv);
                pointventeAModifier.get().setDenominationPv(newDenominationPv);
                Pointvente pv = pointventeRepository.save(pointventeAModifier.get());
                return pv;
            }
            else{
                /*
                On ne veut pas modifier la denomination
                 */
                pointventeAModifier.get().setDenominationPv(newDenominationPv);
                Pointvente pv = pointventeRepository.save(pointventeAModifier.get());
                return pv;
            }

        }
        else{
            throw new PointventeNotFoundException("Le point de vente que vous voulez modifie ne se retrouve pas " +
                    "en base de donnees");
        }
    }

    @Override
    public int resetSoldeCompteprincipal(String idPointventeAModifie, Double newValeur) {
        /*
        Dans cette methode, on va appeler le service qui gère les opérations sur les comptes.
        Ce service va modifie le solde de ce compte et retourne sa valeur de retour qui sera utilise.
         */
        return ValeurRetour.successReinitialisationcompteprincipalPointvente;
    }

    @Override
    public int updateAdressePointvente(String idPointventeAModifieAdresse, String newnumtel1Adr, String newnumtel2Adr,
                                       String newnumtel3Adr, String newemailAdr, String newquartierAdr,
                                       String newvilleAdr, String newpaysAdr, String newplanlocalisationAdr)
            throws PointventeNotFoundException, AdresseNotFoundException {
        Optional<Pointvente> pointventeAModifierAdresse =
                pointventeRepository.findPointventeByIdPointvente(idPointventeAModifieAdresse);
        if(pointventeAModifierAdresse.isPresent()){
            /*
            Le point de vente dont l'adresse sera modifie a été trouve en base de donnee
            On va donc recuperer l'adresse a modifier
             */
            Optional<Adresse> adresseAModifier =
                    Optional.ofNullable(pointventeAModifierAdresse.get().getAdressePv());
            if(adresseAModifier.isPresent()){
                adresseService.updateAdresse(idPointventeAModifieAdresse, newnumtel1Adr, newnumtel2Adr,
                        newnumtel3Adr, newemailAdr, newquartierAdr, newvilleAdr, newpaysAdr,
                        newplanlocalisationAdr);
                return ValeurRetour.successUpdateAdressePointvente;
            }
            else{
                /*
                Si on est la alors le point de vente n'avait pas d'adresse en base de donnee
                C'est donc l'occasion de la definir
                 */
                adresseService.saveAdresse(newnumtel1Adr, newnumtel2Adr, newnumtel3Adr,
                        newemailAdr,newquartierAdr, newvilleAdr, newpaysAdr, newplanlocalisationAdr);
                return ValeurRetour.successCreateAdressePointvente;
            }

        }
        else{
            /*
            ici signifie qu'on n'a pas trouve le point de vente dont l'adresse sera modifie en
            base de donnee
             */
            throw new PointventeNotFoundException("le point de vente dont l'adresse devrait etre modifie " +
                    "est inexistant");
        }
    }

    @Override
    public int addDeviseToPointvente(Devise devise, Pointvente pointvente) {
        pointvente.getListofDevisePv().add(devise);
        pointventeRepository.save(pointvente);
        System.out.println("l'association de la devise au point de vente est realisee");
        return 1;
    }

    @Override
    public int addTypeemballageToPointvente(Typeemballage typeemballage, Pointvente pointvente) {
        pointvente.getListofTypeemballagePv().add(typeemballage);
        pointventeRepository.save(pointvente);
        System.out.println("L'association du type d'emballage au point de vente est réalisée");
        return 1;
    }

    @Override
    public int addFamilleToPointvente(Famille familleproduit, Pointvente pointvente){
        pointvente.getListofFamilleproduitPv().add(familleproduit);
        pointventeRepository.save(pointvente);
        System.out.println("L'association de la famille au point de vente a ete realisee");
        return 1;
    }

    @Override
    public int addFormatproduitToPointvente(Formatproduit formatproduit, Pointvente pointvente) {
        pointvente.getListofFormatproduitPv().add(formatproduit);
        pointventeRepository.save(pointvente);
        System.out.println("L'association du format de produit au point de vente a ete realisee");
        return 1;
    }

    @Override
    public int addProduitFormateUniteToPointvente(ProduitFormateUnite produitFormateUnite, Pointvente pointvente) {
        pointvente.getListofProduitFormateUnite().add(produitFormateUnite);
        pointventeRepository.save(pointvente);
        System.out.println("L'association du produitformateunite avec le pointvente a ete faite avec success");
        return 1;
    }

    @Override
    public int addUniteproduitToPointvente(Uniteproduit uniteproduit, Pointvente pointvente) {
        pointvente.getListofUniteproduitPv().add(uniteproduit);
        pointventeRepository.save(pointvente);
        System.out.println("L'association de l'unite au point de vente a ete faite avec success");
        return 1;
    }


    @Override
    public int updateDevisePointvente(String idPointventeAModifieDevise, String newlibelleDeviseEN,
                                      String newlibelleDeviseFR, String newabbreviationDeviseEN,
                                      String newabbreviationFR, String newformataffichageDeviseEN,
                                      String newformataffichageDeviseFR)
            throws PointventeNotFoundException, DeviseNotFoundException {

        return 0;
    }


    @Override
    public int isDenominationPvUniqueInEntreprise(String denominationPv, Entreprise entreprise) {
        /*List<Pointvente> listofPvAvecDenomination =
                pointventeRepository.findAllByDenominationPvOrderByDenominationPv(denominationPv);
        System.out.println("listofPvAvecDenomination "+listofPvAvecDenomination.toString());
        for(Pointvente pv : listofPvAvecDenomination){
            if(pv.getEntreprisePv().getIdEntreprise().equalsIgnoreCase(entreprise.getIdEntreprise())){

                return 0;
            }
        }
        return 1;*/
        return pointventeRepository.findAllByDenominationPvAndEntreprisePv(denominationPv,
                entreprise).size()==0?1:0;
    }



    @Override
    public int deletePointvente(String idPointvente) {
        return 0;
    }

    @Override
    public int isLastPointventeInEntreprise(Pointvente pv, Entreprise ent) {
        return 0;
    }

    @Override
    public int isPointventeOfEntreprise(Pointvente pv, Entreprise ent) {
        return 0;
    }

    @Override
    public Pointvente getPointventeById(String idPointvente) {
        Optional<Pointvente> pointventeOptional = pointventeRepository.findPointventeByIdPointvente(idPointvente);
        if(pointventeOptional.isPresent()){
            return pointventeOptional.get();
        }
        return null;
    }

    @Override
    public Pointvente getPointventeByDenominationInEntreprise(String denomination, Entreprise ent) {
        return null;
    }

    @Override
    public int getNombrePointventeEntreprise(Entreprise entreprise) {
        return 0;
    }

    @Override
    public List<Pointvente> getlistofpointvente(int ordre) {
        if(ordre == ConstanteOrdre.DenominationPvCroissant){
            return pointventeRepository.findAllByOrderByDenominationPvAsc();
        }
        if(ordre == ConstanteOrdre.DenominationPvDecroissant){
            return pointventeRepository.findAllByOrderByDenominationPvDesc();
        }
        if(ordre == ConstanteOrdre.PvSigleEntrCroissant){
            return pointventeRepository.findAllByOrderBySigleEntrAsc();
        }
        if(ordre == ConstanteOrdre.PvSigleEntrDecroissant){
            return pointventeRepository.findAllByOrderBySigleEntrDesc();
        }
        return null;
    }

    @Override
    public List<Pointvente> getlistofpointventeofentreprise(String idEntreprise, int ordre){
        if(ordre == ConstanteOrdre.DenominationPvCroissant){
            return pointventeRepository.getListofPointventeEntrepriseOrderByDenominationAsc(idEntreprise);
        }
        if(ordre == ConstanteOrdre.DenominationPvDecroissant){
            return pointventeRepository.getListofPointventeEntrepriseOrderByDenominationDesc(idEntreprise);
        }
        return null;
    }

    @Override
    public Page<Pointvente> getpageofpointventeofentreprise(String idEntreprise, int numPage, int taillePage,
                                                            int ordre){
        if(ordre == ConstanteOrdre.DenominationPvCroissant){
            return pointventeRepository.getPageofPointventeEntrepriseOrderByDenominationAsc(idEntreprise,
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("denominateurPv")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.DenominationPvDecroissant){
            return pointventeRepository.getPageofPointventeEntrepriseOrderByDenominationDesc(idEntreprise,
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("denominateurPv")
                    ))
            );
        }
        return null;
    }

    @Override
    public List<Pointvente> getlistofpointvente(String motcle, int ordre) {
        if(ordre == ConstanteOrdre.DenominationPvCroissant){
            return pointventeRepository.findAllByDenominationPvContainingOrderByDenominationPvAsc(motcle);
        }
        if(ordre == ConstanteOrdre.DenominationPvDecroissant){
            return pointventeRepository.findAllByDenominationPvContainingOrderByDenominationPvDesc(motcle);
        }
        return null;
    }

    @Override
    public List<Pointvente> getlistofpointventeofentreprise(String idEntreprise, String motcle, int ordre){
        if(ordre == ConstanteOrdre.DenominationPvCroissant){
            return pointventeRepository.getListofPointventeEntrepriseOrderByDenominationAsc_Contains(idEntreprise,
                    motcle);
        }
        if(ordre == ConstanteOrdre.DenominationPvDecroissant){
            return pointventeRepository.getListofPointventeEntrepriseOrderByDenominationDesc_Contains(idEntreprise,
                    motcle);
        }
        return null;
    }

    @Override
    public Page<Pointvente> getpageofpointvente(int numPage, int taillePage, int ordre) {
        if(ordre == ConstanteOrdre.DenominationPvCroissant){
            return pointventeRepository.findAllByOrderByDenominationPvAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("denominateurPv")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.DenominationPvDecroissant){
            return pointventeRepository.findAllByOrderByDenominationPvAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("denominationPv")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.PvSigleEntrCroissant){
            return pointventeRepository.findAllByOrderBySigleEntrAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("denominationPv")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.PvSigleEntrDecroissant){
            return pointventeRepository.findAllByOrderBySigleEntrDesc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("denominationPv")
                    ))
            );
        }
        return null;
    }

    @Override
    public Page<Pointvente> getpageofpointvente(String motCle, int numPage, int taillePage, int ordre) {
        return null;
    }

    @Override
    public Typeemballage saveTypeemballage(Typeemballage typeemballage, Pointvente pointvente) {
        return null;
    }

    @Override
    public Typeemballage updateTypeemballage(String idOldTypeemballage, Typeemballage newtypeemballage) {
        return null;
    }

    @Override
    public List<Typeemballage> getListofTypeemballagedePointvente(Pointvente pv, int ordre) {
        return null;
    }

    @Override
    public Page<Typeemballage> getPageofTypeemballagedePointvente(Pointvente pv, int numPage, int taillepage, int ordre) {
        return null;
    }

    @Override
    public int deleteTypeemballage(Typeemballage typeemballage) {
        return 0;
    }

    @Override
    public CompteemballagePv saveCompteemballagePv(Pointvente pointvente, Typeemballage typeemballage) {
        return null;
    }

    @Override
    public int deleteCompteemballagePv(CompteemballagePv compteemballagePV) {
        return 0;
    }

    @Override
    public int getSoldeCompteemballagePv(CompteemballagePv compteemballagePv) {
        return 0;
    }

    @Override
    public int updateSoldeCompteemballagePv(CompteemballagePv compteemballagePv) {
        return 0;
    }

    @Override
    public CompteemballagePv getCompteemballagePv(Pointvente pointvente, Typeemballage typeemballage) {
        return null;
    }

    @Override
    public List<CompteemballagePv> getListofCompteemballagePv(Pointvente pointvente, int ordre) {
        return null;
    }

    @Override
    public Page<CompteemballagePv> getPageofCompteemballagePv(Pointvente pointvente, int numPage, int taillePage, int ordre) {
        return null;
    }

    @Override
    public ComptecapsulePv saveComptecapsulePv(Pointvente pointvente, ProduitFormateUnite produitFormateUnite) {
        return null;
    }

    @Override
    public int deleteComptecapsulePv(ComptecapsulePv comptecapsulePv) {
        return 0;
    }

    @Override
    public int getSoldeComptecapsulePv(ComptecapsulePv comptecapsulePv) {
        return 0;
    }

    @Override
    public int updateSoldeComptecapsulePv(ComptecapsulePv comptecapsulePv) {
        return 0;
    }

    @Override
    public ComptecapsulePv getComptecapsulePv(Pointvente pointvente, ProduitFormateUnite produitFormateUnite) {
        return null;
    }

    @Override
    public List<ComptecapsulePv> getListofComptecapsulePv(Pointvente pointvente, int ordre) {
        return null;
    }

    @Override
    public Page<ComptecapsulePv> getPageofComptecapsulePv(Pointvente pointvente, int numPage, int taillePage,
                                                          int ordre) {
        return null;
    }

    @Override
    public Compteprincipal saveCompteprincipal(Pointvente pointvente) {
        return null;
    }

    @Override
    public int deleteCompteprincipal(Compteprincipal compteprincipal) {
        return 0;
    }

    @Override
    public int getSoldeCompteprincipal(Compteprincipal compteprincipal) {
        return 0;
    }

    @Override
    public int updateSoldeCompteprincipal(Compteprincipal compteprincipal) {
        return 0;
    }

    @Override
    public Compteprincipal getCompteprincipal(Pointvente pointvente) {
        return null;
    }


}

package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.constantes.ConstanteOrdre;
import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.dao.pv.EntrepriseRepository;
import org.c2psi.gpointvente.entities.pv.Entreprise;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.pv.EntrepriseNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.SigleEntrepriseNonUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class EntrepriseServiceImplementation implements EntrepriseService {

    @Autowired
    EntrepriseRepository entrepriseRepository;
    @Autowired
    PointventeService pointventeService;


    @Override
    public Entreprise saveEntreprise(String regimeEntr, String raisonsocialeEntr, String descriptionEntr,
                                     String logoEntr, String deviseEntr, String sigleEntr) {
        Optional<Entreprise> entrExistantAvecSigle =
                entrepriseRepository.findEntrepriseBySigleEntr(sigleEntr);
        if(entrExistantAvecSigle.isPresent()){
            throw new SigleEntrepriseNonUniqueException("Le sigle saisi pour l'entreprise identifie " +
                    "deja une entreprise existante");
        }
        else{
            Entreprise entreprise = new Entreprise();

            entreprise.setSigleEntr(sigleEntr);
            entreprise.setDescriptionEntr(descriptionEntr);
            entreprise.setDeviseEntr(deviseEntr);
            entreprise.setLogoEntr(logoEntr);
            entreprise.setRaisonsocialeEntr(raisonsocialeEntr);
            entreprise.setRegimeEntr(regimeEntr);
            entreprise.setListofPointvente(new ArrayList<Pointvente>());

            Entreprise entrepriseEnregistre = entrepriseRepository.save(entreprise);
            return entrepriseEnregistre;
            /*Entreprise entrepriseEnregistre = entrepriseRepository.save(entreprise);
            entrepriseEnregistre.setIdEntreprise(entrepriseEnregistre.getId().toHexString());*/

        }
    }

    @Override
    public Entreprise updateEntreprise(String idoldEntreprise, String newregimeEntr,
                                       String newraisonsocialeEntr, String newdescriptionEntr,
                                       String  newlogoEntr, String newdeviseEntr, String newsigleEntr) {
        Optional<Entreprise> entrepriseAModifie =
                entrepriseRepository.findEntrepriseByIdEntreprise(idoldEntreprise);
        if(entrepriseAModifie.isPresent()){
            /*
            On a trouve l'entreprise a modifier et on va vérifier que
            le sigle sera unique apres modification
             */
            if(entrepriseAModifie.get().getSigleEntr().equalsIgnoreCase(newsigleEntr)){
                /*
                Ici cela signifie que le sigle de l'entreprise ne sera pas modifie pendant la mise a jour
                 */
                Entreprise oldEntreprise = entrepriseAModifie.get();
                oldEntreprise.setDeviseEntr(newdeviseEntr);
                oldEntreprise.setLogoEntr(newlogoEntr);
                oldEntreprise.setDescriptionEntr(newdescriptionEntr);
                oldEntreprise.setRaisonsocialeEntr(newraisonsocialeEntr);
                oldEntreprise.setRegimeEntr(newregimeEntr);
                Entreprise entrepriseModifie = entrepriseRepository.save(oldEntreprise);
                return entrepriseModifie;
            }
            else{
                /*
                Si l'exécution se retrouve a ce niveau, cela signifie qu'on est dans un cas ou, on veut aussi
                modifier le sigle de l'entreprise et pour cela on doit se  rassurer que le nouveau sigle ne va pas
                creer des conflits au niveau de la contrainte d'unicite du sigle de l'entreprise.
                 */
                Optional<Entreprise> entrepriseExistWithSigle =
                        entrepriseRepository.findEntrepriseBySigleEntr(newsigleEntr);
                if(entrepriseExistWithSigle.isPresent()){
                    throw new SigleEntrepriseNonUniqueException("le nouveau sigle saisi correspond à une " +
                            "entreprise déjà existante");
                }
                else{
                    Entreprise oldEntreprise = entrepriseAModifie.get();
                    oldEntreprise.setSigleEntr(newsigleEntr);
                    oldEntreprise.setDeviseEntr(newdeviseEntr);
                    oldEntreprise.setLogoEntr(newlogoEntr);
                    oldEntreprise.setDescriptionEntr(newdescriptionEntr);
                    oldEntreprise.setRaisonsocialeEntr(newraisonsocialeEntr);
                    oldEntreprise.setRegimeEntr(newregimeEntr);
                    Entreprise entrepriseModifie = entrepriseRepository.save(oldEntreprise);
                    return entrepriseModifie;
                }
            }
        }
        else{
            throw new EntrepriseNotFoundException("Aucune entreprise n'existe avec l'id "+
                    idoldEntreprise+" passe en parametre");
        }
    }

    @Override
    public int deleteEntreprise(String idEntreprise) {
        Optional<Entreprise> entrepriseASupprimer =
                entrepriseRepository.findEntrepriseByIdEntreprise(idEntreprise);
        if(entrepriseASupprimer.isPresent()){
            entrepriseRepository.delete(entrepriseASupprimer.get());
            return 1;
        }
        return 0;
    }

    @Override
    public Entreprise getEntrepriseById(String idEntreprise) throws EntrepriseNotFoundException {
        Optional<Entreprise> entrepriseRechercher =
                entrepriseRepository.findEntrepriseByIdEntreprise(idEntreprise);
        if(entrepriseRechercher.isPresent()){
            return entrepriseRechercher.get();
        }
        throw new EntrepriseNotFoundException("Aucune entreprise n'existe avec l'identifiant " +
                "passe en parametre");
    }

    @Override
    public Entreprise getEntrepriseBySigle(String sigleEntreprise) throws EntrepriseNotFoundException {
        Optional<Entreprise> entrepriseRechercher =
                entrepriseRepository.findEntrepriseBySigleEntr(sigleEntreprise);
        if(entrepriseRechercher.isPresent()){
            return entrepriseRechercher.get();
        }
        throw new EntrepriseNotFoundException("Aucune entreprise n'existe avec le sigle " +
                "passe en parametre");
    }

    @Override
    public List<Pointvente> getListofPointvente(String idEntreprise, int ordre) {
        if(ordre == ConstanteOrdre.DenominationPvCroissant){
            return entrepriseRepository.getListofPointventeEntrepriseOrderByDenominationAsc(idEntreprise);
        }
        if(ordre == ConstanteOrdre.DenominationPvDecroissant){
            return entrepriseRepository.getListofPointventeEntrepriseOrderByDenominationDesc(idEntreprise);
        }
        return null;
    }

    @Override
    public Page<Pointvente> getPageofPointvente(String idEntreprise, int numPage, int taillePage, int ordre) {
        if(ordre == ConstanteOrdre.DenominationPvCroissant){
            return entrepriseRepository.getPageofPointventeEntrepriseOrderByDenominationAsc(idEntreprise,
                    PageRequest.of(numPage, taillePage));
        }
        if(ordre == ConstanteOrdre.DenominationPvDecroissant){
            return entrepriseRepository.getPageofPointventeEntrepriseOrderByDenominationDesc(idEntreprise,
                    PageRequest.of(numPage, taillePage));
        }
        return null;
    }

    @Override
    public List<Entreprise> getListofEntreprise(int ordre) {
        if(ordre == ConstanteOrdre.RaisonsocialeEntrCroissant){
            List<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderByRaisonsocialeEntrAscSigleEntrAscDeviseEntrAsc();

            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.RaisonsocialeEntrDecroissant){
            List<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderByRaisonsocialeEntrDescSigleEntrAscDeviseEntrAsc();

            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.SigleEntrCroissant){
            List<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderBySigleEntrAscRaisonsocialeEntrAscDeviseEntrAsc();

            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.SigleEntrDecroissant){
            List<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderBySigleEntrDescRaisonsocialeEntrAscDeviseEntrAsc();

            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.NbrePointventeCroissant){
            List<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderByRaisonsocialeEntrDescSigleEntrAscDeviseEntrAsc();
            Comparator<Entreprise> entrepriseComparator = new Comparator<Entreprise>() {
                @Override
                public int compare(Entreprise o1, Entreprise o2) {
                    if(o1.getListofPointvente().size() < o2.getListofPointvente().size()) return -1;
                    if(o1.getListofPointvente().size() > o2.getListofPointvente().size()) return 1;
                    return 0;
                }
            };
            Collections.sort(listofEntreprise, entrepriseComparator);
            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.NbrePointventeDecroissant){
            List<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderByRaisonsocialeEntrDescSigleEntrAscDeviseEntrAsc();
            Comparator<Entreprise> entrepriseComparator = new Comparator<Entreprise>() {
                @Override
                public int compare(Entreprise o1, Entreprise o2) {
                    if(o1.getListofPointvente().size() < o2.getListofPointvente().size()) return 1;
                    if(o1.getListofPointvente().size() > o2.getListofPointvente().size()) return -1;
                    return 0;
                }
            };
            Collections.sort(listofEntreprise, entrepriseComparator);
            return listofEntreprise;
        }
        return null;
    }

    @Override
    public Page<Entreprise> getPageofEntreprise(int numPage, int taillePage, int ordre) {
        if(ordre == ConstanteOrdre.RaisonsocialeEntrCroissant){
            Page<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderByRaisonsocialeEntrAscSigleEntrAscDeviseEntrAsc(
                            PageRequest.of(numPage, taillePage, Sort.by(
                                    Sort.Order.asc("raisonsocialeEntr"),
                                    Sort.Order.asc("sigleEntr")
                            ))
                    );

            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.RaisonsocialeEntrDecroissant){
            Page<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderByRaisonsocialeEntrDescSigleEntrAscDeviseEntrAsc(
                            PageRequest.of(numPage, taillePage, Sort.by(
                                    Sort.Order.desc("raisonsocialeEntr"),
                                    Sort.Order.asc("sigleEntr")
                            ))
                    );

            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.SigleEntrCroissant){
            Page<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderBySigleEntrAscRaisonsocialeEntrAscDeviseEntrAsc(
                            PageRequest.of(numPage, taillePage, Sort.by(
                                    Sort.Order.asc("sigleEntr"),
                                    Sort.Order.asc("raisonsocialeEntr")
                            ))
                    );

            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.SigleEntrDecroissant){
            Page<Entreprise> listofEntreprise =
                    entrepriseRepository.findAllByOrderBySigleEntrDescRaisonsocialeEntrAscDeviseEntrAsc(
                            PageRequest.of(numPage, taillePage, Sort.by(
                                    Sort.Order.desc("sigleEntr"),
                                    Sort.Order.asc("raisonsocialeEntr")
                            ))
                    );

            return listofEntreprise;
        }
        if(ordre == ConstanteOrdre.NbrePointventeCroissant){
            Page<Entreprise> pageofEntreprise = entrepriseRepository.findAllByOrderByNbrePointventeAscSigleEntrAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("nbrePointvente"),
                            Sort.Order.asc("sigleEntr")
                    ))
            );
            return pageofEntreprise;
        }
        if(ordre == ConstanteOrdre.NbrePointventeDecroissant){
            Page<Entreprise> pageofEntreprise = entrepriseRepository.findAllByOrderByNbrePointventeDescSigleEntrAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("nbrePointvente"),
                            Sort.Order.asc("sigleEntr")
                    ))
            );
            return pageofEntreprise;
        }
        return null;
    }

    @Override
    public int addPointventeToEntreprise(Pointvente pointvente, Entreprise entreprise) {
        entreprise.getListofPointvente().add(pointvente);
        entrepriseRepository.save(entreprise);
        return 1;
    }

    @Override
    public int isPointventeOfEntreprise(Pointvente pointvente, Entreprise entreprise) {
        System.out.println("la liste des pv est == "+entreprise.getListofPointvente().size());
        for(Pointvente pv : entreprise.getListofPointvente()){

            if(pv.getIdPointvente().equals(pointvente.getIdPointvente())){
                System.out.println(pv);
                return 1;
            }
        }
        System.out.println("rien n'a ete trouve");
        return 0;
    }

    @Override
    public int isSigleEntrUnique(String sigleEntr) {
        Optional<Entreprise> entrExistantAvecSigle = entrepriseRepository.findEntrepriseBySigleEntr(sigleEntr);
        if(entrExistantAvecSigle.isPresent()){
            return ValeurRetour.sigleEntrExist;
        }
        return ValeurRetour.sigleEntrNotExist;
    }

}

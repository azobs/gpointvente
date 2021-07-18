package org.c2psi.gpointvente.services.prix;

import org.c2psi.gpointvente.constantes.ConstanteOrdre;
import org.c2psi.gpointvente.dao.prix.DeviseRepository;
import org.c2psi.gpointvente.dao.prix.RegleconversionDeviseRepository;
import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.prix.RegleconversionDevise;
import org.c2psi.gpointvente.exceptions.prix.DeviseNotFoundException;
import org.c2psi.gpointvente.exceptions.prix.RegleconversionDeviseMalFormedException;
import org.c2psi.gpointvente.services.pv.PointventeService;
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
public class DeviseServiceImplementation implements DeviseService {
    @Autowired
    DeviseRepository deviseRepository;
    @Autowired
    RegleconversionDeviseRepository regleconversionDeviseRepository;
    @Autowired
    PointventeService pointventeService;

    @Override
    public int addDeviseToPointvente(Devise devise, Pointvente pointvente){
        pointvente.getListofDevisePv().add(devise);
        pointventeService.savePointvente(pointvente);
        return 1;
    }

    @Override
    public Devise saveDevise(String libelleDeviseEN, String libelleDeviseFR, String abbreviationDeviseEN,
                             String abbreviationDeviseFR, String formataffichageDevise,
                              boolean isDevisepardefaut, Pointvente pointvente){


        Devise devise = new Devise();
        devise.setAbbreviationDeviseEN(abbreviationDeviseEN);
        devise.setAbbreviationDeviseFR(abbreviationDeviseFR);
        devise.setFormataffichageDevise(formataffichageDevise);
        devise.setLibelleDeviseEN(libelleDeviseEN);
        devise.setLibelleDeviseFR(libelleDeviseFR);
        devise.setPointvente(pointvente);

        if(isDevisepardefaut){
            /*
             Donc la devise qu'on enregistre sera la devise par defaut
            */
            for(Devise dev : pointvente.getListofDevisePv()){
                dev.setDeviseParDefaut(false);
                deviseRepository.save(dev);
            }
            devise.setDeviseParDefaut(true);
        }
        else{
            /*
            Elle ne sera pas la devise par defaut mais si c'est la première devise du point de vente alors
            elle sera automatiquement la devise par defaut. Ce parametre est donc inutile dans ce cas.
            */
            if(pointvente.getListofDevisePv().size()==0){
                    /*
                    Alors c'est la première devise qu'on enregistre pour le point de vente et elle est automatiquement
                    la devise par defaut
                     */
                devise.setDeviseParDefaut(true);
            }
        }
        /*
         Il faut enregistrer la devise puis l'ajouter a la liste des devises du point de vente.
         Si on l'a defini comme devise par defaut, il faut donc recuperer d'abord celle qui est deja
         par defaut et la supprimer coe devise par defaut puis definir la nouvelle.
         */
        Devise deviseEnregistrer = deviseRepository.save(devise);
        return deviseEnregistrer;
    }

    @Override
    public Devise updateDevise(String idOldDevise, String newlibelleDeviseEN, String newlibelleDeviseFR,
                               String newabbreviationDeviseEN, String newabbreviationDeviseFR,
                               String newformataffichageDevise) throws DeviseNotFoundException {

        Optional<Devise> deviseAModifier = deviseRepository.findDeviseByIdDevise(idOldDevise);
        if(deviseAModifier.isPresent()){
            Devise devise = deviseAModifier.get();
            devise.setLibelleDeviseEN(newlibelleDeviseEN);
            devise.setLibelleDeviseFR(newlibelleDeviseFR);
            devise.setAbbreviationDeviseEN(newabbreviationDeviseEN);
            devise.setAbbreviationDeviseFR(newabbreviationDeviseFR);
            devise.setFormataffichageDevise(newformataffichageDevise);
            return deviseRepository.save(devise);
        }
        else{
            throw new DeviseNotFoundException("Exception lancee: " +
                    "L'identifiant envoyé ne correspond a aucune devise");
        }
    }

    @Override
    public Devise updateDevise(String idOlddevise, Devise newDevise) throws DeviseNotFoundException {
        return updateDevise(idOlddevise, newDevise.getLibelleDeviseEN(), newDevise.getLibelleDeviseFR(),
                    newDevise.getAbbreviationDeviseEN(), newDevise.getAbbreviationDeviseFR(),
                    newDevise.getFormataffichageDevise());
    }

    @Override
    public int setToDefaultDevise(String idOldDevise) throws DeviseNotFoundException{
        Optional<Devise> deviseAModifier = deviseRepository.findDeviseByIdDevise(idOldDevise);
        System.out.println("La devise qu'on cherche a pour id "+idOldDevise);
        if(deviseAModifier.isPresent()){
            System.out.println("La devise a été trouvee ");
            Devise devise = deviseAModifier.get();
            Pointvente pointvente = devise.getPointvente();
            for(Devise dev : pointvente.getListofDevisePv()){
                dev.setDeviseParDefaut(false);
                deviseRepository.save(dev);
            }
            devise.setDeviseParDefaut(true);
            deviseRepository.save(devise);
            return 1;
        }
        else{
            System.out.println("La devise ayant pour id "+idOldDevise+" n'a pas ete trouve");
            throw new DeviseNotFoundException("La devise qu'on veut modifier est inextante");
        }
    }

    @Override
    public RegleconversionDevise saveRegleconversionDevise(Devise devisemultiple, Devise devisesousmultiple,
                                                    Double facteurconversion)
            throws RegleconversionDeviseMalFormedException{
        if(devisemultiple.getPointvente().getIdPointvente().equalsIgnoreCase(
                devisesousmultiple.getPointvente().getIdPointvente())){
            System.out.println("les 02 premiers tests ont ete effectue et ce sont les devises du meme " +
                    "point de vente");
            /*
            Si on est ici alors les deux devises sont celle du même point de vente et c'est correct
            pour le moment. Il reste maintenant à verifier qu'aucune regle ne lie deja ces 2 devises
            findAllByDevisemultipleAndDevisesousmultiple
            */
            /*Optional<RegleconversionDevise> optionalRegleconversionDevise1 =
                    regleconversionDeviseRepository.
                            getRegleconversionDeviseByDevisemultipleIdDeviseAndDevisesousmultipleIdDevise(
                                    devisemultiple.getIdDevise(), devisesousmultiple.getIdDevise());*/
            Optional<RegleconversionDevise> optionalRegleconversionDevise1 =
                    regleconversionDeviseRepository.findAllByDevisemultipleAndDevisesousmultiple(devisemultiple,
                            devisesousmultiple);
            System.out.println("le premier appel a getRegleconversionDeviseByDevisemultipleAndDevisesousmultiple" +
                    " marche bien");
            /*Optional<RegleconversionDevise> optionalRegleconversionDevise2 =
                    regleconversionDeviseRepository.
                            getRegleconversionDeviseByDevisemultipleIdDeviseAndDevisesousmultipleIdDevise(
                                    devisesousmultiple.getIdDevise(), devisemultiple.getIdDevise());*/
            Optional<RegleconversionDevise> optionalRegleconversionDevise2 =
                    regleconversionDeviseRepository.findAllByDevisemultipleAndDevisesousmultiple(devisesousmultiple,
                            devisemultiple);
            System.out.println("les 02 appels suivants ont ete effectue");
            if(optionalRegleconversionDevise2.isPresent()){
                System.out.println("Il existe deja une regle de conversion liant les 02 devises en BD " +
                        "mais dans laquelle la devise multiple precisee maintenant y figure comme " +
                        "devise sous multiple DONC la permutation sera effectue avec le nouveau " +
                        "facteur de conversion");
                RegleconversionDevise regleconversionDeviseAModifier = optionalRegleconversionDevise2.get();
                regleconversionDeviseAModifier.setDevisemultiple(devisemultiple);
                regleconversionDeviseAModifier.setDevisesousmultiple(devisesousmultiple);
                regleconversionDeviseAModifier.setFacteurconversionDevise(facteurconversion);
                return regleconversionDeviseRepository.save(regleconversionDeviseAModifier);
            }
            else if(optionalRegleconversionDevise1.isPresent()){
                System.out.println("On a trouver une regle liant les 02 devises et constitue de la meme " +
                        "maniere ie meme devisemultiple et meme devisesousmultiple DONC on va juste " +
                        "modifier le facteur de conversion");
                RegleconversionDevise regleconversionDeviseAModifier = optionalRegleconversionDevise1.get();
                regleconversionDeviseAModifier.setFacteurconversionDevise(facteurconversion);
                return regleconversionDeviseRepository.save(regleconversionDeviseAModifier);
            }
            else{
                System.out.println("Aucune regle liant les 02 devise n'existe dans la base de données");
                RegleconversionDevise regleconversionDevise = new RegleconversionDevise();
                regleconversionDevise.setDevisemultiple(devisemultiple);
                regleconversionDevise.setDevisesousmultiple(devisesousmultiple);
                regleconversionDevise.setFacteurconversionDevise(facteurconversion);
                return regleconversionDeviseRepository.save(regleconversionDevise);
            }
        }
        else{
            throw new RegleconversionDeviseMalFormedException("Exception lancee: " +
                    "Les 02 devises mis en jeu n'appartiennent " +
                    "pas au même point de vente");
        }
    }

    @Override
    public Optional<Devise> getDeviseByIdDevise(String idDevise){
        return deviseRepository.findDeviseByIdDevise(idDevise);
    }

    @Override
    public RegleconversionDevise saveRegleconversionDevise(String idDevisemultiple, String idDevisesousmultiple,
                                                           Double facteurconversion)
            throws RegleconversionDeviseMalFormedException, DeviseNotFoundException {

        Optional<Devise> optionalDeviseMultiple = deviseRepository.findDeviseByIdDevise(idDevisemultiple);
        Optional<Devise> optionalDeviseSousmultiple = deviseRepository.findDeviseByIdDevise(idDevisesousmultiple);
        System.out.println("les 02 premiers appels ont ete effectue");
        if(optionalDeviseMultiple.isPresent() && optionalDeviseSousmultiple.isPresent()){
            if(optionalDeviseMultiple.get().getPointvente().getIdPointvente().equalsIgnoreCase(
                    optionalDeviseSousmultiple.get().getPointvente().getIdPointvente())){
                System.out.println("les 02 premiers tests ont ete effectue et ce sont les devises du meme " +
                        "point de vente");
                /*
                Si on est ici alors les deux devises sont celle du même point de vente et c'est correct
                pour le moment. Il reste maintenant à verifier qu'aucune regle ne lie deja ces 2 devises
                 */
                Optional<RegleconversionDevise> optionalRegleconversionDevise1 =
                        regleconversionDeviseRepository.getRegleconversionDeviseByDevisemultipleIdDeviseAndDevisesousmultipleIdDevise(idDevisemultiple, idDevisesousmultiple);
                System.out.println("le premier appel a getRegleconversionDeviseByDevisemultipleAndDevisesousmultiple" +
                        " marche bien");
                Optional<RegleconversionDevise> optionalRegleconversionDevise2 =
                        regleconversionDeviseRepository.getRegleconversionDeviseByDevisemultipleIdDeviseAndDevisesousmultipleIdDevise(idDevisesousmultiple, idDevisemultiple);
                System.out.println("les 02 appels suivants ont ete effectue");
                if(optionalRegleconversionDevise2.isPresent()){
                    System.out.println("Il existe deja une regle de conversion liant les 02 devises en BD " +
                            "mais dans laquelle la devise multiple precisee maintenant y figure comme " +
                            "devise sous multiple DONC la permutation sera effectue avec le nouveau " +
                            "facteur de conversion");
                    RegleconversionDevise regleconversionDeviseAModifier = optionalRegleconversionDevise2.get();
                    regleconversionDeviseAModifier.setDevisemultiple(optionalDeviseMultiple.get());
                    regleconversionDeviseAModifier.setDevisesousmultiple(optionalDeviseSousmultiple.get());
                    regleconversionDeviseAModifier.setFacteurconversionDevise(facteurconversion);
                    return regleconversionDeviseRepository.save(regleconversionDeviseAModifier);
                }
                else if(optionalRegleconversionDevise1.isPresent()){
                    System.out.println("On a trouver une regle liant les 02 devises et constitue de la meme " +
                            "maniere ie meme devisemultiple et meme devisesousmultiple DONC on va juste " +
                            "modifier le facteur de conversion");
                    RegleconversionDevise regleconversionDeviseAModifier = optionalRegleconversionDevise1.get();
                    regleconversionDeviseAModifier.setFacteurconversionDevise(facteurconversion);
                    return regleconversionDeviseRepository.save(regleconversionDeviseAModifier);
                }
                else{
                    System.out.println("Aucune regle liant les 02 devise n'existe dans la base de données");
                    RegleconversionDevise regleconversionDevise = new RegleconversionDevise();
                    regleconversionDevise.setDevisemultiple(optionalDeviseMultiple.get());
                    regleconversionDevise.setDevisesousmultiple(optionalDeviseSousmultiple.get());
                    regleconversionDevise.setFacteurconversionDevise(facteurconversion);
                    return regleconversionDeviseRepository.save(regleconversionDevise);
                }
            }
            else{
                throw new RegleconversionDeviseMalFormedException("Exception lancee: " +
                        "Les 02 devises mis en jeu n'appartiennent " +
                        "pas au même point de vente");
            }
        }
        else{
            throw new DeviseNotFoundException("Exception lancee: " +
                    "Un des identifiants saisis ne correspond " +
                    "à aucune devise dans la base de données");
        }
    }

    @Override
    public int deleteDevise(String idDevise) {
        return 0;
    }

    @Override
    public List<Devise> getListofDevise(int ordre) {
        if(ordre == ConstanteOrdre.AbbreviationDeviseENCroissant){
            return deviseRepository.findAllByOrderByAbbreviationDeviseENAsc();
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseENDecroissant){
            return deviseRepository.findAllByOrderByAbbreviationDeviseENDesc();
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseFRCroissant){
            return deviseRepository.findAllByOrderByAbbreviationDeviseFRAsc();
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseFRDecroissant){
            return deviseRepository.findAllByOrderByAbbreviationDeviseFRDesc();
        }
        //
        if(ordre == ConstanteOrdre.LibelleDeviseENCroissant){
            return deviseRepository.findAllByOrderByLibelleDeviseENAsc();
        }
        if(ordre == ConstanteOrdre.LibelleDeviseENDecroissant){
            return deviseRepository.findAllByOrderByLibelleDeviseENDesc();
        }
        if(ordre == ConstanteOrdre.LibelleDeviseFRCroissant){
            return deviseRepository.findAllByOrderByLibelleDeviseFRAsc();
        }
        if(ordre == ConstanteOrdre.LibelleDeviseFRDecroissant){
            return deviseRepository.findAllByOrderByLibelleDeviseFRDesc();
        }
        System.out.println("ordre non prevu "+ordre);
        return null;
    }

    @Override
    public List<Devise> getListofDevisePointvente(String idPointvente, int ordre) {
        if(ordre == ConstanteOrdre.AbbreviationDeviseENCroissant){
            return deviseRepository.getListofDevisePointventeOrderByAbbreviationDeviseENAsc(idPointvente);
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseENDecroissant){
            return deviseRepository.getListofDevisePointventeOrderByAbbreviationDeviseENDesc(idPointvente);
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseFRCroissant){
            return deviseRepository.getListofDevisePointventeOrderByAbbreviationDeviseFRAsc(idPointvente);
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseFRDecroissant){
            return deviseRepository.getListofDevisePointventeOrderByAbbreviationDeviseFRDesc(idPointvente);
        }
        //
        if(ordre == ConstanteOrdre.LibelleDeviseENCroissant){
            return deviseRepository.getListofDevisePointventeOrderByLibelleDeviseENAsc(idPointvente);
        }
        if(ordre == ConstanteOrdre.LibelleDeviseENDecroissant){
            return deviseRepository.getListofDevisePointventeOrderByLibelleDeviseENDesc(idPointvente);
        }
        if(ordre == ConstanteOrdre.LibelleDeviseFRCroissant){
            return deviseRepository.getListofDevisePointventeOrderByLibelleDeviseFRAsc(idPointvente);
        }
        if(ordre == ConstanteOrdre.LibelleDeviseFRDecroissant){
            return deviseRepository.getListofDevisePointventeOrderByLibelleDeviseFRDesc(idPointvente);
        }
        System.out.println("ordre non prevu "+ordre);
        return null;
    }

    @Override
    public List<Devise> getListofDevise(String motCle, int ordre) {
        return null;
    }

    @Override
    public Page<Devise> getPageofDevise(int numPage, int taillePage, int ordre) {
        if(ordre == ConstanteOrdre.AbbreviationDeviseENCroissant){
                return deviseRepository.findAllByOrderByAbbreviationDeviseENAsc(
                        PageRequest.of(numPage, taillePage, Sort.by(
                        Sort.Order.asc("abbreviationDeviseEN")
                ))
            );
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseENDecroissant){
            return deviseRepository.findAllByOrderByAbbreviationDeviseENDesc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("abbreviationDeviseEN")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseFRCroissant){
            return deviseRepository.findAllByOrderByAbbreviationDeviseFRAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("abbreviationDeviseFR")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseFRDecroissant){
            return deviseRepository.findAllByOrderByAbbreviationDeviseFRDesc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("abbreviationDeviseFR")
                    ))
            );
        }
        //
        if(ordre == ConstanteOrdre.LibelleDeviseENCroissant){
            return deviseRepository.findAllByOrderByLibelleDeviseENAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("libelleDeviseEN")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.LibelleDeviseENDecroissant){
            return deviseRepository.findAllByOrderByLibelleDeviseENDesc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("libelleDeviseEN")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.LibelleDeviseFRCroissant){
            return deviseRepository.findAllByOrderByLibelleDeviseFRAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("libelleDeviseFR")
                    ))
            );
        }
        if(ordre == ConstanteOrdre.LibelleDeviseFRDecroissant){
            return deviseRepository.findAllByOrderByLibelleDeviseFRDesc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("libelleDeviseFR")
                    ))
            );
        }
        System.out.println("ordre non prevu "+ordre);
        return null;
    }

    @Override
    public Page<Devise> getPageofDevisePointvente(String idPointvente, int numPage, int taillePage, int ordre) {
        if(ordre == ConstanteOrdre.AbbreviationDeviseENCroissant){
            return deviseRepository.getListofDevisePointventeOrderByAbbreviationDeviseENAsc(idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(Sort.Order.asc("abbreviationDeviseEN")))
                    );
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseENDecroissant){
            return deviseRepository.getListofDevisePointventeOrderByAbbreviationDeviseENDesc(idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(Sort.Order.desc("abbreviationDeviseEN")))
            );
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseFRCroissant){
            return deviseRepository.getListofDevisePointventeOrderByAbbreviationDeviseFRAsc(idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(Sort.Order.asc("abbreviationDeviseFR")))
            );
        }
        if(ordre == ConstanteOrdre.AbbreviationDeviseFRDecroissant){
            return deviseRepository.getListofDevisePointventeOrderByAbbreviationDeviseFRDesc(idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(Sort.Order.desc("abbreviationDeviseFR")))
            );
        }
        ////
        if(ordre == ConstanteOrdre.LibelleDeviseENCroissant){
            return deviseRepository.getListofDevisePointventeOrderByLibelleDeviseENAsc(idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(Sort.Order.asc("libelleDeviseEN")))
            );
        }
        if(ordre == ConstanteOrdre.LibelleDeviseENDecroissant){
            return deviseRepository.getListofDevisePointventeOrderByLibelleDeviseENDesc(idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(Sort.Order.desc("libelleDeviseEN")))
            );
        }
        if(ordre == ConstanteOrdre.LibelleDeviseFRCroissant){
            return deviseRepository.getListofDevisePointventeOrderByLibelleDeviseFRAsc(idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(Sort.Order.asc("libelleDeviseFR")))
            );
        }
        if(ordre == ConstanteOrdre.LibelleDeviseFRDecroissant){
            return deviseRepository.getListofDevisePointventeOrderByLibelleDeviseFRDesc(idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(Sort.Order.desc("libelleDeviseFR")))
            );
        }
        System.out.println("ordre non prevu "+ordre);
        return null;
    }

    @Override
    public Page<Devise> getPageofDevise(String motCle, int numPage, int taillePage, int ordre) {
        return null;
    }


}


package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.dao.produit.RegleconversionUniteRepository;
import org.c2psi.gpointvente.dao.produit.UniteproduitRepository;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.produit.RegleconversionUnite;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.c2psi.gpointvente.exceptions.produit.RegleconversionUniteMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.UniteproduitNonUniqueException;
import org.c2psi.gpointvente.exceptions.produit.UniteproduitNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UniteproduitServiceImplementation implements UniteproduitService {
    @Autowired
    UniteproduitRepository uniteproduitRepository;
    @Autowired
    RegleconversionUniteRepository regleconversionUniteRepository;

    @Override
    public int isUniteproduitENUniqueInPointvente(String abbreviationUniteEN, String libelleUniteEN,
                                                  Pointvente pointvente) {
        List<Uniteproduit> listofUniteproduit =
           uniteproduitRepository.findAllByAbbreviationUniteENAndLibelleUniteENAndPointventeOrderByAbbreviationUniteEN(
                        abbreviationUniteEN, libelleUniteEN, pointvente);

        return listofUniteproduit.size()==0?1:0;
    }

    @Override
    public int isUniteproduitFRUniqueInPointvente(String abbreviationUniteFR, String libelleUniteFR, Pointvente pointvente) {
        List<Uniteproduit> listofUniteproduit =
                uniteproduitRepository.findAllByAbbreviationUniteFRAndLibelleUniteFRAndPointventeOrderByAbbreviationUniteFR(
                        abbreviationUniteFR, libelleUniteFR, pointvente);

        return listofUniteproduit.size()==0?1:0;
    }

    @Override
    public Uniteproduit getUniteproduitByIdUnite(String idUniteproduit) {
        Optional<Uniteproduit> optionalUniteproduit = uniteproduitRepository.findUniteproduitByIdUnite(idUniteproduit);
        return optionalUniteproduit.isPresent()?optionalUniteproduit.get():null;
    }

    @Override
    public Uniteproduit getUniteproduitByIdUniteInPointvente(String idUniteproduit, Pointvente pointvente) {
        List<Uniteproduit> listofUniteproduit = uniteproduitRepository.findAllByIdUniteAndPointvente(idUniteproduit, pointvente);
        if(listofUniteproduit.size() == 1){
            return listofUniteproduit.get(0);
        }
        return null;
    }

    @Override
    public Uniteproduit saveUniteproduit(String libelleUniteFR, String abbreviationUniteFR, String libelleUniteEN,
                                          String abbreviationUniteEN, Pointvente pointvente)
            throws UniteproduitNonUniqueException {
        if(isUniteproduitENUniqueInPointvente(abbreviationUniteEN, libelleUniteEN, pointvente)==0){
            throw new UniteproduitNonUniqueException("Exception levee: 02 unites de produit ne peuvent avoir le meme" +
                    "abbreviation et libelle en anglais dans un point de vente");
        }
        if(isUniteproduitFRUniqueInPointvente(abbreviationUniteFR, libelleUniteFR, pointvente)==0){
            throw new UniteproduitNonUniqueException("Exception levee: 02 unites de produit ne peuvent avoir le meme" +
                    "abbreviation et libelle en francais dans un point de vente");
        }
        Uniteproduit uniteproduitAEnreg = new Uniteproduit();
        uniteproduitAEnreg.setAbbreviationUniteEN(abbreviationUniteEN);
        uniteproduitAEnreg.setAbbreviationUniteFR(abbreviationUniteFR);
        uniteproduitAEnreg.setLibelleUniteEN(libelleUniteEN);
        uniteproduitAEnreg.setLibelleUniteFR(libelleUniteFR);
        uniteproduitAEnreg.setPointvente(pointvente);
        Uniteproduit uniteproduit = uniteproduitRepository.save(uniteproduitAEnreg);

        return uniteproduit;
    }

    @Override
    public List<RegleconversionUnite> findListofRegleAssociantUnite(Uniteproduit uniteproduitMultiple,
                                                                    Uniteproduit uniteproduitSousmultiple) {
        return regleconversionUniteRepository.findAllByUnitemultipleAndUnitesousmultiple(
                uniteproduitMultiple, uniteproduitSousmultiple);
    }

    @Override
    public Uniteproduit saveUniteproduit(Uniteproduit uniteproduit) {
        return uniteproduitRepository.save(uniteproduit);
    }

    @Override
    public RegleconversionUnite saveRegleconversionUnite(Uniteproduit uniteproduitMultiple,
                                                         Uniteproduit uniteproduitSousmultiple,
                                                         int facteurconversion)
            throws RegleconversionUniteMalFormedException, UniteproduitNotFoundException {
        if(uniteproduitMultiple.getPointvente().getIdPointvente().equalsIgnoreCase(
                uniteproduitSousmultiple.getPointvente().getIdPointvente())){
            List<RegleconversionUnite> listofRegleconversionUnite1 = regleconversionUniteRepository.
                    findAllByUnitemultipleAndUnitesousmultiple(uniteproduitMultiple, uniteproduitSousmultiple);
            if(listofRegleconversionUnite1.size()==1){
                RegleconversionUnite regleconversionUnite = listofRegleconversionUnite1.get(0);
                /*
                On a trouver qu'une regle existait deja liant les deux unites en question. Donc
                on va simplement modifier le facteur de conversion et enregistrer
                 */
                regleconversionUnite.setFacteurconversion(facteurconversion);
                return regleconversionUniteRepository.save(regleconversionUnite);
            }
            List<RegleconversionUnite> listofRegleconversionUnite2 = regleconversionUniteRepository.
                    findAllByUnitemultipleAndUnitesousmultiple(uniteproduitSousmultiple, uniteproduitMultiple);
            if(listofRegleconversionUnite2.size()==1){
                /*
                On a trouver une regle de conversion liant les deux unites mais dans laquelle l'unite multiple
                preciser ici est plutot en sous multiple et vice versa. Donc ce qu'on peut faire c'est
                simplement de faire la permutation avec le nouveau facteur de conversion
                 */
                RegleconversionUnite regleconversionUnite = listofRegleconversionUnite2.get(0);
                regleconversionUnite.setUnitemultiple(uniteproduitMultiple);
                regleconversionUnite.setUnitesousmultiple(uniteproduitSousmultiple);
                regleconversionUnite.setFacteurconversion(facteurconversion);
                return regleconversionUniteRepository.save(regleconversionUnite);
            }
            System.out.println("Aucune regle n'existe liant les deux unites dans la base de donnée");
            RegleconversionUnite regleconversionUnite = new RegleconversionUnite();
            regleconversionUnite.setFacteurconversion(facteurconversion);
            regleconversionUnite.setUnitemultiple(uniteproduitMultiple);
            regleconversionUnite.setUnitesousmultiple(uniteproduitSousmultiple);
            return regleconversionUniteRepository.save(regleconversionUnite);
        }
        else{
            throw new RegleconversionUniteMalFormedException("Exception levee: Les 02 unites pour lesquelle " +
                    "la regle veut etre enregistre ne sont pas dans le meme point de vente");
        }
    }
}

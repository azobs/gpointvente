package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.dao.produit.FamilleRepository;
import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.exceptions.produit.FamilleNonUniqueException;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FamilleServiceImplementation implements FamilleService {
    @Autowired
    FamilleRepository familleRepository;
    @Autowired
    PointventeService pointventeService;


    @Override
    public int isCodeFamilleUniqueInPointvente(String codeFamille, Pointvente pointvente) {
        List<Famille> listofFamilleWithCodeFamilleInPointvente =
                familleRepository.findAllByCodeFamilleAndPointventeOrderByCodeFamille(codeFamille,
                        pointvente);
        return listofFamilleWithCodeFamilleInPointvente.size()==0?1:0;
    }

    @Override
    public Famille getFamilleByIdFamille(String idFamille){
        Optional<Famille> optionalFamille = familleRepository.findFamilleByIdFamille(idFamille);
        if(optionalFamille.isPresent()){
            return optionalFamille.get();
        }
        return null;
    }

    @Override
    public int addFamilleToFamilleparente(Famille familleFille, Famille familleParente){
        familleParente.getListofFamilleFille().add(familleFille);
        familleRepository.save(familleParente);
        System.out.println("L'ajout de la famille fille a la famille parente precise a ete realise");
        return 1;
    }

    @Override
    public int addProduitToFamille(Produit produit, Famille famille){
        famille.getListofProduit().add(produit);
        familleRepository.save(famille);
        System.out.println("Le produit a ete ajoute a la liste des produits de la famille avec success");
        return 1;
    }

    @Override
    public Famille saveFamille(String designationFamilleFR, String designationFamilleEN,
                               String aliasFamilleFR, String aliasFamilleEN, String descriptionFamilleFR,
                               String descriptionFamilleEN, String codeFamille, Pointvente pointvente)
            throws FamilleNonUniqueException {
        Famille familleAEnreg = new Famille();
        familleAEnreg.setAliasFamilleEN(aliasFamilleEN);
        familleAEnreg.setAliasFamilleFR(aliasFamilleFR);
        familleAEnreg.setCodeFamille(codeFamille);
        familleAEnreg.setDescriptionFamilleEN(descriptionFamilleEN);
        familleAEnreg.setDescriptionFamilleFR(descriptionFamilleFR);
        familleAEnreg.setDesignationFamilleEN(designationFamilleEN);
        familleAEnreg.setDesignationFamilleFR(designationFamilleFR);

        if(this.isCodeFamilleUniqueInPointvente(codeFamille, pointvente)==1){
            /*
            Si on est ici alors on est sur que le code de la famille sera unique parmi les
            code des familles du point de vente.
            En plus on a trouve sans probleme le point de vente pour lequel la famille sera
            enregistrée
            */
            familleAEnreg.setPointvente(pointvente);
            return familleRepository.save(familleAEnreg);
        }
        else{
            throw new FamilleNonUniqueException("Exception lancee: " +
                    "Le code de la famille indiquee correspond deja " +
                    "a une autre famille dans le même point de vente");
        }

    }

    @Override
    public Famille saveFamille(String designationFamilleFR, String designationFamilleEN,
           String aliasFamilleFR, String aliasFamilleEN, String descriptionFamilleFR,
           String descriptionFamilleEN, String codeFamille, Famille familleParente,
           Pointvente pointvente) throws FamilleNonUniqueException {

        Famille familleAEnreg = new Famille();
        familleAEnreg.setAliasFamilleEN(aliasFamilleEN);
        familleAEnreg.setAliasFamilleFR(aliasFamilleFR);
        familleAEnreg.setCodeFamille(codeFamille);
        familleAEnreg.setDescriptionFamilleEN(descriptionFamilleEN);
        familleAEnreg.setDescriptionFamilleFR(descriptionFamilleFR);
        familleAEnreg.setDesignationFamilleEN(designationFamilleEN);
        familleAEnreg.setDesignationFamilleFR(designationFamilleFR);

        if(this.isCodeFamilleUniqueInPointvente(codeFamille, pointvente)==1){
                /*
                Si on est ici alors on est sur que le code de la famille sera unique parmi les
                code des familles du point de vente.
                En plus on a trouve sans probleme le point de vente pour lequel la famille sera
                enregistrée
                 */
            familleAEnreg.setPointvente(pointvente);
            if(familleParente!=null) {
                familleAEnreg.setFamilleParente(familleParente);
            }
            return familleRepository.save(familleAEnreg);
        }
        else{
            throw new FamilleNonUniqueException("Exception lancee: " +
                    "Le code de la famille indiquee correspond deja " +
                    "a une autre famille dans le même point de vente");
        }
    }

    @Override
    public Famille updateFamille(String idFamilleAModifier, String newdesignationFamilleFR, String newdesignationFamilleEN, String newaliasFamilleFR, String newaliasFamilleEN, String newdescriptionFamilleFR, String newdescriptionFamilleEN, String newcodeFamille, String newidFamilleParente) throws FamilleNonUniqueException {
        return null;
    }
}

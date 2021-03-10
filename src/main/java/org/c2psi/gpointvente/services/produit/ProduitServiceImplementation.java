package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.dao.produit.ProduitRepository;
import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.c2psi.gpointvente.exceptions.pv.DesignationProduitNonUniqueInFamilleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduitServiceImplementation implements ProduitService {
    @Autowired
    ProduitRepository produitRepository;


    @Override
    public int isDesignationProduitENUniqueInFamille(String designationProduitEN, Famille familleProduit) {
        List<Produit> listofProduitWithDesignationProduitENInFamille =
                produitRepository.findAllByDesignationProduitENAndFamilleProduitOrderByDesignationProduitEN(
                        designationProduitEN, familleProduit);
        return listofProduitWithDesignationProduitENInFamille.size()==0?1:0;
    }

    @Override
    public int isDesignationProduitFRUniqueInFamille(String designationProduitFR, Famille familleProduit) {
        List<Produit> listofProduitWithDesignationProduitFRInFamille =
                produitRepository.findAllByDesignationProduitFRAndFamilleProduitOrderByDesignationProduitFR(
                        designationProduitFR, familleProduit);
        return listofProduitWithDesignationProduitFRInFamille.size()==0?1:0;
    }

    @Override
    public int addProduitFormateToProduit(ProduitFormate produitFormate, Produit produit) {
        produit.getListofProduitFormate().add(produitFormate);
        produitRepository.save(produit);
        System.out.println("L'association entre le produit et un de ces produitformate a ete realisee");
        return 1;
    }

    @Override
    public Produit getProduitByIdProduit(String idProduit) {
        Optional<Produit> optionalProduit = produitRepository.findProduitByIdProduit(idProduit);
        if(optionalProduit.isPresent()){
            return optionalProduit.get();
        }
        return null;
    }

    @Override
    public Produit saveProduit(String designationProduitFR, String designationProduitEN, String aliasProduitFR,
                               String aliasProduitEN, String descriptionProduitFR, String descriptionProduitEN,
                               int perissable, Famille familleProduit) throws DesignationProduitNonUniqueInFamilleException {

        if(this.isDesignationProduitENUniqueInFamille(designationProduitEN, familleProduit)==0){
            throw new DesignationProduitNonUniqueInFamilleException("Exception levee: " +
                    "La designation du produit en anglais correspond deja a " +
                    "un autre produit existant");
        }
        if(this.isDesignationProduitFRUniqueInFamille(designationProduitFR, familleProduit)==0){
            throw new DesignationProduitNonUniqueInFamilleException("Exception levee: " +
                    "La designation du produit en francais correspond deja a " +
                    "un autre produit existant");
        }

        /*
        Si on est ici alors toutes les designantions seront unique dans la famille de produit designée
        */
        Produit produitAEnreg = new Produit();
        produitAEnreg.setAliasProduitEN(aliasProduitEN);
        produitAEnreg.setAliasProduitFR(aliasProduitFR);
        produitAEnreg.setDescriptionProduitEN(descriptionProduitEN);
        produitAEnreg.setDescriptionProduitFR(descriptionProduitFR);
        produitAEnreg.setDesignationProduitEN(designationProduitEN);
        produitAEnreg.setDesignationProduitFR(designationProduitFR);
        produitAEnreg.setPerissable(perissable);

        produitAEnreg.setFamilleProduit(familleProduit);

        return produitRepository.save(produitAEnreg);
    }
}

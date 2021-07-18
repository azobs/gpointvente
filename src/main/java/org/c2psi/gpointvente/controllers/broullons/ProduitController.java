package org.c2psi.gpointvente.controllers.broullons;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.exceptions.pv.DesignationProduitNonUniqueInFamilleException;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregProduit;
import org.c2psi.gpointvente.services.produit.FamilleService;
import org.c2psi.gpointvente.services.produit.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProduitController {
    @Autowired
    FamilleService familleService;
    @Autowired
    ProduitService produitService;

    @PostMapping("/enregistrerProduit")
    public String enregistrerProduit(@Valid @RequestBody FormEnregProduit formEnregProduit, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try {
            System.out.println("formEnregProduit.getIdFamilleProduit() == " + formEnregProduit.getIdFamilleProduit());
            Famille familleProduit = null;
            Optional<Famille> optionalFamille = Optional.ofNullable(
                    familleService.getFamilleByIdFamille(formEnregProduit.getIdFamilleProduit()));
            if(optionalFamille.isPresent()){
                familleProduit = optionalFamille.get();
                Produit produitAEnreg = produitService.saveProduit(formEnregProduit.getDesignationProduitFR(),
                        formEnregProduit.getDesignationProduitEN(), formEnregProduit.getAliasProduitFR(),
                        formEnregProduit.getAliasProduitEN(), formEnregProduit.getDescriptionProduitFR(),
                        formEnregProduit.getDescriptionProduitEN(), formEnregProduit.getPerissable(), familleProduit);
                /*
                Il faut ajouter le produit cree a la liste des produits de la famille indiquee
                 */
                familleService.addProduitToFamille(produitAEnreg, familleProduit);
                return ValeurRetour.enregProduitSuccess;
            }
            else{
                return ValeurRetour.familleNotExist;
            }

        }
        catch (DesignationProduitNonUniqueInFamilleException e){
            System.out.println(e.getMessage());
            return ValeurRetour.designationProduitNonUniqueInFamille;
        }
    }
}

package org.c2psi.gpointvente.controllers.broullons;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateNonUniqueException;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregProduitFormate;
import org.c2psi.gpointvente.services.produit.FormatproduitService;
import org.c2psi.gpointvente.services.produit.ProduitFormateService;
import org.c2psi.gpointvente.services.produit.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ProduitFormateController {
    @Autowired
    ProduitFormateService produitFormateService;
    @Autowired
    ProduitService produitService;
    @Autowired
    FormatproduitService formatproduitService;

    @PostMapping("/enregistrerProduitFormate")
    public String enregistrerProduitFormate(@Valid @RequestBody FormEnregProduitFormate formEnregProduitFormate,
                                            BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try{
            Optional<Produit> optionalProduit = Optional.ofNullable(produitService.getProduitByIdProduit(
                    formEnregProduitFormate.getIdProduitAFormate()));
            Optional<Formatproduit> optionalFormatproduit =
                    formatproduitService.getFormatproduitByIdFormatproduit(formEnregProduitFormate.getIdFormat());
            if(optionalProduit.isPresent() && optionalFormatproduit.isPresent()){
                ProduitFormate produitFormateEnreg = produitFormateService.saveProduitFormate(optionalProduit.get(),
                        optionalFormatproduit.get(), new Date(),
                        formEnregProduitFormate.getPhotoPF());
                /*
                *Il faut ajouter ce produitformate (produitconditionne) a la liste des conditionnements du produit.
                * Il s'agit de la liste de tous les produitformate issu d'un produit. Autrement dit tous les conditionnements
                * utilise pour le produit dans le point de vente.
                 */
                produitService.addProduitFormateToProduit(produitFormateEnreg, optionalProduit.get());
                return ValeurRetour.produitformateEnregSuccess;
            }
            else{
                return ValeurRetour.produitformateEnregError;
            }
        }
        catch (ProduitFormateNonUniqueException e){
            System.out.println(e.getMessage());
            return ValeurRetour.produitFormateNonUniqueInPointvente;
        }
        catch (ProduitFormateMalFormedException e){
            System.out.println(e.getMessage());
            return ValeurRetour.produitFormateMalFormedInPointvente;
        }
    }

}

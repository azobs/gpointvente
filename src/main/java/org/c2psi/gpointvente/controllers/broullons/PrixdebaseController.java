package org.c2psi.gpointvente.controllers.broullons;

import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.exceptions.prix.DeviseNotFoundException;
import org.c2psi.gpointvente.exceptions.prix.PrixdebaseMalFormedException;
import org.c2psi.gpointvente.forms.formsEnreg.prix.FormEnregPrixdebase;
import org.c2psi.gpointvente.services.prix.DeviseService;
import org.c2psi.gpointvente.services.prix.PrixdebaseService;
import org.c2psi.gpointvente.services.produit.ProduitFormateUniteService;
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
public class PrixdebaseController {
    @Autowired
    PrixdebaseService prixdebaseService;
    @Autowired
    DeviseService deviseService;
    @Autowired
    ProduitFormateUniteService produitFormateUniteService;

    @PostMapping("/enregistrerPrixdebase")
    public String enregistrerPrixdebase(@Valid @RequestBody FormEnregPrixdebase formEnregPrixdebase,
                                        BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try{
            System.out.println("formEnregPrixdebase.getIdDevisePrix() == " + formEnregPrixdebase.getIdDevisePrix());
            Optional<Devise> optionaldevisePrix = deviseService.getDeviseByIdDevise(formEnregPrixdebase.getIdDevisePrix());
            /*Optional<ProduitFormateUnite> produitFormateUnite =
                    produitFormateUniteService.getProduitFormateUniteByIdPFU(
                            formEnregPrixdebase.getIdProduitFormateUniteConcerne());*/
            if(optionaldevisePrix.isPresent()){
                Devise devisePrix = optionaldevisePrix.get();
                if(devisePrix.getPointvente().getIdPointvente().equalsIgnoreCase(
                        formEnregPrixdebase.getIdPointvente())){
                    /***
                     * On peut donc enregistre le prix d'abord sans precise le produit. Puis apres on va modifier
                     * le prixdebase enregistré pour ajouter le produit associe a ce prix
                     */

                }
                else{
                    throw new PrixdebaseMalFormedException("Exception levee: L'identifiant de la devise choisi " +
                            "ne correspond pas à une devise du point de vente pour lequel le prix sera enregistré");
                }
            }
            else{
                throw new DeviseNotFoundException("Exception levee: L'identifiant saisi pour la devise du prix " +
                        "ne correspond a aucune devise enregistrée dans le système");
            }
        }
        catch (Exception e){
            System.out.println("Exception est== "+e.getMessage());
            e.printStackTrace();
            return null;
        }
        return null;
    }
}

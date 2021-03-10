package org.c2psi.gpointvente.controllers.produit;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.FormatproduitNonUniqueException;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregFormatproduit;
import org.c2psi.gpointvente.services.produit.FormatproduitService;
import org.c2psi.gpointvente.services.pv.PointventeService;
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
public class FormatproduitController {
    @Autowired
    FormatproduitService formatproduitService;
    @Autowired
    PointventeService pointventeService;


    @PostMapping("/enregistrerFormatproduit")
    public String enregistrerFormatproduit(@Valid @RequestBody FormEnregFormatproduit formEnregFormatproduit,
                                           BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try{
            System.out.println("formEnregFormatproduit.getIdPointvente() == " + formEnregFormatproduit.getIdPointvente());
            Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                    formEnregFormatproduit.getIdPointvente()));
            if(optionalPointvente.isPresent()){
                Formatproduit formatproduit = formatproduitService.saveFormatproduit(
                        formEnregFormatproduit.getContenance(),
                        formEnregFormatproduit.getDesignationFormatproduitEN(),
                        formEnregFormatproduit.getDesignationFormatproduitFR(), optionalPointvente.get());
                /*
                * Il faut ajouter le format de produit (le conditionnement) ainsi cree a la liste des formats de
                * produit du point de vente
                */
                pointventeService.addFormatproduitToPointvente(formatproduit, optionalPointvente.get());
                return ValeurRetour.formatproduitEnregSuccess;
            }
            else{
                return ValeurRetour.pointventeNotExist;
            }
        }
        catch (FormatproduitNonUniqueException e){
            System.out.println(e.getMessage());
            return ValeurRetour.formatproduitNonUniqueInPointvente;
        }
    }
}

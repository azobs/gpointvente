package org.c2psi.gpointvente.controllers.produit;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.c2psi.gpointvente.exceptions.produit.UniteproduitNonUniqueException;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregRegleconversionUnite;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregUniteproduit;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.c2psi.gpointvente.services.produit.UniteproduitService;
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
public class UniteproduitController {
    @Autowired
    UniteproduitService uniteproduitService;
    @Autowired
    PointventeService pointventeService;


    @PostMapping("/enregistrerUniteproduit")
    public String enregistrerUniteproduit(@Valid @RequestBody FormEnregUniteproduit formEnregUniteproduit,
                                           BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try{
            System.out.println("formEnregFormatproduit.getIdPointvente() == " + formEnregUniteproduit.getIdPointvente());
            Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                    formEnregUniteproduit.getIdPointvente()));
            if(optionalPointvente.isPresent()){
                Uniteproduit uniteproduit = uniteproduitService.saveUniteproduit(
                        formEnregUniteproduit.getLibelleUniteFR(), formEnregUniteproduit.getAbbreviationUniteFR(),
                        formEnregUniteproduit.getLibelleUniteEN(), formEnregUniteproduit.getAbbreviationUniteEN(),
                        optionalPointvente.get());
                /*
                 * Il faut ajouter l'unite de produit ainsi cree a la liste des unites de
                 * produit du point de vente
                 */
                pointventeService.addUniteproduitToPointvente(uniteproduit, optionalPointvente.get());
                return ValeurRetour.uniteproduitEnregSuccess;

            }
            else{
                return ValeurRetour.pointventeNotExist;
            }
        }
        catch (UniteproduitNonUniqueException e){
            System.out.println(e.getMessage());
            return ValeurRetour.uniteproduitNonUniqueInPointvente;
        }
    }

    @PostMapping("/enregistrerRegleconversionUnite")
    public String enregistrerRegleconversionUnite(@Valid @RequestBody FormEnregRegleconversionUnite formEnregRegleconversionUnite,
                                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try{
            Optional<Uniteproduit> optionalUniteproduitmultiple = Optional.ofNullable(
                    uniteproduitService.getUniteproduitByIdUnite(
                            formEnregRegleconversionUnite.getIdUnitemultiple()));

            Optional<Uniteproduit> optionalUniteproduitsousmultiple = Optional.ofNullable(
                    uniteproduitService.getUniteproduitByIdUnite(
                            formEnregRegleconversionUnite.getIdUnitesousmultiple()));

            if(optionalUniteproduitmultiple.isPresent()){
                if(optionalUniteproduitsousmultiple.isPresent()){
                    Uniteproduit uniteproduitMultiple = optionalUniteproduitmultiple.get();
                    Uniteproduit uniteproduitsousMultiple = optionalUniteproduitsousmultiple.get();

                    uniteproduitService.saveRegleconversionUnite(uniteproduitMultiple,
                            uniteproduitsousMultiple,
                            formEnregRegleconversionUnite.getFacteurconversionUnite());
                    return ValeurRetour.regleconversionUniteSavedSuccess;
                }
                else{
                    return ValeurRetour.regleconversionUniteNotExist;
                }
            }
            else{
                return ValeurRetour.regleconversionUniteNotExist;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ValeurRetour.regleconversionUniteSavedError;
        }
    }

}

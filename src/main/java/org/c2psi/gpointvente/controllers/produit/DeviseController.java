package org.c2psi.gpointvente.controllers.produit;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.prix.RegleconversionDevise;
import org.c2psi.gpointvente.forms.formsEnreg.prix.FormEnregDevise;
import org.c2psi.gpointvente.forms.formsEnreg.prix.FormEnregRegleconversionDevise;
import org.c2psi.gpointvente.forms.FormSetDeviseToDefault;
import org.c2psi.gpointvente.forms.FormUpdateDevise;
import org.c2psi.gpointvente.services.prix.DeviseService;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DeviseController {
    @Autowired
    DeviseService deviseService;
    @Autowired
    PointventeService pointventeService;

    @PostMapping("/enregistrerDevise")
    public String enregDevise(@Valid @RequestBody FormEnregDevise formEnregDevise,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
            System.out.println("formEnregDevise.getIdPointvente == "+formEnregDevise.getIdPointvente());
            Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                    formEnregDevise.getIdPointvente()));
            if(optionalPointvente.isPresent()){
                Devise devise = deviseService.saveDevise(formEnregDevise.getLibelleDeviseEN(),
                        formEnregDevise.getLibelleDeviseFR(), formEnregDevise.getAbbreviationDeviseEN(),
                        formEnregDevise.getAbbreviationDeviseFR(), formEnregDevise.getFormataffichageDevise(),
                        formEnregDevise.isDevisepardefaut(), optionalPointvente.get());
                /*
                Il faut maintenant ajouter la devise enregistree dans la liste des devises du point de vente
                 */
                deviseService.addDeviseToPointvente(devise,optionalPointvente.get());

                return ValeurRetour.enregDeviseSuccess;
            }
            else{
                return ValeurRetour.pointventeNotExist;
            }
    }

    @RequestMapping(value = "/updateDevise", method = RequestMethod.PATCH)
    public String updateDevise(@Valid @RequestBody FormUpdateDevise formUpdateDevise,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try {
            System.out.println("formUpdateDevise.getIdDevise() == " + formUpdateDevise.getIdDevise());
            Devise devise = deviseService.updateDevise(formUpdateDevise.getIdDevise(), formUpdateDevise.getLibelleDeviseEN(),
                    formUpdateDevise.getLibelleDeviseFR(), formUpdateDevise.getAbbreviationDeviseEN(),
                    formUpdateDevise.getAbbreviationDeviseFR(), formUpdateDevise.getFormataffichageDevise());
            return ValeurRetour.updateDeviseSucess;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ValeurRetour.deviseNotExist;
        }
    }

    @RequestMapping(value = "/setDeviseToDefault", method = RequestMethod.PATCH)
    public String setDeviseToDefault(@Valid @RequestBody FormSetDeviseToDefault formSetDeviseToDefault,
                                     BindingResult bindingResult){
        System.out.println("valeur de idDevise "+formSetDeviseToDefault.getIdDevise());
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try{
            int r = deviseService.setToDefaultDevise(formSetDeviseToDefault.getIdDevise());
            return (r == 1 ? ValeurRetour.deviseSetToDefaultWithSucess:
                    ValeurRetour.deviseSetToDefaultWithError);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ValeurRetour.deviseNotExist;
        }
    }

    @RequestMapping(value = "/saveRegleconversionDevise", method = RequestMethod.POST)
    public String saveRegleconversionDevise(@Valid @RequestBody FormEnregRegleconversionDevise formEnregRegleconversionDevise,
                                            BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try{
            Optional<Devise> deviseMultiple = deviseService.getDeviseByIdDevise(
                    formEnregRegleconversionDevise.getIdDevisemultiple());
            Optional<Devise> deviseSousMultiple = deviseService.getDeviseByIdDevise(
                    formEnregRegleconversionDevise.getIdDevisesousmultiple());

            if(deviseMultiple.isPresent()){
                if(deviseSousMultiple.isPresent()){
                    RegleconversionDevise regleconversionDevise = deviseService.saveRegleconversionDevise(
                            deviseMultiple.get(),
                            deviseSousMultiple.get(),
                            formEnregRegleconversionDevise.getFacteurconversionDevise());

                    return ValeurRetour.regleconversionSavedSuccess;
                }
                else{
                    return ValeurRetour.deviseSousMultipleNotExist;
                }
            }
            else{
                return ValeurRetour.deviseMultipleNotExist;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ValeurRetour.regleconversionSavedError;
        }
    }

    @GetMapping("/getListofDevise")
    public List<Devise> getListofDevise(@RequestParam(name="ordre", defaultValue="1")int ordre){
        /***************************************************
         * LibelleDeviseENCroissant=1;
         * LibelleDeviseFRCroissant=2;
         * AbbreviationDeviseENCroissant=3;
         * AbbreviationDeviseFRCroissant=4;
         * LibelleDeviseENDecroissant=5;
         * LibelleDeviseFRDecroissant=6;
         * AbbreviationDeviseENDecroissant=7;
         * AbbreviationDeviseFRDecroissant=8;
         ***************************************************/
        return deviseService.getListofDevise(ordre);
    }

    @GetMapping("/getPageofDevise")
    public Page<Devise> getPageofDevise(@RequestParam(name="numPage", defaultValue="0")int numPage,
                                        @RequestParam(name="taillePage", defaultValue="1")int taillePage,
                                        @RequestParam(name="ordre", defaultValue="1")int ordre){
        /***************************************************
         * LibelleDeviseENCroissant=1;
         * LibelleDeviseFRCroissant=2;
         * AbbreviationDeviseENCroissant=3;
         * AbbreviationDeviseFRCroissant=4;
         * LibelleDeviseENDecroissant=5;
         * LibelleDeviseFRDecroissant=6;
         * AbbreviationDeviseENDecroissant=7;
         * AbbreviationDeviseFRDecroissant=8;
         ***************************************************/
        return deviseService.getPageofDevise(numPage, taillePage, ordre);
    }

    @GetMapping("/getListofDevisePointvente")
    public List<Devise> getListofDevisePointevente(@RequestParam(name="idPointvente", defaultValue="0")String idPointvente,
                                                   @RequestParam(name="ordre", defaultValue="1")int ordre){
        /***************************************************
         * LibelleDeviseENCroissant=1;
         * LibelleDeviseFRCroissant=2;
         * AbbreviationDeviseENCroissant=3;
         * AbbreviationDeviseFRCroissant=4;
         * LibelleDeviseENDecroissant=5;
         * LibelleDeviseFRDecroissant=6;
         * AbbreviationDeviseENDecroissant=7;
         * AbbreviationDeviseFRDecroissant=8;
         ***************************************************/
        return deviseService.getListofDevisePointvente(idPointvente, ordre);
    }

}

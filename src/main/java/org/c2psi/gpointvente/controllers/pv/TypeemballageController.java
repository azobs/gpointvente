package org.c2psi.gpointvente.controllers.pv;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.pv.CompteemballagePv;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.pv.Typeemballage;
import org.c2psi.gpointvente.forms.formsEnreg.pv.FormEnregTypeemballage;
import org.c2psi.gpointvente.forms.FormUpdateTypeemballage;
import org.c2psi.gpointvente.services.pv.CompteemballagePvService;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.c2psi.gpointvente.services.pv.TypeemballageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TypeemballageController {
    @Autowired
    PointventeService pointventeService;
    @Autowired
    TypeemballageService typeemballageService;
    @Autowired
    CompteemballagePvService compteemballagePvService;


    @PostMapping("/enregistrerTypeemballage")
    public String enregTypeemballage(@Valid @RequestBody FormEnregTypeemballage formEnregTypeemballage,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        System.out.println("formUpdateTypeemballage.getIdPointvente == "+
                    formEnregTypeemballage.getIdPointvente());

        /*
           Il faut créer le compteemballagePv qui sera lie a ce type d'emballage
        */
        CompteemballagePv cePv = compteemballagePvService.saveCompteemballagePv(
                    formEnregTypeemballage.getNbreemballageInitial());

        /*
           Il faut chercher le point de vente pour lequel le typeemballage est enregistré
        */
        Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                    formEnregTypeemballage.getIdPointvente()));

        if(optionalPointvente.isPresent()){
            Typeemballage typeemballage = typeemballageService.saveTypeemballage(
                    formEnregTypeemballage.getDesignationEmballageEN(),
                    formEnregTypeemballage.getDesignationEmballageFR(),
                    formEnregTypeemballage.getDescriptionEmballageEN(),
                    formEnregTypeemballage.getDescriptionEmballageFR(),
                    formEnregTypeemballage.getCouleurphareEmballage(),
                    formEnregTypeemballage.getPhotoEmballage(),
                    formEnregTypeemballage.getPrixEmballage(),
                    formEnregTypeemballage.getMatiereEmballage(),
                    optionalPointvente.get(), cePv);

            pointventeService.addTypeemballageToPointvente(typeemballage, optionalPointvente.get());
            return ValeurRetour.enregTypeemballageSuccess;
        }
        else{
            return ValeurRetour.pointventeNotExist;
        }
    }

    @RequestMapping(value = "/updateTypeemballage", method = RequestMethod.PATCH)
    public String updateTypeemballage(@Valid @RequestBody FormUpdateTypeemballage formUpdateTypeemballage,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }
        try{
            Typeemballage typeemballage = typeemballageService.updateTypeemballage(
                    formUpdateTypeemballage.getIdTypeemballage(),
                    formUpdateTypeemballage.getDesignationEmballageEN(),
                    formUpdateTypeemballage.getDesignationEmballageFR(),
                    formUpdateTypeemballage.getDescriptionEmballageEN(),
                    formUpdateTypeemballage.getDescriptionEmballageFR(),
                    formUpdateTypeemballage.getCouleurphareEmballage(),
                    formUpdateTypeemballage.getPhotoEmballage(),
                    formUpdateTypeemballage.getPrixEmballage(),
                    formUpdateTypeemballage.getMatiereEmballage());
            return ValeurRetour.updateTypeemballageSuccess;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ValeurRetour.typeemballageNotExist;
        }
    }

    @GetMapping("/getListofTypeemballage")
    public List<Typeemballage> getListofTypeemballage(@RequestParam(name="ordre", defaultValue="1")int ordre){
        /***************************************************
         * DesignationEmballageENCroissant=1;
         * DesignationEmballageFRCroissant=2;
         * PrixEmballageCroissant=3;
         * DesignationEmballageENDecroissant=4;
         * DesignationEmballageFRDecroissant=5;
         * PrixEmballageDecroissant=6;
         ***************************************************/
        return typeemballageService.getListofTypeemballage(ordre);
    }

    @GetMapping("/getPageofTypeemballage")
    public Page<Typeemballage> getPageofTypeemballage(
            @RequestParam(name="numPage", defaultValue="0")int numPage,
            @RequestParam(name="taillePage", defaultValue="1")int taillePage,
            @RequestParam(name="ordre", defaultValue="1")int ordre){
        /***************************************************
         * DesignationEmballageENCroissant=1;
         * DesignationEmballageFRCroissant=2;
         * PrixEmballageCroissant=3;
         * DesignationEmballageENDecroissant=4;
         * DesignationEmballageFRDecroissant=5;
         * PrixEmballageDecroissant=6;
         ***************************************************/
        return typeemballageService.getPageofTypeemballage(numPage, taillePage, ordre);
    }

    @GetMapping("/getListofTypeemballagePointvente")
    public List<Typeemballage> getListofTypeemballagePointvente(@RequestParam(name="idPointvente", defaultValue="0")String idPointvente,
            @RequestParam(name="ordre", defaultValue="1")int ordre){
        /***************************************************
         * DesignationEmballageENCroissant=1;
         * DesignationEmballageFRCroissant=2;
         * PrixEmballageCroissant=3;
         * DesignationEmballageENDecroissant=4;
         * DesignationEmballageFRDecroissant=5;
         * PrixEmballageDecroissant=6;
         ***************************************************/
        return typeemballageService.getListofTypeemballagePointvente(idPointvente, ordre);
    }

    @GetMapping("/getPageofTypeemballagePointvente")
    public Page<Typeemballage> getPageofTypeemballagePointvente(
            @RequestParam(name="idPointvente", defaultValue="0")String idPointvente,
            @RequestParam(name="numPage", defaultValue="0")int numPage,
            @RequestParam(name="taillePage", defaultValue="1")int taillePage,
            @RequestParam(name="ordre", defaultValue="1")int ordre){
        /***************************************************
         * DesignationEmballageENCroissant=1;
         * DesignationEmballageFRCroissant=2;
         * PrixEmballageCroissant=3;
         * DesignationEmballageENDecroissant=4;
         * DesignationEmballageFRDecroissant=5;
         * PrixEmballageDecroissant=6;
         ***************************************************/
        return typeemballageService.getPageofTypeemballagePointvente(idPointvente, numPage, taillePage, ordre);
    }


}

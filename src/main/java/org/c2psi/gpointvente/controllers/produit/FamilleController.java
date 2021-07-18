package org.c2psi.gpointvente.controllers.produit;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.FamilleNonUniqueException;
import org.c2psi.gpointvente.exceptions.produit.FamilleNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.PointventeNotFoundException;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregFamille;
import org.c2psi.gpointvente.services.produit.FamilleService;
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
public class FamilleController {
    @Autowired
    FamilleService familleService;
    @Autowired
    PointventeService pointventeService;

    @PostMapping("/enregistrerFamille")
    public String saveFamille(@Valid @RequestBody FormEnregFamille formEnregFamille,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try{
            System.out.println("FormEnregFamille.getIdPointvente == "+formEnregFamille.getIdPointvente());
            Pointvente pointvente = null;
            Famille familleParente = null;
            Optional<Pointvente> optionalPointvente = Optional.ofNullable(
                    pointventeService.getPointventeById(formEnregFamille.getIdPointvente()));
            if(optionalPointvente.isPresent()){
                pointvente = optionalPointvente.get();
            }
            else{
                return ValeurRetour.pointventeNotExist;
            }

            Famille familleEnreg = null;
            Optional<Famille> optionalFamilleParente = Optional.ofNullable(
                    familleService.getFamilleByIdFamille(formEnregFamille.getIdFamilleParente()));
            if(optionalFamilleParente.isPresent()){
                familleParente = optionalFamilleParente.get();

                familleEnreg = familleService.saveFamille(formEnregFamille.getDesignationFamilleFR(),
                        formEnregFamille.getDesignationFamilleEN(), formEnregFamille.getAliasFamilleFR(),
                        formEnregFamille.getAliasFamilleEN(), formEnregFamille.getDescriptionFamilleFR(),
                        formEnregFamille.getDescriptionFamilleEN(), formEnregFamille.getCodeFamille(),
                        familleParente, pointvente);
                /*
                Il faut ajouter la famille cree a la liste des familles filles de sa famille parente
                */
                familleService.addFamilleToFamilleparente(familleEnreg, familleParente);
            }
            /*
            Pas de Else car une famille n'est pas obligee d'avoir une famille parente
            Il faut donc enregistrer la famille sans gerer la famille parente
             */
            familleEnreg = familleService.saveFamille(formEnregFamille.getDesignationFamilleFR(),
                    formEnregFamille.getDesignationFamilleEN(), formEnregFamille.getAliasFamilleFR(),
                    formEnregFamille.getAliasFamilleEN(), formEnregFamille.getDescriptionFamilleFR(),
                    formEnregFamille.getDescriptionFamilleEN(), formEnregFamille.getCodeFamille(),
                    pointvente);

            /*
            Il faut ajouter la famille cree a la liste des familles de produit vendu dans le point de vente
             */
            pointventeService.addFamilleToPointvente(familleEnreg, pointvente);
            return ValeurRetour.enregFamilleSuccess;

        }
        catch (FamilleNotFoundException e){
            System.out.println(e.getMessage());
            return ValeurRetour.familleNotExist;
        }
        catch (PointventeNotFoundException e){
            System.out.println(e.getMessage());
            return ValeurRetour.pointventeNotExist;
        }
        catch (FamilleNonUniqueException e){
            System.out.println(e.getMessage());
            return ValeurRetour.familleNonUniqueException;
        }
    }
}

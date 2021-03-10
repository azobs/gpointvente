package org.c2psi.gpointvente.controllers.tier;

import org.c2psi.gpointvente.constantes.NatureTier;
import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.pv.Adresse;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.c2psi.gpointvente.entities.tier.Tier;
import org.c2psi.gpointvente.exceptions.tier.TierExistInPointventeException;
import org.c2psi.gpointvente.forms.formsEnreg.tier.FormEnregFournisseur;
import org.c2psi.gpointvente.services.pv.AdresseService;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.c2psi.gpointvente.services.tier.TierService;
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
public class TierController {
    @Autowired
    TierService tierService;
    @Autowired
    PointventeService pointventeService;
    @Autowired
    AdresseService adresseService;

    @PostMapping("/enregistrerFournisseur")
    public String enregEntreprise(@Valid @RequestBody FormEnregFournisseur formEnregFournisseur,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }
        /***************
         * Pour enregistrer le fournisseur il faut d'abord:
         * Enregistrer le Tier
         * Enregistrer le fournisseur
         * Enregistrer le fournir
         */
        Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                formEnregFournisseur.getIdPointvente()));
        if(optionalPointvente.isPresent()){
            Pointvente pointvente = optionalPointvente.get();
            Optional<Adresse> optionalAdresse = adresseService.findAdresseByIdadresse(
                    formEnregFournisseur.getIdAdresse());
            if(optionalAdresse.isPresent()) {
                /*
                Ici on enregistre avec adresse
                 */
                Adresse adresse = optionalAdresse.get();
                String natureTier = NatureTier.tierFournisseur;
                Date dateenregTier = new Date();
                try {
                    Tier tierEnreg = tierService.saveTier(formEnregFournisseur.getNomsFournisseur(),
                            formEnregFournisseur.getAliasFournisseur(),natureTier,
                            formEnregFournisseur.getLanguepardefautFournisseur(), adresse, dateenregTier,
                            formEnregFournisseur.getObservation(), pointvente);
                    Fournisseur fournisseurEnreg = tierService.saveFournisseur(tierEnreg);
                    tierService.saveFournir(fournisseurEnreg, pointvente);
                    return ValeurRetour.fournisseurSavedSuccess;
                } catch (TierExistInPointventeException e) {
                    System.out.println("Exception levee: "+e.getMessage());
                    return ValeurRetour.fournisseurExistInPointvente;
                }
            }
            else{
                /*
                Ici on enregistre sans adresse
                 */
            }
        }
        return ValeurRetour.pointventeNotExist;
    }
}

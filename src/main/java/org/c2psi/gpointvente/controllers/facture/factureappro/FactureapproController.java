package org.c2psi.gpointvente.controllers.facture.factureappro;

import org.c2psi.gpointvente.constantes.NatureTier;
import org.c2psi.gpointvente.constantes.TypeFacture;
import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.facture.Facture;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.c2psi.gpointvente.exceptions.facture.FactureapproMalFormedException;
import org.c2psi.gpointvente.exceptions.facture.FactureapproNonUniqueException;
import org.c2psi.gpointvente.forms.formsEnreg.facture.factureappro.FormEnregFactureapprocapsule;
import org.c2psi.gpointvente.forms.formsEnreg.facture.factureappro.FormEnregFactureapproespece;
import org.c2psi.gpointvente.services.facture.FactureService;
import org.c2psi.gpointvente.services.facture.factureappro.FactureapproService;
import org.c2psi.gpointvente.services.facture.factureappro.FactureapprocapsuleService;
import org.c2psi.gpointvente.services.facture.factureappro.FactureapproespeceService;
import org.c2psi.gpointvente.services.tier.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class FactureapproController {
    @Autowired
    FactureService factureService;
    @Autowired
    FactureapproService factureapproService;
    @Autowired
    FactureapproespeceService factureapproespeceService;
    @Autowired
    FactureapprocapsuleService factureapprocapsuleService;
    @Autowired
    TierService tierService;


    @PostMapping("/enregistrerFactureapproespece")
    public String enregFactureapproespece(@Valid @RequestBody
                                                      FormEnregFactureapproespece formEnregFactureapproespece,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }

        /**************************
         * Pour enregistrer la factureapproespece, il faut d'abord
         *  enregistrer la facture
         *  enregistrer la factureeppro a partir de la facture
         *  et enfin enregistrer la factureapproespece a partir de la factureappro
         */
        Facture factureAssocie = factureService.saveFacture(TypeFacture.factureAppro);

        /********************************
         * Une fois qu'on a la facture enregistre il faut enregistrer la factureappro
         * Une factureapproespece a toujours une facture palpable
         */
        Date dateheureEnreg = new Date();
        //LocalTime heure = LocalTime.now();
        Calendar heure = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dateheureEnregFormate = sdf1.parse(sdf1.format(dateheureEnreg));
            Optional<Fournisseur> optionalFournisseur = tierService.findFournisseurByNomstierAndNatureTier(
                    formEnregFactureapproespece.getNomFournisseur(), NatureTier.tierFournisseur);
            if(optionalFournisseur.isPresent()){
                Fournisseur fournisseur = optionalFournisseur.get();
                try {

                    Factureappro factureapproAssocie = factureapproService.saveFactureappro(
                            formEnregFactureapproespece.getNumeroFacture(),
                            sdf1.parse(formEnregFactureapproespece.getDateheureFacture()), dateheureEnregFormate,
                            TypeFacture.factureApproEspece, formEnregFactureapproespece.getObservation(),
                            factureAssocie, fournisseur);
                    /*
                    Il faut maintenant enregistrer la factureapproespece a partir de la factureappro
                     */
                    factureapproespeceService.saveFactureapproespece(
                            formEnregFactureapproespece.getMontantAttendu(),
                            formEnregFactureapproespece.getMontantVerse(), factureapproAssocie);
                    return ValeurRetour.factureapproespeceEnregSuccess;
                } catch (FactureapproMalFormedException e) {
                    e.printStackTrace();
                    return ValeurRetour.factureapproMalFormedException;
                } catch (FactureapproNonUniqueException e) {
                    e.printStackTrace();
                    return ValeurRetour.factureapproNonUniqueException;
                }
            }
            else{
                return ValeurRetour.facturesansFournisseur;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return ValeurRetour.datenonconvertibleException;
        }
    }

    @PostMapping("/enregistrerFactureapprocapsule")
    public String enregFactureapprocapsule(@Valid @RequestBody
                                                       FormEnregFactureapprocapsule formEnregFactureapprocapsule,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }
        /**************************
         * Pour enregistrer la factureapprocapsule, il faut d'abord
         *  enregistrer la facture
         *  enregistrer la factureeppro a partir de la facture
         *  et enfin enregistrer la factureapprocapsule a partir de la factureappro
         */
        Facture factureAssocie = factureService.saveFacture(TypeFacture.factureAppro);

        /********************************
         * Une fois qu'on a la facture enregistre il faut enregistrer la factureappro
         * Une factureapproespece a toujours une facture palpable
         */
        Date dateheureEnreg = new Date();
        //LocalTime heure = LocalTime.now();
        Calendar heure = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dateheureEnregFormate = sdf1.parse(sdf1.format(dateheureEnreg));
            Optional<Fournisseur> optionalFournisseur = tierService.findFournisseurByNomstierAndNatureTier(
                    formEnregFactureapprocapsule.getNomFournisseur(), NatureTier.tierFournisseur);
            if(optionalFournisseur.isPresent()){
                Fournisseur fournisseur = optionalFournisseur.get();
                try {

                    Factureappro factureapproAssocie = factureapproService.saveFactureappro(
                            formEnregFactureapprocapsule.getNumeroFacture(),
                            sdf1.parse(formEnregFactureapprocapsule.getDateheureFacture()), dateheureEnregFormate,
                            TypeFacture.factureApproCapsule, formEnregFactureapprocapsule.getObservation(),
                            factureAssocie, fournisseur);
                    /*
                    Il faut maintenant enregistrer la factureapprocaspule a partir de la factureappro
                     */
                    factureapprocapsuleService.saveFactureapprocapsule(
                            formEnregFactureapprocapsule.getEstimationvaleur(),
                            formEnregFactureapprocapsule.getNbrecapsuleAchange(),
                            formEnregFactureapprocapsule.getNbrecapsulechange(), factureapproAssocie);
                    return ValeurRetour.factureapprocapsuleEnregSuccess;
                } catch (FactureapproMalFormedException e) {
                    e.printStackTrace();
                    return ValeurRetour.factureapproMalFormedException;
                } catch (FactureapproNonUniqueException e) {
                    e.printStackTrace();
                    return ValeurRetour.factureapproNonUniqueException;
                }
            }
            else{
                return ValeurRetour.facturesansFournisseur;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return ValeurRetour.datenonconvertibleException;
        }
    }
}

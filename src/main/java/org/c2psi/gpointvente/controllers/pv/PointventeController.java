package org.c2psi.gpointvente.controllers.pv;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.pv.Adresse;
import org.c2psi.gpointvente.entities.pv.Compteprincipal;
import org.c2psi.gpointvente.entities.pv.Entreprise;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.pv.DenominationPvNonUniqueInEntrepriseException;
import org.c2psi.gpointvente.exceptions.pv.EntrepriseNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.UnchangeableProprietaireOfCompteprincipalException;
import org.c2psi.gpointvente.forms.formsEnreg.pv.FormEnregPointvente;
import org.c2psi.gpointvente.forms.FormResetCompteprincipal;
import org.c2psi.gpointvente.forms.FormUpdateAdresse;
import org.c2psi.gpointvente.forms.FormUpdateParamPointvente;
import org.c2psi.gpointvente.services.pv.AdresseService;
import org.c2psi.gpointvente.services.pv.CompteprincipalService;
import org.c2psi.gpointvente.services.pv.EntrepriseService;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PointventeController {
    @Autowired
    PointventeService pointventeService;
    @Autowired
    EntrepriseService entrepriseService;
    @Autowired
    AdresseService adresseService;
    @Autowired
    CompteprincipalService compteprincipalService;

    @PostMapping("/enregistrerPointvente")
    public String enregPointvente(@Valid @RequestBody FormEnregPointvente formEnregPointvente,
                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try {
            System.out.println("formUpdatePointvente.getIdEntreprise() == " + formEnregPointvente.getIdEntreprise());
            try {
                Entreprise entrepriseProprietaire =
                        entrepriseService.getEntrepriseById(formEnregPointvente.getIdEntreprise());
            /*
            On va regarder si la denomination sera unique
             */
                if (pointventeService.isDenominationPvUniqueInEntreprise(formEnregPointvente.getDenominationPv(),
                        entrepriseProprietaire) == 1) {
                    System.out.println("on a regarder et on voit que la denomination sera unique dans l'entreprise");
                /*
                Alors la denomination choisi sera unique.
                On enregistre donc son adresse et son compteprincipal
                 */
                    Adresse adressePv = adresseService.saveAdresse(formEnregPointvente.getNumtel1Adr(),
                            formEnregPointvente.getNumtel2Adr(), formEnregPointvente.getNumtel3Adr(),
                            formEnregPointvente.getEmailAdr(), formEnregPointvente.getQuartierAdr(),
                            formEnregPointvente.getVilleAdr(), formEnregPointvente.getPaysAdr(),
                            formEnregPointvente.getPlanlocalisationAdr());

                    Compteprincipal compteprincipalPv =
                            compteprincipalService.saveCompteprincipal(
                                    formEnregPointvente.getSoldeInitialCompteprincipal());
                    try {
                        Pointvente pv = pointventeService.savePointvente(formEnregPointvente.getDescriptionPv(),
                                formEnregPointvente.getDenominationPv(), adressePv, compteprincipalPv,
                                entrepriseProprietaire);
                    /*
                    On va donc une fois le point de vente persister l'associer a son compte de tel sorte
                    qu'on puisse avoir le point de vente a partir du compte car a ce stade c'est l'inverse qui est
                    possible.
                     */
                        try {
                            System.out.println("Lancement de l'association du point de vente au compte");
                            compteprincipalService.AssocierCompteprincipalAPointvente(compteprincipalPv, pv);
                            /*
                            Il reste a ajoute le point de vente ainsi cree a la liste des points de vente de
                            l'entreprise.
                             */
                            System.out.println("Lancement de l'ajout du pointvente a la liste des pv de l'entreprise");
                            entrepriseService.addPointventeToEntreprise(pv,entrepriseProprietaire);
                            return ValeurRetour.enregPointventeSuccess;
                        } catch (UnchangeableProprietaireOfCompteprincipalException e) {
                            System.out.println("Exception au moment de l'association == "+e.getMessage());
                            return ValeurRetour.echecAssociationCompteprincipalAuPointvente;
                        }

                    } catch (DenominationPvNonUniqueInEntrepriseException e) {
                        System.out.println(e.getMessage());
                        return ValeurRetour.pointventeExist;
                    }

                } else {
                    return ValeurRetour.pointventeExist;
                }
            }
            catch (Exception e){
                System.out.println("Exception est== "+e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
        catch (EntrepriseNotFoundException e){
            System.out.println(e.getMessage());
            return ValeurRetour.entrepriseNotExist;
        }

    }

    @RequestMapping(value = "/updateParamPointvente", method = RequestMethod.PATCH)
    public String updateParamPointvente(@Valid @RequestBody FormUpdateParamPointvente formUpdateParamPointvente,
                                        BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try {
            Pointvente pvAModifie = pointventeService.getPointventeById(
                    formUpdateParamPointvente.getIdPointventeAModifie());
            try{
                pointventeService.updateParamPointvente(pvAModifie.getIdPointvente(),
                        formUpdateParamPointvente.getNewDescriptionPv(),
                        formUpdateParamPointvente.getNewDenominationPv());

                return ValeurRetour.updateParamPointventeSuccess;
            }
            catch (Exception e){
                /*
                Ici cela signifie que probablement que l'exception
                DenominationPvNonUniqueInEntrepriseException est lancee
                 */
                return ValeurRetour.updateParamPointventeErreurDenomination;
            }

        }
        catch (Exception e){
            return ValeurRetour.pointventeNotExist;
        }
    }

    @RequestMapping(value = "/updateAdressePointvente", method = RequestMethod.PATCH)
    public String updateAdressePointvente(@Valid @RequestBody FormUpdateAdresse formUpdateAdresse,
                                        BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try {
            Pointvente pvAModifie = pointventeService.getPointventeById(
                    formUpdateAdresse.getIdPropAdresse());
            try{
                pointventeService.updateAdressePointvente(formUpdateAdresse.getIdPropAdresse(),
                        formUpdateAdresse.getNewnumtel1Adr(),  formUpdateAdresse.getNewnumtel2Adr(),
                        formUpdateAdresse.getNewnumtel3Adr(), formUpdateAdresse.getNewemailAdr(),
                        formUpdateAdresse.getNewquartierAdr(), formUpdateAdresse.getNewvilleAdr(),
                        formUpdateAdresse.getNewpaysAdr(), formUpdateAdresse.getNewplanlocalisationAdr());
                return ValeurRetour.updateAdesseSuccess;
            }
            catch (Exception e){
                /*
                AdresseNotFoundException
                 */
                return ValeurRetour.updateAdesseError;
            }
        }
        catch (Exception e){
            return ValeurRetour.pointventeNotExist;
        }
    }

    @RequestMapping(value = "/resetCompteprincipalPointvente", method = RequestMethod.PATCH)
    public String resetCompteprincipalPointvente(FormResetCompteprincipal formResetCompteprincipal,
                                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }

        try {
            Pointvente pvAModifie = pointventeService.getPointventeById(
                    formResetCompteprincipal.getIdPointventeCompteprincipalAReset());
            try{
                pointventeService.resetSoldeCompteprincipal(pvAModifie.getIdPointvente(),
                        formResetCompteprincipal.getNewsoldeespece());
                return ValeurRetour.updateCompteprincipalSuccess;
            }
            catch (Exception e){
                /*
                AdresseNotFoundException
                 */
                return ValeurRetour.updateAdesseError;
            }
        }
        catch (Exception e){
            return ValeurRetour.pointventeNotExist;
        }
    }

    @GetMapping("/getListofPointvente")
    public List<Pointvente> getListofPointvente(@RequestParam(name="ordre", defaultValue="0")int ordre){
        List<Pointvente> listofPointvente = null;
        /***************************************************
         * DenominationPvCroissant=0;
         * DenominationPvDecroissant=1;
         * int PvSigleEntrCroissant=2;
         * PvSigleEntrDecroissant=3;
         ***************************************************/
        listofPointvente = pointventeService.getlistofpointvente(ordre);
        return listofPointvente;
    }

    @GetMapping("/getPageofPointvente")
    public Page<Pointvente> getPageofPointvente(@RequestParam(name="numPage", defaultValue="0")int numPage,
                                                @RequestParam(name="taillePage", defaultValue="1")int taillePage,
                                                @RequestParam(name="ordre", defaultValue="0")int ordre){
        Page<Pointvente> pageofPointvente = null;
        /***************************************************
         * DenominationPvCroissant=0;
         * DenominationPvDecroissant=1;
         * int PvSigleEntrCroissant=2;
         * PvSigleEntrDecroissant=3;
         ***************************************************/
        pageofPointvente = pointventeService.getpageofpointvente(numPage, taillePage, ordre);
        return pageofPointvente;
    }

}

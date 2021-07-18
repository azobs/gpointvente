package org.c2psi.gpointvente.controllers.produit;

import org.c2psi.gpointvente.constantes.TypeArrivage;
import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.c2psi.gpointvente.entities.produit.ArrivageProduitformate;
import org.c2psi.gpointvente.entities.produit.Arrivageparespece;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.ArrivageProduitformateException;
import org.c2psi.gpointvente.exceptions.produit.QuantiteProduitIndisponibleException;
import org.c2psi.gpointvente.exceptions.produit.RegleconversionNotFoundException;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregArrivageNormalEspece;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregArrivageParDeAndRecomposition;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregArrivagePonctuelEspece;
import org.c2psi.gpointvente.services.facture.factureappro.FactureapproespeceService;
import org.c2psi.gpointvente.services.produit.ArrivageProduitformateService;
import org.c2psi.gpointvente.services.produit.ArrivageparespeceService;
import org.c2psi.gpointvente.services.produit.ProduitFormateUniteService;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ArrivageProduitController {
    @Autowired
    FactureapproespeceService factureapproespeceService;
    @Autowired
    ProduitFormateUniteService produitFormateUniteService;
    @Autowired
    PointventeService pointventeService;
    @Autowired
    ArrivageProduitformateService arrivageProduitformateService;
    @Autowired
    ArrivageparespeceService arrivageparespeceService;

    @PostMapping("/enregistrerArrivageNormalEspece")
    public String enregArrivageNormalEspece(@Valid @RequestBody
                                                        FormEnregArrivageNormalEspece
                                                        formEnregArrivageNormalEspece,
                                            BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }
        /********************************************************
         * Pour enregistrer un arrivage normal espece il faut:
         *  Recuperer la factureapproespece associe (idfactureapproespece)
         *  Enregistrer et recuperer l'arrivageproduitformate (dateheurelivraison, dateperemption
         *  et dateseuilperemption si le produit est perissable, typeArrivage, idproduitformateunite,
         *  idPointvente)
         *  et a partir de cet arrivageproduitformate enregistrer arrivageparespece
         */
        Optional<Factureapproespece> optionalFactureapproespece =
                factureapproespeceService.findFactureapproespeceByIdFactureapproespece(
                        formEnregArrivageNormalEspece.getIdFactureapproespece());
        if(!optionalFactureapproespece.isPresent()){
            return ValeurRetour.factureapproespeceNotFound;
        }
        Optional<ProduitFormateUnite> optionalProduitFormateUnite =
                produitFormateUniteService.getProduitFormateUniteByIdPFU(
                        formEnregArrivageNormalEspece.getIdproduitFormateUnite());
        if(!optionalProduitFormateUnite.isPresent()){
            return ValeurRetour.produitformateuniteNotFound;
        }
        Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                formEnregArrivageNormalEspece.getIdPointvente()));
        if(!optionalPointvente.isPresent()){
            return ValeurRetour.pointventeNotFound;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date datePeremption;
        Date dateseuilPeremption;
        Date dateheurelivraisonarrivage;
        Date dateheurefacturation;

        try {
            datePeremption = sdf2.parse(formEnregArrivageNormalEspece.getDateperemption());
            dateseuilPeremption = sdf2.parse(formEnregArrivageNormalEspece.getDateseuilperemption());
            dateheurelivraisonarrivage = sdf1.parse(formEnregArrivageNormalEspece.getDateheurelivraisonArrivage());

            /******************
             * Si on est ici alors tout est bon avec les identifiants et les dates
             */
            Factureapproespece factureapproespece = optionalFactureapproespece.get();
            ProduitFormateUnite produitFormateUnite = optionalProduitFormateUnite.get();
            Pointvente pointvente = optionalPointvente.get();
            dateheurefacturation = factureapproespece.getFactureapproAssocie().getDateFactureappro();

            try {
                ArrivageProduitformate arrivageProduitformate =
                        arrivageProduitformateService.saveArrivageNormalEspeceProduitformate(
                                dateheurelivraisonarrivage, dateheurefacturation, datePeremption,
                                dateseuilPeremption, produitFormateUnite, pointvente);
                /***************************************************************
                 * Une fois qu'on a l'arrivage du produit formate on
                 * peut enregistrer son sous type qui est l'arrivageparespece
                 */
                Arrivageparespece arrivageparespece = arrivageparespeceService.saveArrivageparespeceNormal(
                        formEnregArrivageNormalEspece.getQuantitelivree(),
                        formEnregArrivageNormalEspece.getPrixachatunitaire(), arrivageProduitformate,
                        factureapproespece);
                /********************
                 * Il faut maintenant ajouter cet arrivageparespece a la
                 * liste des arrivages de la factureapproespece
                 */
                factureapproespeceService.addArrivageparespeceToFactureapproespece(arrivageparespece,
                        factureapproespece);
                /******
                 Une fois l'arrivageparespece enregistre, on doit mettre a jour la quantite en stock
                 du produit associe.
                 */
                ProduitFormateUnite produitFormateUnite1 = arrivageProduitformate.getProduitformateConcerne();
                int qteAAjoute = arrivageparespece.getQuantitelivre();
                int nouvelQte = qteAAjoute + produitFormateUnite1.getQuantiteEnStock();
                produitFormateUnite1.setQuantiteEnStock(nouvelQte);
                produitFormateUniteService.saveProduitFormateUnite(produitFormateUnite1);
                return ValeurRetour.arrivageNormalEspeceEnregSucess;
            } catch (ArrivageProduitformateException e) {
                e.printStackTrace();
                return ValeurRetour.produitformateuniteMalFormed;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return ValeurRetour.errorDateMalFormed;
        }
    }

    @PostMapping("/enregistrerArrivagePonctuelEspece")
    public String enregArrivagePonctuelEspece(@Valid @RequestBody
                                                      FormEnregArrivagePonctuelEspece
                                                      formEnregArrivagePonctuelEspece,
                                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }

        /**********************************************************************************************
         * La seul difference avec l'arrivage normal est qu'ici il n'ya pas de facture
         * Pour enregistrer un arrivage ponctuel espece il faut:
         *  Recuperer la factureapproespece associe (idfactureapproespece)
         *  Enregistrer et recuperer l'arrivageproduitformate (dateheurelivraison, dateperemption
         *  et dateseuilperemption si le produit est perissable, typeArrivage, idproduitformateunite,
         *  idPointvente)
         *  et a partir de cet arrivageproduitformate enregistrer arrivageparespece
         */
        Optional<ProduitFormateUnite> optionalProduitFormateUnite =
                produitFormateUniteService.getProduitFormateUniteByIdPFU(
                        formEnregArrivagePonctuelEspece.getIdproduitFormateUnite());
        if(!optionalProduitFormateUnite.isPresent()){
            return ValeurRetour.produitformateuniteNotFound;
        }
        Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                formEnregArrivagePonctuelEspece.getIdPointvente()));
        if(!optionalPointvente.isPresent()){
            return ValeurRetour.pointventeNotFound;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date datePeremption;
        Date dateseuilPeremption;
        Date dateheurelivraisonarrivage;
        try {
            datePeremption = sdf2.parse(formEnregArrivagePonctuelEspece.getDateperemption());
            dateseuilPeremption = sdf2.parse(formEnregArrivagePonctuelEspece.getDateseuilperemption());
            dateheurelivraisonarrivage = sdf1.parse(formEnregArrivagePonctuelEspece.getDateheurelivraisonArrivage());

            /******************
             * Si on est ici alors tout est bon avec les identifiants et les dates
             */
            ProduitFormateUnite produitFormateUnite = optionalProduitFormateUnite.get();
            Pointvente pointvente = optionalPointvente.get();

            try {
                ArrivageProduitformate arrivageProduitformate =
                        arrivageProduitformateService.saveArrivagePonctuelEspeceProduitformate(
                                dateheurelivraisonarrivage,  datePeremption,
                                dateseuilPeremption, produitFormateUnite, pointvente);
                /***************************************************************
                 * Une fois qu'on a l'arrivage du produit formate on
                 * peut enregistrer son sous type qui est l'arrivageparespece
                 */
                Arrivageparespece arrivageparespece = arrivageparespeceService.saveArrivageparespecePonctuel(
                        formEnregArrivagePonctuelEspece.getQuantitelivree(),
                        formEnregArrivagePonctuelEspece.getPrixachatunitaire(), arrivageProduitformate);

                /******
                Une fois l'arrivageparespece enregistre, on doit mettre a jour la quantite en stock
                du produit associe.
                 */
                ProduitFormateUnite produitFormateUnite1 = arrivageProduitformate.getProduitformateConcerne();
                int qteAAjoute = arrivageparespece.getQuantitelivre();
                int nouvelQte = qteAAjoute + produitFormateUnite1.getQuantiteEnStock();
                produitFormateUnite1.setQuantiteEnStock(nouvelQte);
                produitFormateUniteService.saveProduitFormateUnite(produitFormateUnite1);
                return ValeurRetour.arrivagePonctuelEspeceEnregSucess;
            } catch (ArrivageProduitformateException e) {
                e.printStackTrace();
                return ValeurRetour.produitformateuniteMalFormed;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return ValeurRetour.errorDateMalFormed;
        }
    }

    @PostMapping("/enregistrerArrivageParDecomposition")
    public String enregArrivageParDecomposition(@Valid @RequestBody FormEnregArrivageParDeAndRecomposition formEnregArrivageParDeAndRecomposition,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }

        Optional<ProduitFormateUnite> optionalProduitFormateUniteSource =
                produitFormateUniteService.getProduitFormateUniteByIdPFU(
                        formEnregArrivageParDeAndRecomposition.getIdproduitFormateUniteSource());
        if(!optionalProduitFormateUniteSource.isPresent()){
            System.out.println("getIdproduitFormateUniteSource == "+formEnregArrivageParDeAndRecomposition.getIdproduitFormateUniteSource());
            return ValeurRetour.produitformateuniteNotFound;
        }
        Optional<ProduitFormateUnite> optionalProduitFormateUniteDestination =
                produitFormateUniteService.getProduitFormateUniteByIdPFU(
                        formEnregArrivageParDeAndRecomposition.getIdproduitFormateUniteDestination());
        if(!optionalProduitFormateUniteDestination.isPresent()){
            System.out.println("getIdproduitFormateUniteDestination == "+formEnregArrivageParDeAndRecomposition.getIdproduitFormateUniteDestination());
            return ValeurRetour.produitformateuniteNotFound;
        }
        Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                formEnregArrivageParDeAndRecomposition.getIdPointvente()));
        if(!optionalPointvente.isPresent()){
            return ValeurRetour.pointventeNotFound;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date datePeremption;
        Date dateseuilPeremption;
        Date dateheureDeAndRecomposition;
        try{
            dateheureDeAndRecomposition = sdf1.parse(sdf1.format(new Date()));
            datePeremption = sdf2.parse(formEnregArrivageParDeAndRecomposition.getDateperemption());
            dateseuilPeremption = sdf2.parse(formEnregArrivageParDeAndRecomposition.getDateseuilperemption());
            /******************
             * Si on est ici alors tout est bon avec les identifiants et les dates
             */
            ProduitFormateUnite produitFormateUniteSource = optionalProduitFormateUniteSource.get();
            ProduitFormateUnite produitFormateUniteDestination = optionalProduitFormateUniteDestination.get();
            Pointvente pointvente = optionalPointvente.get();
            try {
                ArrivageProduitformate arrivageProduitformate =
                        arrivageProduitformateService.saveArrivagePonctuelEspeceProduitformate(
                                dateheureDeAndRecomposition, datePeremption,
                                dateseuilPeremption, produitFormateUniteDestination, pointvente);
                ///////////////////////////////////////
                /***************************************************************
                 * Une fois qu'on a l'arrivage du produit formate on
                 * peut enregistrer son sous type qui est l'arrivageparespece
                 */
                Arrivageparespece arrivagepardecomposition =
                        arrivageparespeceService.saveArrivageparespeceDecomposition(
                                produitFormateUniteSource, produitFormateUniteDestination,
                                arrivageProduitformate,
                                formEnregArrivageParDeAndRecomposition.getQuantiteADeOrRecomposer());

                /******
                 Une fois l'arrivageparespece enregistre, on doit mettre a jour la quantite en stock
                 du produit associe.
                 */
                ProduitFormateUnite produitFormateUnite1 = arrivageProduitformate.getProduitformateConcerne();
                int qteAAjoute = arrivagepardecomposition.getQuantitelivre();
                int nouvelQte = qteAAjoute + produitFormateUnite1.getQuantiteEnStock();
                produitFormateUnite1.setQuantiteEnStock(nouvelQte);
                produitFormateUniteService.saveProduitFormateUnite(produitFormateUnite1);
                return ValeurRetour.arrivageParDecompositionEnregSucess;
                ///////////////////////////////////////
            }
            catch (ArrivageProduitformateException e) {
                e.printStackTrace();
                return ValeurRetour.produitformateuniteMalFormed;
            } catch (QuantiteProduitIndisponibleException e) {
                e.printStackTrace();
                return ValeurRetour.quantiteproduitADecomposerNotAvailable;
            } catch (RegleconversionNotFoundException e) {
                e.printStackTrace();
                return ValeurRetour.regleconversionEntreProduitNotAvailable;
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
            return ValeurRetour.errorDateMalFormed;
        }
    }

    @PostMapping("/enregistrerArrivageParRecomposition")
    public String enregArrivageParRecomposition(@Valid @RequestBody FormEnregArrivageParDeAndRecomposition formEnregArrivageParDeAndRecomposition,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }

        Optional<ProduitFormateUnite> optionalProduitFormateUniteSource =
                produitFormateUniteService.getProduitFormateUniteByIdPFU(
                        formEnregArrivageParDeAndRecomposition.getIdproduitFormateUniteSource());
        if(!optionalProduitFormateUniteSource.isPresent()){
            return ValeurRetour.produitformateuniteNotFound;
        }
        Optional<ProduitFormateUnite> optionalProduitFormateUniteDestination =
                produitFormateUniteService.getProduitFormateUniteByIdPFU(
                        formEnregArrivageParDeAndRecomposition.getIdproduitFormateUniteDestination());
        if(!optionalProduitFormateUniteDestination.isPresent()){
            return ValeurRetour.produitformateuniteNotFound;
        }
        Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                formEnregArrivageParDeAndRecomposition.getIdPointvente()));
        if(!optionalPointvente.isPresent()){
            return ValeurRetour.pointventeNotFound;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date datePeremption;
        Date dateseuilPeremption;
        Date dateheureDeAndRecomposition;
        try{
            dateheureDeAndRecomposition = sdf1.parse(sdf1.format(new Date()));
            datePeremption = sdf2.parse(formEnregArrivageParDeAndRecomposition.getDateperemption());
            dateseuilPeremption = sdf2.parse(formEnregArrivageParDeAndRecomposition.getDateseuilperemption());
            /******************
             * Si on est ici alors tout est bon avec les identifiants et les dates
             */
            ProduitFormateUnite produitFormateUniteSource = optionalProduitFormateUniteSource.get();
            ProduitFormateUnite produitFormateUniteDestination = optionalProduitFormateUniteDestination.get();
            Pointvente pointvente = optionalPointvente.get();
            try {
                ArrivageProduitformate arrivageProduitformate =
                        arrivageProduitformateService.saveArrivagePonctuelEspeceProduitformate(
                                dateheureDeAndRecomposition, datePeremption,
                                dateseuilPeremption, produitFormateUniteDestination, pointvente);
                ///////////////////////////////////////
                /***************************************************************
                 * Une fois qu'on a l'arrivage du produit formate on
                 * peut enregistrer son sous type qui est l'arrivageparespece
                 */
                Arrivageparespece arrivageparrecomposition =
                        arrivageparespeceService.saveArrivageparespeceRecomposition(
                                produitFormateUniteSource, produitFormateUniteDestination,
                                arrivageProduitformate,
                                formEnregArrivageParDeAndRecomposition.getQuantiteADeOrRecomposer());

                /******
                 Une fois l'arrivageparespece enregistre, on doit mettre a jour la quantite en stock
                 du produit associe.
                 */
                ProduitFormateUnite produitFormateUnite1 = arrivageProduitformate.getProduitformateConcerne();
                int qteAAjoute = arrivageparrecomposition.getQuantitelivre();
                int nouvelQte = qteAAjoute + produitFormateUnite1.getQuantiteEnStock();
                produitFormateUnite1.setQuantiteEnStock(nouvelQte);
                produitFormateUniteService.saveProduitFormateUnite(produitFormateUnite1);
                return ValeurRetour.arrivageParRecompositionEnregSucess;
                ///////////////////////////////////////
            }
            catch (ArrivageProduitformateException e) {
                e.printStackTrace();
                return ValeurRetour.produitformateuniteMalFormed;
            } catch (QuantiteProduitIndisponibleException e) {
                e.printStackTrace();
                return ValeurRetour.quantiteproduitARecomposerNotAvailable;
            } catch (RegleconversionNotFoundException e) {
                e.printStackTrace();
                return ValeurRetour.regleconversionEntreProduitNotAvailable;
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
            return ValeurRetour.errorDateMalFormed;
        }
    }


}

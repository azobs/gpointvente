package org.c2psi.gpointvente.controllers.produit;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.prix.Prixdebase;
import org.c2psi.gpointvente.entities.prix.Prixspecial;
import org.c2psi.gpointvente.entities.produit.*;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.prix.DeviseNotFoundException;
import org.c2psi.gpointvente.exceptions.prix.PrixdebaseMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.FormatproduitNotFoundException;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateNonUniqueException;
import org.c2psi.gpointvente.exceptions.produit.UniteproduitNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.DesignationProduitNonUniqueInFamilleException;
import org.c2psi.gpointvente.exceptions.pv.PointventeNotFoundException;
import org.c2psi.gpointvente.forms.formsEnreg.prix.FormEnregPrixspecial;
import org.c2psi.gpointvente.forms.formsEnreg.produit.FormEnregProduitToPointvente;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.c2psi.gpointvente.services.prix.DeviseService;
import org.c2psi.gpointvente.services.prix.PrixdebaseService;
import org.c2psi.gpointvente.services.prix.PrixspecialService;
import org.c2psi.gpointvente.services.produit.*;
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
public class ProduitFormateUniteController {
    @Autowired
    PointventeService pointventeService;
    @Autowired
    FamilleService familleService;
    @Autowired
    ProduitService produitService;
    @Autowired
    FormatproduitService formatproduitService;
    @Autowired
    ProduitFormateService produitFormateService;
    @Autowired
    UniteproduitService uniteproduitService;
    @Autowired
    DeviseService deviseService;
    @Autowired
    PrixdebaseService prixdebaseService;
    @Autowired
    ComptecapsulePvService comptecapsulePvService;
    @Autowired
    ProduitFormateUniteService produitFormateUniteService;
    @Autowired
    PrixspecialService prixspecialService;

    @PostMapping("/enregistrerProduitInPointvente")
    public String enregistrerProduit(@Valid @RequestBody FormEnregProduitToPointvente formEnregProduitToPointvente,
                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }

        try {
            /***************************************************************************************
             * Pour enregistrer un produit qui sera vendu dans un pointvente il faut:
             *  Enregistrer le produit (ProduitService)
             *  Recuperer le format du produit précise
             *  Enregistrer le produitformate grace au format recuperer (ProduitFormateService)
             *  recuperer l'unite du produit précise
             *  Enregistrer le prix de base sans préciser le produit associe (PrixdebaseService)
             *  Enregistrer le produitFormateUnite (ProduitFormateUniteService)
             *  Avec le produitformateunite mettre a jour le prix de base précédement enregistre
             *  Retourner enfin le produitformateunite qu'on a enregistre
             ***************************************************************************************/

            /*
             *Enregistrement du produit
             */
            //On commence tout par recuperer le point de vente pour lequel tout est effectue
            Optional<Pointvente> optionalPointvente = Optional.ofNullable(pointventeService.getPointventeById(
                    formEnregProduitToPointvente.getIdPointvente()));
            if(optionalPointvente.isPresent()){
                Pointvente pointvente = optionalPointvente.get();
                //Il faut recuperer la famille du produit
                Famille familleproduit = familleService.getFamilleByIdFamille(formEnregProduitToPointvente.getIdFamilleProduit());
                //On enregistre le produit
                Produit produitAssocie = produitService.saveProduit(formEnregProduitToPointvente.getDesignationProduitFR(),
                        formEnregProduitToPointvente.getDesignationProduitEN(), formEnregProduitToPointvente.getAliasProduitFR(),
                        formEnregProduitToPointvente.getAliasProduitEN(), formEnregProduitToPointvente.getDescriptionProduitFR(),
                        formEnregProduitToPointvente.getDescriptionProduitEN(), formEnregProduitToPointvente.getPerissable(),
                        familleproduit);
                /*
                Il faut ajouter le produit cree a la liste des produits de la famille indiquee
                 */
                familleService.addProduitToFamille(produitAssocie, familleproduit);

                //On recupere le format qui a ete utilise pour formate le produit
                Optional<Formatproduit> optionalFormatproduit = formatproduitService.getFormatproduitByIdFormatproduit(
                        formEnregProduitToPointvente.getIdFormat());
                if (optionalFormatproduit.isPresent()) {
                    //Avec le format on peut formate le produit pour avoir le ProduitFormate
                    ProduitFormate produitFormate = produitFormateService.saveProduitFormate(produitAssocie,
                            optionalFormatproduit.get(), new Date(), formEnregProduitToPointvente.getPhotoPF());
                    /*
                     *Il faut ajouter ce produitformate (produitconditionne) a la liste des conditionnements du produit.
                     * Il s'agit de la liste de tous les produitformate issu d'un produit. Autrement dit tous les conditionnements
                     * utilise pour le produit dans le point de vente.
                     */
                    produitService.addProduitFormateToProduit(produitFormate, produitAssocie);
                    //Avec le produit formate on va recuperer l'unite
                    Optional<Uniteproduit> optionalUniteproduit = Optional.ofNullable(
                            uniteproduitService.getUniteproduitByIdUniteInPointvente(
                                    formEnregProduitToPointvente.getIdUniteproduit(), pointvente));
                    if (optionalUniteproduit.isPresent()) {
                        Uniteproduit uniteproduit = optionalUniteproduit.get();
                        //On connait l'unite du produit et il faut la devise precisee
                        Optional<Devise> optionalDevise = deviseService.getDeviseByIdDevise(
                                formEnregProduitToPointvente.getIdDeviseprix());
                        if(optionalDevise.isPresent()){
                            Devise devise = optionalDevise.get();
                            if(devise.getPointvente().getIdPointvente().equalsIgnoreCase(pointvente.getIdPointvente())){
                                //On a la devise et on peut donc enregistrer le prixdebase
                                Prixdebase prixdebase = prixdebaseService.savePrixdebase(
                                        formEnregProduitToPointvente.getPrixdachatmoyen(),
                                        formEnregProduitToPointvente.getPrixdegrosmoyen(),
                                        formEnregProduitToPointvente.getPrixdesemigrosmoyen(),
                                        formEnregProduitToPointvente.getPrixdedetailmoyen(),
                                        formEnregProduitToPointvente.getRistourneattendu(),
                                        formEnregProduitToPointvente.getPrecompteattendu(),
                                        formEnregProduitToPointvente.getFormataffichageprix(), devise);
                                //On a ici le prixdebase mais qui n'est pas encore associe avec le produitFormateUnite
                                //Pour cela il faut le comptecapsule associe
                                ComptecapsulePv ccPv = comptecapsulePvService.saveComptecapsulePv(
                                        formEnregProduitToPointvente.getNbrecapsuleInitial());

                                ProduitFormateUnite produitFormateUnite =
                                        produitFormateUniteService.saveProduitFormateUnite(
                                                formEnregProduitToPointvente.getSeuilqte(),
                                                formEnregProduitToPointvente.getLimitebassesemigros(),
                                                formEnregProduitToPointvente.getLimitebassegros(),
                                                formEnregProduitToPointvente.getCommentairePFU(),
                                                formEnregProduitToPointvente.getCodePFU(),
                                                produitFormate, uniteproduit, pointvente, prixdebase, ccPv,
                                                new Date());



                                /*
                                 *On va ajouter ce produit a la liste des produits a vendre du point de vente
                                 */
                                pointventeService.addProduitFormateUniteToPointvente(produitFormateUnite, pointvente);

                                return ValeurRetour.produitInPointventeEnregSuccess;
                            }
                            else{
                                throw new DeviseNotFoundException("Exception levee: La devise precise n'est pas une " +
                                        "devise du point de vente precisee");
                            }
                        }
                        else{
                            throw new DeviseNotFoundException("Exception levee: La devise precise n'existe pas " +
                                    "dans le système");
                        }
                    }
                    else {
                        throw new UniteproduitNotFoundException("Exception levee : L'unite precise n'existe " +
                                "pas dans le système");
                    }
                }
                else {
                    throw new FormatproduitNotFoundException("Exception levee: Le format de produit précise " +
                            "n'existe pas dans le système");
                }
            }
            else{
                throw new PointventeNotFoundException("Exception levee: L'identifiant du point de vente precise " +
                        "ne correspond a aucun point de vente dans le système");
            }

        } catch (DesignationProduitNonUniqueInFamilleException e){
            System.out.println(e.getMessage());
            return ValeurRetour.designationProduitNonUniqueInFamille;
        }
        catch (ProduitFormateNonUniqueException e){
            System.out.println(e.getMessage());
            return ValeurRetour.produitFormateNonUniqueInPointvente;
        }
        catch (ProduitFormateMalFormedException e){
            System.out.println(e.getMessage());
            return ValeurRetour.produitFormateMalFormedInPointvente;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ValeurRetour.erreurInconue;
        }
    }

    @PostMapping("/enregistrerPrixspecialProduit")
    public String enregistrerPrixspecialProduit(@Valid @RequestBody FormEnregPrixspecial formEnregPrixspecial,
                                                BindingResult bindingResult ){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        /***************************************************************************************
         * Pour enregistrer un prixspecial associe a un prixdebase il faut:
         *  Le ProduitFormateUnite concerne par le prixspecial
         *  A partir de ce produit il faut recuperer son prixdebase
         *  enregistrer le prixspecial au systeme
         *  Associe le prixspecial au prixdebase du produit
         ***************************************************************************************/
        Optional<ProduitFormateUnite> optionalProduitFormateUnite =
                produitFormateUniteService.getProduitFormateUniteByIdPFU(
                        formEnregPrixspecial.getIdProduitFormateUnite());
        Optional<Devise> optionalDevise = deviseService.getDeviseByIdDevise(
                formEnregPrixspecial.getIdDevisePrix());

        if(optionalProduitFormateUnite.isPresent()){
            ProduitFormateUnite produitFormateUniteConcerne = optionalProduitFormateUnite.get();
            if(optionalDevise.isPresent()) {
                Devise devisePrix = optionalDevise.get();
                try {
                    Prixspecial prixspecialEnreg = prixspecialService.savePrixspecial(
                            formEnregPrixspecial.getPrixdachatmoyen(),
                            formEnregPrixspecial.getPrixdegrosmoyen(), formEnregPrixspecial.getPrixdesemigrosmoyen(),
                            formEnregPrixspecial.getPrixdedetailmoyen(), formEnregPrixspecial.getRistourneattendu(),
                            formEnregPrixspecial.getPrecompteattendu(), formEnregPrixspecial.getLimitebassegros(),
                            formEnregPrixspecial.getLimitebassesemigros(), produitFormateUniteConcerne, devisePrix);
                /*
                On va ajouter le prixspecial a la liste des prixspecial du prixdebase associe
                 */
                    prixdebaseService.addPrixspecialToPrixdebase(prixspecialEnreg,
                            produitFormateUniteConcerne.getPrixdebase());
                    return ValeurRetour.prixspecialSavedSuccess;
                } catch (PrixdebaseMalFormedException e) {
                    System.out.println("Exception levee: " + e.getMessage());
                    return ValeurRetour.prixspecialMalFormed;
                }
            }
            else{
                return ValeurRetour.devisePrixspecialNotExist;
            }
        }
        else{
            return ValeurRetour.produitformateuniteNotExist;
        }
    }

}

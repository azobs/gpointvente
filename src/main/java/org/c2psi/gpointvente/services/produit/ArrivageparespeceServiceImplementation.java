package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.dao.produit.ArrivageparespeceRepository;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.c2psi.gpointvente.entities.produit.*;
import org.c2psi.gpointvente.exceptions.facture.FactureapproespeceNotFoundException;
import org.c2psi.gpointvente.exceptions.produit.ArrivageProduitformateNotFoundException;
import org.c2psi.gpointvente.exceptions.produit.QuantiteProduitIndisponibleException;
import org.c2psi.gpointvente.exceptions.produit.RegleconversionNotFoundException;
import org.c2psi.gpointvente.services.facture.factureappro.FactureapproespeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArrivageparespeceServiceImplementation implements ArrivageparespeceService {
    @Autowired
    ArrivageparespeceRepository arrivageparespeceRepository;
    @Autowired
    FactureapproespeceService factureapproespeceService;
    @Autowired
    ArrivageProduitformateService arrivageProduitformateService;
    @Autowired
    ProduitFormateUniteService produitFormateUniteService;
    @Autowired
    UniteproduitService uniteproduitService;


    @Override
    public int isFactureapproespeceValide(Factureapproespece factureapproespece) {
        Optional<Factureapproespece> optionalFactureapproespece =
                factureapproespeceService.findFactureapproespeceByIdFactureapproespece(
                        factureapproespece.getIdFactureapproespece());
        return optionalFactureapproespece.isPresent()?1:0;
    }

    @Override
    public int isArrivageProduitformateValide(ArrivageProduitformate arrivageProduitformate) {
        Optional<ArrivageProduitformate> optionalArrivageProduitformate =
                arrivageProduitformateService.findArrivageProduitformateByIdArrivageProduitformate(
                        arrivageProduitformate.getIdArrivageProduitFormate());
        return optionalArrivageProduitformate.isPresent()?1:0;
    }

    @Override
    public Optional<Arrivageparespece> findArrivageparespeceByIdArrivageparespece(String idArrivageparespece) {
        return arrivageparespeceRepository.findArrivageparespeceByIdArrivageparespece(idArrivageparespece);
    }

    @Override
    public Arrivageparespece saveArrivageparespeceNormal(int quantitelivree, double prixunitaire,
                                                         ArrivageProduitformate arrivageProduitformate,
                                                         Factureapproespece factureapproespece) {

        Arrivageparespece arrivageparespeceAEnreg = new Arrivageparespece();
        arrivageparespeceAEnreg.setArrivageProduitformate(arrivageProduitformate);
        arrivageparespeceAEnreg.setFactureapproespece(factureapproespece);
        arrivageparespeceAEnreg.setPrixachatunitaire(prixunitaire);
        arrivageparespeceAEnreg.setQuantitelivre(quantitelivree);

        return arrivageparespeceRepository.save(arrivageparespeceAEnreg);
    }

    @Override
    public Arrivageparespece saveArrivageparespecePonctuel(int quantitelivree, double prixunitaire,
                                                           ArrivageProduitformate arrivageProduitformate) {
        Arrivageparespece arrivageparespeceponctuelAEnreg = new Arrivageparespece();
        arrivageparespeceponctuelAEnreg.setArrivageProduitformate(arrivageProduitformate);
        arrivageparespeceponctuelAEnreg.setPrixachatunitaire(prixunitaire);
        arrivageparespeceponctuelAEnreg.setQuantitelivre(quantitelivree);

        return arrivageparespeceRepository.save(arrivageparespeceponctuelAEnreg);
    }

    @Override
    public Arrivageparespece saveArrivageparespeceDecomposition(
            ProduitFormateUnite produitFormateUniteSource,
            ProduitFormateUnite produitFormateUniteDestination, ArrivageProduitformate arrivageProduitformate,
            int quantiteADecomposer )
            throws QuantiteProduitIndisponibleException, RegleconversionNotFoundException {
        /****************************************************************************************************
         * Il s'agit ici de decomposer une quantite du produit source en produit destination. Donc le
         * on va se servir des règles de conversion entre les unités des differents produits pour
         * effectuer cette decomposition.
         * La quantite du produit source à decomposer sortira du stock (la quantite en stock sera diminuer)
         * tandis que le total de produit destination obtenu sera ajouter à la quantite de produit en stock
         * du produit destination.
         * Cette decomposition n'est donc possible que si la quantiteADecomposer est inférieur ou égale à
         * la quantité en stock du produit source.
         * De plus, une règle de conversion entre les unites de vente du produit source et du produit
         * destination doit existe. Cette règle doit avoir comme unite multiple l'unite de vente du produit
         * source et comme unite sous multiple celle du produit destination
         *****************************************************************************************************/
        if(!produitFormateUniteService.isQuantiteProduitDisponible(produitFormateUniteSource,
                quantiteADecomposer)){
            throw new QuantiteProduitIndisponibleException("Exception levee: la quantite de produit que vous " +
                    "voulez decomposer n'est pas disponible en stock");
        }
        Uniteproduit uniteproduitMultiple = produitFormateUniteSource.getUnitePFU();
        Uniteproduit uniteproduitSousmultiple = produitFormateUniteDestination.getUnitePFU();
        List<RegleconversionUnite> listofRegleconversionUnite = uniteproduitService.
                findListofRegleAssociantUnite(uniteproduitMultiple, uniteproduitSousmultiple);
        RegleconversionUnite regleconversionAUtiliser = null;
        if(listofRegleconversionUnite.size()<=0){
            throw new RegleconversionNotFoundException("Exception levee: Aucune de regle de coonversion " +
                    "liant les unites n'existe dans le système donc la decomposition est impossible");
        }
        regleconversionAUtiliser = listofRegleconversionUnite.get(0);
        /****************************************************************
         * On va retirer la quantite de produit source du stock
         */
        int nouvelleQuantiteProduitsource = produitFormateUniteSource.getQuantiteEnStock()-quantiteADecomposer;
        produitFormateUniteSource.setQuantiteEnStock(nouvelleQuantiteProduitsource);
        produitFormateUniteService.saveProduitFormateUnite(produitFormateUniteSource);
        /*****************************************************************************
         * On calcule la quantite de produit destination a ajouter au stock
         */
        int quantiteProduitdestinationAAjouter =
                quantiteADecomposer * regleconversionAUtiliser.getFacteurconversion();
        double prixunitaire = produitFormateUniteDestination.getPrixdebase().getPrixdachatmoyen();

        Arrivageparespece arrivagepardecompositionAEnreg = new Arrivageparespece();
        arrivagepardecompositionAEnreg.setArrivageProduitformate(arrivageProduitformate);
        arrivagepardecompositionAEnreg.setPrixachatunitaire(prixunitaire);
        arrivagepardecompositionAEnreg.setQuantitelivre(quantiteProduitdestinationAAjouter);

        return arrivageparespeceRepository.save(arrivagepardecompositionAEnreg);
    }

    @Override
    public Arrivageparespece saveArrivageparespeceRecomposition(
            ProduitFormateUnite produitFormateUniteSource,
            ProduitFormateUnite produitFormateUniteDestination,
            ArrivageProduitformate arrivageProduitformate, int quantiteARecomposer)
            throws QuantiteProduitIndisponibleException, RegleconversionNotFoundException {
        /****************************************************************************************************
         * Il s'agit ici de recomposer une unite du produit destination. Pour cela, on va chercher la regle
         * de conversion qui lie les 2 produits en jeu et qui a comme produit multiple le produit de destination
         * et comme produit sous multiple le produit source. Ainsi, on sait combien d'unite du produit source
         * faut il avoir pour construire une unite du produit destination. A partir de cette regle (le facteur
         * de conversion), on
         * va vérifier que le stock de produit source est conséquemment fourni. Sinon une exception est générée.
         * Une fois le stock fourni, cette quantite (celle qui correspond au facteur de conversion) est débité
         * du stock du produit source puis un arrivage d'une unite et une seule unite du produit de destination
         * est ajouté en stock. La recomposition est ainsi faite.
         *****************************************************************************************************/
        Uniteproduit uniteproduitMultiple = produitFormateUniteDestination.getUnitePFU();
        Uniteproduit uniteproduitSousmultiple = produitFormateUniteSource.getUnitePFU();
        List<RegleconversionUnite> listofRegleconversionUnite = uniteproduitService.
                findListofRegleAssociantUnite(uniteproduitMultiple, uniteproduitSousmultiple);
        RegleconversionUnite regleconversionAUtiliser = null;
        if(listofRegleconversionUnite.size()<=0){
            throw new RegleconversionNotFoundException("Exception levee: Aucune de regle de coonversion " +
                    "liant les unites n'existe dans le système donc la decomposition est impossible");
        }
        regleconversionAUtiliser = listofRegleconversionUnite.get(0);
        /******************************************************************************************************
         * A partir de la regle il faut calculer la quantite du produit source qu'il faudra pour
         * construire le produit de destination. En effet, si il faut obtenir "quantiteARecomposer" du
         * produit de destination alors il faut qu'en stock il y a "quantiteARecomposer" * "facteur de conversion"
         * de la regle de conversion liant les unites des 2 produits.
         */
        int qteNecessaire = quantiteARecomposer * regleconversionAUtiliser.getFacteurconversion();
        if(!produitFormateUniteService.isQuantiteProduitDisponible(produitFormateUniteSource,
                qteNecessaire)){
            throw new QuantiteProduitIndisponibleException("Exception levee: la quantite de produit necessaire " +
                    "pour que la recomposition de la quantite de produit destination voulu n'est pas suffisante");
        }
        /************************************************************************************************
         * Si on est ici alors la quantite est disponible et on peut continuer avec la reconstitution
         * On va deja retirer du stock la quantite du produit source qu'on va utiliser pour reconstituer
         * la quantite voulu du produit de destination
         */
        int qteRestanteDuproduitSource = produitFormateUniteSource.getQuantiteEnStock() - qteNecessaire;
        produitFormateUniteSource.setQuantiteEnStock(qteRestanteDuproduitSource);
        produitFormateUniteService.saveProduitFormateUnite(produitFormateUniteSource);

        /*********************************************************************************************
         * Maintenant on va ajouter en stock la qute du produit destination. car ici on a deja sorti
         * du stock la quantite de produit source qu'on va utiliser pour fabriquer ou reconstituer
         * le produit de destination
         */
        double prixunitaire = produitFormateUniteDestination.getPrixdebase().getPrixdachatmoyen();

        Arrivageparespece arrivageparrecompositionAEnreg = new Arrivageparespece();
        arrivageparrecompositionAEnreg.setArrivageProduitformate(arrivageProduitformate);
        arrivageparrecompositionAEnreg.setPrixachatunitaire(prixunitaire);
        arrivageparrecompositionAEnreg.setQuantitelivre(quantiteARecomposer);

        return arrivageparespeceRepository.save(arrivageparrecompositionAEnreg);
    }
}

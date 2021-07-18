package org.c2psi.gpointvente.constantes;

public class ValeurRetour implements java.io.Serializable {
    public static final int sigleEntrNotExist=400;
    public static final int associationCompteprincipalPointventeDejaDefini = 0;
    public static final int associationCompteprincipalPointventeDefini = 1;
    public static final int successReinitialisationcompteprincipalPointvente = 1;
    public static final int echecReinitialisationcompteprincipalPointvente = 0;
    public static final int echecUpdateAdressePointvente = 0;
    public static final int successUpdateAdressePointvente = 1;
    public static final int successCreateAdressePointvente = 2;
    public static final int sigleEntrExist=1;

    public static final String entrepriseNotExist="Entreprise non existante";
    public static final String entrepriseExist="Une entreprise avec ce sigle existe deja";
    public static final String pointventeExist="Un point de vente existe avec cette denomination dans l'entreprise";
    public static final String pointventeNotExist = "Point de vente non existant";

    public static final String enregEntrepriseSuccess="Entreprise enregistrée avec succes";
    public static final String enregPointventeSuccess="Point de vente enregistre avec succes";
    public static final String enregDeviseSuccess="Devise enregistree avec succes";

    public static final String updateEntrepriseSuccess="Entreprise mis a jour avec succes";

    public static final String deleteEntrepriseSuccess="Entreprise supprimee avec succes";

    public static final String echecAssociationCompteprincipalAuPointvente="Echec de l'association du compteprincipal " +
            "au point de vente";

    public static final String updateParamPointventeSuccess = "Parametres du point de vente modifies avec success";
    public static final String updateParamPointventeErreurDenomination = "Parametres du point de vente modifies avec success";
    public static final String updateAdesseError = "L'adresse est inexistante dans la BD";
    public static final String updateAdesseSuccess = "L'adresse du point vente a été mis à jour avec succes";

    public static final String updateCompteprincipalSuccess = "Le solde du compte a été reinitailise avec succes";

    public static final String deviseNotExist = "La devise recherchée est inexistante";
    public static final String updateDeviseSucess = "La devise a été mise a jour avec succes";

    public static String deviseSetToDefaultWithSucess = "La devise a été defini comme devise par defaut avec succes";
    public static String deviseSetToDefaultWithError = "Erreur lors de la definition de la devise comme devise par defaut";

    public static String regleconversionSavedSuccess = "La regle de conversion a ete enregistree avec succes";
    public static String regleconversionUpdatedSuccess = "La regle de conversion a ete mis a jour avec success";
    public static String regleconversionSavedError = "Erreur lors de l'enregistrement de la regle de conversion";
    public static String deviseSousMultipleNotExist = "La devise sous multiple precisee n'existe pas";
    public static String deviseMultipleNotExist = "La devise multiple precisee n'existe pas";


    public static String enregTypeemballageSuccess = "Le type d'emballage a ete cree avec succes dans le point de vente";
    public static String updateTypeemballageSuccess = "Le type d'emballage a ete mis a jour avec succes";
    public static String typeemballageNotExist = "L'identifiant du type d'emballage a modifier n'a pas ete trouve";

    public static String familleNonUniqueException="Le code de la famille saisi correspond deja a une " +
            "autre famille parmi les familles de produits de l'entreprise";
    public static String enregFamilleSuccess = "La famille a été enregistrée avec succes";
    public static String familleNotExist = "la famille dont l'identifiant a été précise n'existe pas";

    public static String enregProduitSuccess = "Le produit a ete cree avec succes dans la famille indique";
    public static String designationProduitNonUniqueInFamille = "la designantion du produit indiquee en francais ou en " +
            "anglais correspond deja à la designantion d'un autre produit dans la meme famille";

    public static String formatproduitEnregSuccess = "Le format de produit a été enregistré avec succes dans le systeme";
    public static String formatproduitNonUniqueInPointvente = " Le format de produit qu'on essaye d'ajouter a deja " +
            "un equivalent dans le systeme avec la meme contenance et la meme designation";


    public static String produitFormateNonUniqueInPointvente = " Le produit précisé existe deja dans le format (" +
            "conditionnement) précisée pour le même point de vente";
    public static String produitFormateMalFormedInPointvente = "Le produit spécifié et le format voulu n'appartiennent " +
            "pas au même point de vente";
    public static String produitformateEnregSuccess = " Le  conditionnement ou formatage du produit a ete enregistre " +
            "avec succes a cette date";
    public static String produitformateEnregError = " Un objet entre le produit et format est introuvable dans la BD " +
            "a partir de son identifiant";


    public static String uniteproduitEnregSuccess = " L'unite des produits dans le point de vente a ete enregistree " +
            "avec success";
    public static String uniteproduitNonUniqueInPointvente = " Une unite de produit est deja existante avec les mêmes " +
            "parametres dans le meme point de vente";

    public static String erreurInconue = "Exception levee: Une erreur inconnue a levee une exception";
    public static String produitInPointventeEnregSuccess = "Le produit à vendre a été enregistre dans le point de vente " +
            "precise avec sucess";


    public static String regleconversionUniteSavedError =" Exception levee: Erreur inconnue lors de l'enregistrement " +
            " de la regle de conversion entre les unites";
    public static String regleconversionUniteSavedSuccess  = "La règle de conversion entre les unites de vente " +
            " des produits a été enregistré avec succes";
    public static String regleconversionUniteNotExist = "L'identifiant de l'unite de produit saisi ne correspond " +
            "a aucune unite de vente de produit";

    public static String produitformateuniteNotExist = "L'identifiant du produit pour lequel le prix special " +
            "est saisi ne correspond a aucun produit dans le système";
    public static String prixspecialMalFormed = "Exception levee: le prixspecial precise n'est pas coherent";
    public static String prixspecialSavedSuccess = "Le prix special du produit a ete enregistre avec success " +
            "et associe au prix de base du produit correspondant";
    public static String devisePrixspecialNotExist = "La devise dans laquelle le prix special a été saisie " +
            "n'existe pas dans le système";


    public static String fournisseurExistInPointvente = "Un fournisseur existe deja avec les même parametre dans le " +
            "point de vente";
    public static String fournisseurSavedSuccess = "Le fournisseur a ete enregistre avec success";

    public static String adresseEnregSuccess = "Adresse enregistre avec succes";

    public static String factureapproNonUniqueException = "Exception levee: Une facture appro existe deja " +
            "avec les memes parametres dans le système";
    public static String factureapproMalFormedException = "Exception levee: Il y a un probleme de coherence entre " +
            "la date de la facture et sa date d'enregistrement";
    public static String factureapproespeceEnregSuccess = "Facture d'approvisionnement espece enregistree avec success";
    public static String factureapprocapsuleEnregSuccess = "Facture d'approvisionnement capsule enregistrée avec " +
            "success";
    public static String datenonconvertibleException = "Exception levee: erreur d'ecriture des dates. verifier que " +
            "le format utilisé pour les dates est yyyy-MM-dd HH:mm:ss (annee sur 4 chiffre-mois sur 2 chiffres-" +
            "jour sur 2 chiffres heure sur 2 chiffres:minute sur 2 chiffres:seconde sur 2 chiffres)";

    public static String produitNotExist = "Produit inexistant dans la BD";
    public static String factureapproNotExist = "Facture inexistante dans la BD";
    public static String verifierformatDate = "Exception levee: erreur de conversion des dates. Verifier que " +
            "le format des dates est yyyy-MM-dd HH:mm:ss ou yyyy-MM-dd";
    public static String errorEnregArrivageInconnue = "Exception levee: Erreur de recuperation de l'arrivage " +
            " alors qu'on a trouve qu'il existe";
    public static String errorEnregArrivageMalFormedException = "Exception levee: Mauvaise configuration de " +
            "l'arrivage. Verifier la coherence des dates et que le produit est dans le pointvente précise";
    public static String arrivageNormalEnregSucess = "L'arrivage normal a ete enregistre avec success";
    public static String facturesansFournisseur = "On ne peut enregistrer une facture dans le système sans fournisseur";

    public static String factureapproespeceNotFound = "La facture appro espece dont l'identifiant est precise " +
            "n'existe pas dans le système";
    public static String produitformateuniteNotFound = "L'identifiant du produit indiquee dans l'arrivage " +
            "ne correspond a aucun produit";
    public static String pointventeNotFound = "Le point vente dont l'identifiant est indique n'existe pas";
    public static String errorDateMalFormed  = "Vérifier que les dates saisies respectent le format yyyy-MM-dd hh:mm:ss";
    public static String produitformateuniteMalFormed = "Un produit ne saurait etre ni perissable ni non perissable";
    public static String arrivageNormalEspeceEnregSucess = "L'arrivage normal par espece a ete enregistré avec success";
    public static String arrivagePonctuelEspeceEnregSucess = "L'arrivage ponctuel par espece a ete enregistré avec success";
    public static String quantiteproduitADecomposerNotAvailable = "Exception levee: La quantite du produit " +
            " saisi a decomposer n'est pas disponible en stock ";
    public static String arrivageParDecompositionEnregSucess = "Arrivage par decomposition enregistré dans " +
            "le stock avec success";
    public static String regleconversionEntreProduitNotAvailable = "Exception levee: la regle de conversion " +
            "entre les deux produit n'existe pas dans la BD or c'est elle " +
            "qui permettra d'effectuer la decomposition";
    public static String quantiteproduitARecomposerNotAvailable  =" Exception levee: La quantite de produit " +
            "necessaire a la recomposition n'est pas disponible";

    public static String arrivageParRecompositionEnregSucess = "Arrivage par recomposition enregistré dans " +
            "le stock avec success";
}

package org.c2psi.gpointvente.constantes;

public class ConstanteOrdre implements java.io.Serializable {
    /***
     * Ordre de rangement des entreprises
     */
    public static final int SigleEntrCroissant=0;
    public static final int SigleEntrDecroissant=1;
    public static final int RaisonsocialeEntrCroissant=2;
    public static final int RaisonsocialeEntrDecroissant=3;
    public static final int NbrePointventeCroissant=4;
    public static final int NbrePointventeDecroissant=5;

    /***
     * Ordre de rangement des points de ventes
     */
    public static final int DenominationPvCroissant=0;
    public static final int DenominationPvDecroissant=1;
    public static final int PvSigleEntrCroissant=2;
    public static final int PvSigleEntrDecroissant=3;

    /***
     * Ordre de rangement des types d'emballage
     */
    public static final int DesignationTypeembCroissant=4;
    public static final int DesignationTypeembDecroissant=5;
    public static final int PrixTypeembCroissant=6;
    public static final int PrixTypeembDecroissant=7;

    /***
     * Ordre de rangement des produits
     */
    public static final int DesignationProduitCroissant=12;
    public static final int DesignationProduitDecroissant=13;
    public static final int PrixProduitCroissant=14;
    public static final int PrixProduitDecroissant=15;

    /*****
     * Ordre de rangement des devises
     */
    public static final int LibelleDeviseENCroissant=1;
    public static final int LibelleDeviseFRCroissant=2;
    public static final int AbbreviationDeviseENCroissant=3;
    public static final int AbbreviationDeviseFRCroissant=4;
    public static final int LibelleDeviseENDecroissant=5;
    public static final int LibelleDeviseFRDecroissant=6;
    public static final int AbbreviationDeviseENDecroissant=7;
    public static final int AbbreviationDeviseFRDecroissant=8;

    /*************************************
     * Ordre de rangement des typeemballage
     */
    public static final int DesignationEmballageENCroissant=1;
    public static final int DesignationEmballageFRCroissant=2;
    public static final int DesignationEmballageENDecroissant=3;
    public static final int DesignationEmballageFRDecroissant=4;
    public static int PrixEmballageCroissant=5;
    public static int PrixEmballageDecroissant=6;
}

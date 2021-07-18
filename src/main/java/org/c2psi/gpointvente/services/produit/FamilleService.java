package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.produit.Famille;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.exceptions.produit.FamilleNonUniqueException;
import org.c2psi.gpointvente.exceptions.produit.FamilleNotFoundException;
import org.c2psi.gpointvente.exceptions.pv.PointventeNotFoundException;

public interface FamilleService {
    int isCodeFamilleUniqueInPointvente(String codeFamille, Pointvente pointvente);
    int addFamilleToFamilleparente(Famille familleFille, Famille familleParente);
    int addProduitToFamille(Produit produit, Famille famille);
    Famille getFamilleByIdFamille(String idFamille);
    Famille saveFamille(String designationFamilleFR, String designationFamilleEN,
            String aliasFamilleFR, String aliasFamilleEN, String descriptionFamilleFR,
            String descriptionFamilleEN, String codeFamille,
            Famille familleParente, Pointvente pointvente)throws FamilleNonUniqueException,
            PointventeNotFoundException, FamilleNotFoundException;
    Famille saveFamille(String designationFamilleFR, String designationFamilleEN,
                        String aliasFamilleFR, String aliasFamilleEN, String descriptionFamilleFR,
                        String descriptionFamilleEN, String codeFamille,
                        Pointvente pointvente)throws FamilleNonUniqueException;

    Famille updateFamille(String idFamilleAModifier, String newdesignationFamilleFR, String newdesignationFamilleEN,
                        String newaliasFamilleFR, String newaliasFamilleEN, String newdescriptionFamilleFR,
                        String newdescriptionFamilleEN, String newcodeFamille,
                        String newidFamilleParente)throws FamilleNonUniqueException;

}

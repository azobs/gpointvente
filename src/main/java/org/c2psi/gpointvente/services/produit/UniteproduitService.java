package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.produit.RegleconversionUnite;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.c2psi.gpointvente.exceptions.produit.RegleconversionUniteMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.UniteproduitNonUniqueException;
import org.c2psi.gpointvente.exceptions.produit.UniteproduitNotFoundException;

import java.util.List;

public interface UniteproduitService {
    int isUniteproduitENUniqueInPointvente(String abbreviationUniteEN, String libelleUniteEN, Pointvente pointvente);
    int isUniteproduitFRUniqueInPointvente(String abbreviationUniteFR, String libelleUniteFR, Pointvente pointvente);
    Uniteproduit getUniteproduitByIdUnite(String idUniteproduit);
    Uniteproduit getUniteproduitByIdUniteInPointvente(String idUniteproduit, Pointvente pointvente);
    Uniteproduit saveUniteproduit(String libelleUniteFR, String abbreviationUniteFR, String libelleUniteEN,
                                   String abbreviationUniteEN, Pointvente pointvente)
            throws UniteproduitNonUniqueException;
    List<RegleconversionUnite> findListofRegleAssociantUnite(Uniteproduit uniteproduitMultiple,
                                                             Uniteproduit uniteproduitSousmultiple);
    Uniteproduit saveUniteproduit(Uniteproduit uniteproduit);
    RegleconversionUnite saveRegleconversionUnite(Uniteproduit uniteproduitMultiple,
                                                  Uniteproduit uniteproduitSousmultiple, int facteurconversion)
            throws RegleconversionUniteMalFormedException, UniteproduitNotFoundException;
}

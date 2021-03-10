package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.FormatproduitNonUniqueException;

import java.util.Optional;

public interface FormatproduitService {
    int isFormatproduitENUniqueInPointvente(String contenance, String designationFormatproduitEN, Pointvente pointvente);
    int isFormatproduitFRUniqueInPointvente(String contenance, String designationFormatproduitEN, Pointvente pointvente);
    Optional<Formatproduit> getFormatproduitByIdFormatproduit(String idFormatproduit);
    Formatproduit saveFormatproduit(String contenance, String designationFormatproduitEN,
                                    String designationFormatproduitFR, Pointvente pointvente) throws FormatproduitNonUniqueException;
    Formatproduit saveFormatproduit(Formatproduit formatproduit);

}

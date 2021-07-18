package org.c2psi.gpointvente.services.facture.factureappro;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.c2psi.gpointvente.entities.produit.Arrivageparespece;

import java.util.Optional;

public interface FactureapproespeceService {
    Optional<Factureapproespece> findFactureapproespeceByIdFactureapproespece(String idFactureapproespece);
    Factureapproespece saveFactureapproespece(double montantAttendu, double montantverse,
                                              Factureappro factureappro);
    int addArrivageparespeceToFactureapproespece(Arrivageparespece arrivageparespece,
                                                 Factureapproespece factureapproespece);
}

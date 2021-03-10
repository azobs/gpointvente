package org.c2psi.gpointvente.services.facture.factureappro;

import org.c2psi.gpointvente.entities.produit.ArrivageProduitformate;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.c2psi.gpointvente.entities.facture.Facture;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.exceptions.facture.FactureapproMalFormedException;
import org.c2psi.gpointvente.exceptions.facture.FactureapproNonUniqueException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FactureapproService {
    int isFactureapproMalFormed(Date dateFacture, Date dateenregFacture);
    int addArrivageProduitToFactureappro(ArrivageProduitformate arrivageProduitformate,
                                         Factureappro factureappro);
    int isFactureapproUnique(String numeroFacture, String typeFactureappro);


    Optional<Factureappro> findFactureapproByIdFactureappro(String idfactureappro);
    List<Factureappro> getListofFactureapproByNumerofactureAndTypeFacture(String numeroFacture,
                                                                          String typeFactureappro);
    Optional<Factureappro> findFactureapproByNumerofactureAndTypeFacture(String numeroFacture, String typeFacture);
    List<Factureappro> getListofFactureapproByDateenregFactureappro(Date dateenregFactureappro);
    List<Factureappro> getListofFactureapproByDateFactureappro(Date dateFactureappro);
    List<Factureappro> getListofFactureapproByTypefactureapproAndDateFacture(String typeFactureappro,
                                                                             Date dateFactureappro);
    List<Factureappro> getListofFactureapproByTypefactureapproAndDateenregFacture(String typeFactureappro,
                                                                             Date dateenregFactureappro);

    Factureappro saveFactureappro(String numeroFacture, Date dateFacture, Date dateheureenregFacture,
                                  String typeFactureappro, String observation,
                                  Facture factureAssocie, Fournisseur fournisseur)
            throws FactureapproMalFormedException, FactureapproNonUniqueException;

}

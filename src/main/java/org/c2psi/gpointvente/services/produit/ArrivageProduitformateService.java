package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.produit.ArrivageProduitformate;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.ArrivageProduitformateException;

import java.util.Date;
import java.util.Optional;

public interface ArrivageProduitformateService {

    int isArrivageProduitMalFormed(Date datelivraisonArrivage, Date datepremption,
                                   Date dateseuilperemption, ProduitFormateUnite produitFormateUnite,
                                   Pointvente pointvente);
    int isArrivageProduitMalFormed(Date datelivraisonArrivage, Date datepremption,
                                   Date dateseuilperemption, Date dateheurefactureAssocie,
                                   ProduitFormateUnite produitFormateUnite, Pointvente pointvente);
    int isArrivageProduitMalFormed(Date datelivraisonArrivage, Date dateheurefactureAssocie,
                                       ProduitFormateUnite produitFormateUnite, Pointvente pointvente);
    int isArrivageProduitMalFormed(Date datelivraisonArrivage, ProduitFormateUnite produitFormateUnite, Pointvente pointvente);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    Optional<ArrivageProduitformate> findArrivageProduitformateByIdArrivageProduitformate(
            String idArrivageProduitformate);
    ArrivageProduitformate saveArrivageNormalEspeceProduitformate(Date dateheurelivraisonArrivage, Date dateheurefacturation,
                                                            Date dateperemption, Date dateseuilperemption,
                                                            ProduitFormateUnite produitformateConcerne,
                                                            Pointvente pointvente)
            throws ArrivageProduitformateException;
    ArrivageProduitformate saveArrivagePonctuelEspeceProduitformate(Date dateheurelivraisonArrivage,
                                                                  Date dateperemption, Date dateseuilperemption,
                                                                  ProduitFormateUnite produitformateConcerne,
                                                                  Pointvente pointvente)
            throws ArrivageProduitformateException;
}

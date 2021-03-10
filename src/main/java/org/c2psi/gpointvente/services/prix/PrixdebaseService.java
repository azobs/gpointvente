package org.c2psi.gpointvente.services.prix;

import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.prix.Prixdebase;
import org.c2psi.gpointvente.entities.prix.Prixspecial;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.exceptions.prix.PrixdebaseExistInDeviseException;
import org.c2psi.gpointvente.exceptions.prix.PrixdebaseMalFormedException;

public interface PrixdebaseService {
    int isPrixdebaseProduitFUExistInDevise(ProduitFormateUnite produitFormateUnite, Devise devise);
    int isPrixdebaseMalFormed(double prixdegrosmoyen, double prixdesemigrosmoyen, double prixdedetailmoyen,
                                       ProduitFormateUnite produitFormateUnite, Devise devise);
    int isPrixdebaseMalFormed(double prixdegrosmoyen, double prixdesemigrosmoyen, double prixdedetailmoyen);
    Prixdebase savePrixdebase(double prixdachatmoyen, double prixdegrosmoyen, double prixdesemigrosmoyen,
                              double prixdedetailmoyen, double ristourneattendu, double precompteattendu,
                              String formataffichageprix, Devise devisePrix,
                              ProduitFormateUnite produitFormateUniteConcerne)
            throws PrixdebaseExistInDeviseException, PrixdebaseMalFormedException;
    Prixdebase savePrixdebase(double prixdachatmoyen, double prixdegrosmoyen, double prixdesemigrosmoyen,
                              double prixdedetailmoyen, double ristourneattendu, double precompteattendu,
                              String formataffichageprix, Devise devisePrix)
            throws  PrixdebaseMalFormedException;
    Prixdebase savePrixdebase(Prixdebase prixdebase);
    int addPrixspecialToPrixdebase(Prixspecial prixspecial, Prixdebase prixdebase);
}

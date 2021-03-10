package org.c2psi.gpointvente.services.prix;

import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.prix.Prixspecial;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.exceptions.prix.PrixdebaseMalFormedException;

public interface PrixspecialService {

    int isPrixspecialMalFormed(double prixdegrosmoyen, double prixdesemigrosmoyen, double prixdedetailmoyen,
                               ProduitFormateUnite produitFormateUnite, Devise devise);
    int isPrixspecialMalFormed(double prixdegrosmoyen, double prixdesemigrosmoyen, double prixdedetailmoyen);
    Prixspecial savePrixspecial(double prixdachatmoyen, double prixdegrosmoyen, double prixdesemigrosmoyen,
                                double prixdedetailmoyen, double ristourneattendu, double precompteattendu,
                                int limitebassegros, int limitebassesemigros,
                                ProduitFormateUnite produitFormateUniteConcerne, Devise devise)
            throws  PrixdebaseMalFormedException;
    Prixspecial savePrixspecial(Prixspecial prixspecial);
}

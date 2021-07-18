package org.c2psi.gpointvente.services.prix;

import org.c2psi.gpointvente.dao.prix.PrixspecialRepository;
import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.prix.Prixspecial;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.exceptions.prix.PrixdebaseMalFormedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrixspecialServiceImplementation implements PrixspecialService {

    @Autowired
    PrixspecialRepository prixspecialRepository;
    @Autowired
    PrixdebaseService prixdebaseService;

    @Override
    public int isPrixspecialMalFormed(double prixdegrosmoyen, double prixdesemigrosmoyen,
                                      double prixdedetailmoyen, ProduitFormateUnite produitFormateUnite,
                                      Devise devise) {
        if(produitFormateUnite.getPointvente().getIdPointvente().equalsIgnoreCase(
                devise.getPointvente().getIdPointvente())==false){
            return -1;
        }
        if(prixdegrosmoyen>prixdesemigrosmoyen || prixdesemigrosmoyen>prixdedetailmoyen ||
                prixdegrosmoyen>prixdedetailmoyen){
            return 0;
        }
        return 1;
    }

    @Override
    public int isPrixspecialMalFormed(double prixdegrosmoyen, double prixdesemigrosmoyen, double prixdedetailmoyen) {
        if(prixdegrosmoyen>prixdesemigrosmoyen || prixdesemigrosmoyen>prixdedetailmoyen ||
                prixdegrosmoyen>prixdedetailmoyen){
            return 0;
        }
        return 1;
    }

    @Override
    public Prixspecial savePrixspecial(double prixdachatmoyen, double prixdegrosmoyen,
                                       double prixdesemigrosmoyen, double prixdedetailmoyen,
                                       double ristourneattendu, double precompteattendu,
                                       int limitebassegros, int limitebassesemigros,
                                       ProduitFormateUnite produitFormateUniteConcerne, Devise devise)
            throws PrixdebaseMalFormedException {
        if(isPrixspecialMalFormed(prixdegrosmoyen, prixdesemigrosmoyen, prixdedetailmoyen,
                produitFormateUniteConcerne, devise)==-1){
            throw new PrixdebaseMalFormedException("Exception levee: Le produit et la  devise choisie doivent appartenir " +
                    " au meme point de vente. Ce qui n'est pas le cas ici. ");
        }
        if(isPrixspecialMalFormed(prixdegrosmoyen, prixdesemigrosmoyen, prixdedetailmoyen)==0){
            throw new PrixdebaseMalFormedException("Exception levee: Dans un prix special, le prix de gros " +
                    "ne peut etre > au prix de semi gros ou alors > au prix de detail");
        }
        /******
         * Construire et enregistrer le prix special
         * A partir du produitformateunite il faut recuperer le prixdebase
         * Ajouter le prixspecial a la liste des prixspeciaux associe au prix de base
         */
        Prixspecial prixspecial = new Prixspecial();
        prixspecial.setLimitebassegros(limitebassegros);
        prixspecial.setLimitebassesemigros(limitebassesemigros);
        prixspecial.setPrecompteattendu(precompteattendu);
        prixspecial.setPrixdachatmoyen(prixdachatmoyen);
        prixspecial.setPrixdebaseAssocie(produitFormateUniteConcerne.getPrixdebase());
        prixspecial.setPrixdedetailmoyen(prixdedetailmoyen);
        prixspecial.setPrixdegrosmoyen(prixdegrosmoyen);
        prixspecial.setPrixdesemigrosmoyen(prixdesemigrosmoyen);
        prixspecial.setRistourneattendu(ristourneattendu);
        prixspecial.setDevise(devise);
        Prixspecial prixspecialEnreg = prixspecialRepository.save(prixspecial);

        return prixspecialEnreg;
    }

    @Override
    public Prixspecial savePrixspecial(Prixspecial prixspecial) {
        return prixspecialRepository.save(prixspecial);
    }
}

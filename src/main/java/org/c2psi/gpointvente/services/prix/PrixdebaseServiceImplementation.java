package org.c2psi.gpointvente.services.prix;

import org.c2psi.gpointvente.dao.prix.PrixdebaseRepository;
import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.prix.Prixdebase;
import org.c2psi.gpointvente.entities.prix.Prixspecial;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.exceptions.prix.PrixdebaseExistInDeviseException;
import org.c2psi.gpointvente.exceptions.prix.PrixdebaseMalFormedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PrixdebaseServiceImplementation implements PrixdebaseService {
    @Autowired
    PrixdebaseRepository prixdebaseRepository;


    @Override
    public int isPrixdebaseProduitFUExistInDevise(ProduitFormateUnite produitFormateUnite, Devise devise) {
        /*
        On veut verifier si le produit en parametre a deja un prix dans la devise passe en parametre
         */
        Optional<Prixdebase> optionalPrixdebaseProduit = Optional.ofNullable(produitFormateUnite.getPrixdebase());
        if(optionalPrixdebaseProduit.isPresent()){
            Prixdebase prixdebase = optionalPrixdebaseProduit.get();
            if(prixdebase.getDevisePrix().getIdDevise().equalsIgnoreCase(devise.getIdDevise())){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int isPrixdebaseMalFormed(double prixdegrosmoyen, double prixdesemigrosmoyen,
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

    public int isPrixdebaseMalFormed(double prixdegrosmoyen, double prixdesemigrosmoyen,
                                              double prixdedetailmoyen){
        if(prixdegrosmoyen>prixdesemigrosmoyen || prixdesemigrosmoyen>prixdedetailmoyen ||
                prixdegrosmoyen>prixdedetailmoyen){
            return 0;
        }
        return 1;
    }

    @Override
    public Prixdebase savePrixdebase(double prixdachatmoyen, double prixdegrosmoyen, double prixdesemigrosmoyen,
                                     double prixdedetailmoyen, double ristourneattendu, double precompteattendu,
                                     String formataffichageprix, Devise devisePrix,
                                     ProduitFormateUnite produitFormateUniteConcerne)
            throws PrixdebaseExistInDeviseException, PrixdebaseMalFormedException {
        if(isPrixdebaseProduitFUExistInDevise(produitFormateUniteConcerne, devisePrix)==0){
            throw new PrixdebaseExistInDeviseException("Exception levee: Un prix de base a deja ete defini pour ce produit" +
                    " dans la devise spécifie");
        }
        if(isPrixdebaseMalFormed(prixdegrosmoyen, prixdesemigrosmoyen, prixdedetailmoyen,
                produitFormateUniteConcerne, devisePrix)==-1){
            throw new PrixdebaseMalFormedException("Exception levee: Le produit et la  devise choisie doivent appartenir " +
                    " au meme point de vente. Ce qui n'est pas le cas ici. ");
        }
        if(isPrixdebaseMalFormed(prixdegrosmoyen, prixdesemigrosmoyen, prixdedetailmoyen,
                produitFormateUniteConcerne, devisePrix)==0){
            throw new PrixdebaseMalFormedException("Exception levee: Les prix saisis ne sont pas cohérent. ");
        }
        Prixdebase prixdebaseAEnreg = new Prixdebase();
        prixdebaseAEnreg.setPrixdachatmoyen(prixdachatmoyen);
        prixdebaseAEnreg.setPrixdegrosmoyen(prixdegrosmoyen);
        prixdebaseAEnreg.setPrixdesemigrosmoyen(prixdesemigrosmoyen);
        prixdebaseAEnreg.setPrixdedetailmoyen(prixdedetailmoyen);
        prixdebaseAEnreg.setRistourneattendu(ristourneattendu);
        prixdebaseAEnreg.setPrecompteattendu(precompteattendu);
        prixdebaseAEnreg.setFormataffichageprix(formataffichageprix);

        prixdebaseAEnreg.setDevisePrix(devisePrix);
        //prixdebaseAEnreg.setProduitFormateUniteConcerne(produitFormateUniteConcerne);

        return prixdebaseRepository.save(prixdebaseAEnreg);
    }

    public Prixdebase savePrixdebase(double prixdachatmoyen, double prixdegrosmoyen, double prixdesemigrosmoyen,
                                     double prixdedetailmoyen, double ristourneattendu, double precompteattendu,
                                     String formataffichageprix, Devise devisePrix)
            throws  PrixdebaseMalFormedException{
        if(isPrixdebaseMalFormed(prixdegrosmoyen, prixdesemigrosmoyen, prixdedetailmoyen)==0){
            throw new PrixdebaseMalFormedException("Exception levee: Les prix saisis ne sont pas cohérent. ");
        }
        Prixdebase prixdebaseAEnreg = new Prixdebase();
        prixdebaseAEnreg.setPrixdachatmoyen(prixdachatmoyen);
        prixdebaseAEnreg.setPrixdegrosmoyen(prixdegrosmoyen);
        prixdebaseAEnreg.setPrixdesemigrosmoyen(prixdesemigrosmoyen);
        prixdebaseAEnreg.setPrixdedetailmoyen(prixdedetailmoyen);
        prixdebaseAEnreg.setRistourneattendu(ristourneattendu);
        prixdebaseAEnreg.setPrecompteattendu(precompteattendu);
        prixdebaseAEnreg.setFormataffichageprix(formataffichageprix);

        prixdebaseAEnreg.setDevisePrix(devisePrix);

        return prixdebaseRepository.save(prixdebaseAEnreg);
    }

    @Override
    public Prixdebase savePrixdebase(Prixdebase prixdebase) {
        return prixdebaseRepository.save(prixdebase);
    }

    @Override
    public int addPrixspecialToPrixdebase(Prixspecial prixspecial, Prixdebase prixdebase) {
        prixdebase.getListofPrixspecial().add(prixspecial);
        prixdebaseRepository.save(prixdebase);
        System.out.println("L'association du prixspecial au prixdebase a ete effectue avec success ");
        return 1;
    }

}

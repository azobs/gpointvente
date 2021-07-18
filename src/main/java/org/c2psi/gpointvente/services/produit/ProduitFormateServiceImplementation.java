package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.dao.produit.ProduitFormateRepository;
import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.produit.Produit;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateNonUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProduitFormateServiceImplementation implements ProduitFormateService {
    @Autowired
    ProduitFormateRepository produitFormateRepository;

    @Override
    public int isProduitFormateUniqueInPointvente(Produit produit, Formatproduit formatproduit) {
        List<ProduitFormate> listofProduitFormateInPointvente =
                produitFormateRepository.findAllByProduitAFormateAndFormatPF(produit, formatproduit);
        return listofProduitFormateInPointvente.size()==0?1:0;
    }

    @Override
    public int isProduitFormateValide(Produit produit, Formatproduit formatproduit) {
        if(produit.getFamilleProduit().getPointvente().getIdPointvente().equalsIgnoreCase(
                formatproduit.getPointvente().getIdPointvente())==true){
            return 1;
        }
        return 0;
    }

    @Override
    public ProduitFormate saveProduitFormate(Produit produit, Formatproduit formatproduit, Date dateFormatage,
                                             String photoPF)throws ProduitFormateNonUniqueException,
            ProduitFormateMalFormedException {
        if(isProduitFormateUniqueInPointvente(produit, formatproduit)==0){
            throw new ProduitFormateNonUniqueException("Exception levee: Le produit specifie a deja ete formate " +
                    "avec le format precise.");
        }
        if(isProduitFormateValide(produit,formatproduit)==0){
            throw new ProduitFormateMalFormedException("Exception levee: Le produit et le format n'appartiennent pas " +
                    "au meme point de vente. ce qui est anormal");
        }
        ProduitFormate produitFormateAEnreg = new ProduitFormate();
        produitFormateAEnreg.setDateFormatage(dateFormatage);
        produitFormateAEnreg.setFormatPF(formatproduit);
        produitFormateAEnreg.setPhotoPF(photoPF);
        produitFormateAEnreg.setProduitAFormate(produit);

        return produitFormateRepository.save(produitFormateAEnreg);
    }

    @Override
    public ProduitFormate saveProduitFormate(ProduitFormate produitFormate) {
        return null;
    }
}

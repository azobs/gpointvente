package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.dao.produit.ProduitFormateUniteRepository;
import org.c2psi.gpointvente.entities.prix.Prixdebase;
import org.c2psi.gpointvente.entities.produit.ComptecapsulePv;
import org.c2psi.gpointvente.entities.produit.ProduitFormate;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.entities.produit.Uniteproduit;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateUniteMalFormedException;
import org.c2psi.gpointvente.exceptions.produit.ProduitFormateUniteNonUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduitFormateUniteServiceImplementation implements ProduitFormateUniteService {
    @Autowired
    ProduitFormateUniteRepository produitFormateUniteRepository;

    @Override
    public boolean isQuantiteProduitDisponible(ProduitFormateUnite produitFormateUnite, int quantite) {
        return produitFormateUnite.getQuantiteEnStock()>=quantite?true:false;
    }

    @Override
    public int isProduitFormateUniteUniqueInPointvente(ProduitFormate produitFormate, Uniteproduit uniteproduit) {
        List<ProduitFormateUnite> listofProduitFormateUnite =
                produitFormateUniteRepository.findAllByProduitFormateAndUnitePFU(produitFormate, uniteproduit);

        return listofProduitFormateUnite.size()==0?1:0;
    }

    @Override
    public int isProduitFormateUniteValide(ProduitFormate produitFormate, Uniteproduit uniteproduit) {
        if(produitFormate.getProduitAFormate().getFamilleProduit().getPointvente().getIdPointvente().equalsIgnoreCase(
                uniteproduit.getPointvente().getIdPointvente()
        )==true){
            return 1;
        }
        return 0;
    }

    @Override
    public ProduitFormateUnite saveProduitFormateUnite(int seuilqte, int limitebassesemigros, int limitebassegros,
                                                       String commentairePFU, String codePFU, ProduitFormate produitFormate,
                                                       Uniteproduit uniteproduit, Pointvente pointvente, Prixdebase prixdebase,
                                                       ComptecapsulePv comptecapsulePv, Date datePFU)
            throws ProduitFormateUniteNonUniqueException, ProduitFormateUniteMalFormedException {
        if(isProduitFormateUniteUniqueInPointvente(produitFormate, uniteproduit)==0){
            throw new ProduitFormateUniteNonUniqueException("Exception levee: Un produit formate (conditionnee) " +
                    "a deja ete associe a l'unite de produit precisee dans le meme point de vente");
        }

        if(isProduitFormateUniteValide(produitFormate, uniteproduit)==0){
            throw new ProduitFormateUniteMalFormedException("Exception levee: le produit formate et l'unite de produit " +
                    "qu'on veut l'associe n'appartiennent pas au meme point de vente");
        }

        ProduitFormateUnite produitFormateUnite = new ProduitFormateUnite();
        produitFormateUnite.setSeuilqte(seuilqte);
        produitFormateUnite.setLimitebassesemigros(limitebassesemigros);
        produitFormateUnite.setLimitebassegros(limitebassegros);
        produitFormateUnite.setCommentairePFU(commentairePFU);
        produitFormateUnite.setCodePFU(codePFU);
        produitFormateUnite.setProduitFormate(produitFormate);
        produitFormateUnite.setUnitePFU(uniteproduit);
        produitFormateUnite.setPointvente(pointvente);
        produitFormateUnite.setComptecapsulePv(comptecapsulePv);
        produitFormateUnite.setPrixdebase(prixdebase);
        produitFormateUnite.setDateProduitFormatUnite(datePFU);

        return produitFormateUniteRepository.save(produitFormateUnite);
    }

    @Override
    public ProduitFormateUnite saveProduitFormateUnite(ProduitFormateUnite produitFormateUnite) {
        return produitFormateUniteRepository.save(produitFormateUnite);
    }

    @Override
    public Optional<ProduitFormateUnite> getProduitFormateUniteByIdPFU(String idPFU){
        return produitFormateUniteRepository.findProduitFormateUniteByIdPFU(idPFU);
    }
}

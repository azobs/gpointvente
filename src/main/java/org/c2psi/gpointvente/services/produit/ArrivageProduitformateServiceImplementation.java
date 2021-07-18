package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.constantes.TypeArrivage;
import org.c2psi.gpointvente.dao.produit.ArrivageProduitformateRepository;
import org.c2psi.gpointvente.entities.produit.ArrivageProduitformate;
import org.c2psi.gpointvente.entities.produit.ProduitFormateUnite;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.ArrivageProduitformateException;
import org.c2psi.gpointvente.exceptions.produit.ArrivageproduitInPointventeMalFormedException;
import org.c2psi.gpointvente.services.pv.PointventeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class ArrivageProduitformateServiceImplementation implements ArrivageProduitformateService {
    @Autowired
    ArrivageProduitformateRepository arrivageProduitformateRepository;
    @Autowired
    ProduitFormateUniteService produitFormateUniteService;
    @Autowired
    PointventeService pointventeService;

    @Override
    public int isArrivageProduitMalFormed(Date datelivraisonArrivage, Date dateperemption,
                                          Date dateseuilperemption, ProduitFormateUnite produitFormateUnite,
                                          Pointvente pointvente) {
        Date datedujour = new Date();
        if(datedujour.compareTo(datelivraisonArrivage)<0){
            System.out.println("La date du jour ne saurait être anterieur a la date de livraison " +
                    ""+datedujour+" et "+datelivraisonArrivage);
            return -1;
        }
        if(dateperemption.compareTo(datelivraisonArrivage)<0){
            System.out.println("La date du peremption ne saurait être anterieur a la date de livraison " +
                    ""+dateperemption+" et "+datelivraisonArrivage);
            return -2;
        }
        if(datedujour.compareTo(dateseuilperemption)>0){
            System.out.println("La date du jour ne saurait être ultérieure a la date seuil de peremption " +
                    ""+datedujour+" et "+dateseuilperemption);
            return -3;
        }
        if(dateseuilperemption.compareTo(dateperemption)>=0){
            System.out.println("La date de peremption ne saurait être anterieur a la date seuil de peremption " +
                    ""+datedujour+" et "+dateseuilperemption);
            return -4;
        }
        if(pointvente.getIdPointvente().equalsIgnoreCase(
                produitFormateUnite.getPointvente().getIdPointvente())==false){
            System.out.println("Le produit doit etre dans le meme point de vente que celui passe en parametre");
            return 0;
        }
        return 1;
    }

    @Override
    public int isArrivageProduitMalFormed(Date datelivraisonArrivage, Date datepremption,
                                          Date dateseuilperemption, Date dateheurefactureAssocie,
                                          ProduitFormateUnite produitFormateUnite, Pointvente pointvente) {
        Date datedujour = new Date();
        if(datedujour.compareTo(datelivraisonArrivage)<0){
            System.out.println("La date du jour ne saurait être anterieur a la date de livraison " +
                    ""+datedujour+" et "+datelivraisonArrivage);
            return -1;
        }
        if(datepremption.compareTo(datelivraisonArrivage)<0){
            System.out.println("La date du peremption ne saurait être anterieur a la date de livraison " +
                    ""+datepremption+" et "+datelivraisonArrivage);
            return -2;
        }
        if(datedujour.compareTo(dateseuilperemption)>0){
            System.out.println("La date du jour ne saurait être ultérieure a la date seuil de peremption " +
                    ""+datedujour+" et "+dateseuilperemption);
            return -3;
        }
        if(dateseuilperemption.compareTo(datepremption)>=0){
            System.out.println("La date de peremption ne saurait être anterieur a la date seuil de peremption " +
                    ""+dateseuilperemption+" et "+datepremption);
            return -4;
        }
        if(datelivraisonArrivage.compareTo(dateheurefactureAssocie)<0){
            System.out.println("La date de livraison d'un arrivage ne saurait être anterieur a la date de la facturation " +
                    " qui est la date qui figure sur la facture"+datelivraisonArrivage+" et "+dateheurefactureAssocie);
            return -5;
        }
        if(pointvente.getIdPointvente().equalsIgnoreCase(
                produitFormateUnite.getPointvente().getIdPointvente())==false){
            System.out.println("Le produit doit etre dans le meme point de vente que celui passe en parametre");
            return 0;
        }
        return 1;
    }

    @Override
    public int isArrivageProduitMalFormed(Date datelivraisonArrivage, Date dateheurefactureAssocie,
                                              ProduitFormateUnite produitFormateUnite, Pointvente pointvente) {
        Date datedujour = new Date();
        if(datedujour.compareTo(datelivraisonArrivage)<0){
            System.out.println("La date du jour ne saurait être anterieur a la date de livraison " +
                    ""+datedujour+" et "+datelivraisonArrivage);
            return -1;
        }
        if(datelivraisonArrivage.compareTo(dateheurefactureAssocie)<0){
            System.out.println("La date de livraison d'un arrivage ne saurait être anterieur a la date de la facturation " +
                    " qui est la date qui figure sur la facture"+datelivraisonArrivage+" et "+dateheurefactureAssocie);
            return -2;
        }
        if(pointvente.getIdPointvente().equalsIgnoreCase(
                produitFormateUnite.getPointvente().getIdPointvente())==false){
            System.out.println("Le produit doit etre dans le meme point de vente que celui passe en parametre");
            return 0;
        }
        return 1;
    }

    @Override
    public int isArrivageProduitMalFormed(Date datelivraisonArrivage,
                                          ProduitFormateUnite produitFormateUnite, Pointvente pointvente) {
        Date datedujour = new Date();
        if(datedujour.compareTo(datelivraisonArrivage)<0){
            System.out.println("La date du jour ne saurait être anterieur a la date de livraison " +
                    ""+datedujour+" et "+datelivraisonArrivage);
            return -1;
        }
        if(pointvente.getIdPointvente().equalsIgnoreCase(
                produitFormateUnite.getPointvente().getIdPointvente())==false){
            System.out.println("Le produit doit etre dans le meme point de vente que celui passe en parametre");
            return 0;
        }
        return 1;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Optional<ArrivageProduitformate> findArrivageProduitformateByIdArrivageProduitformate(String idArrivageProduitformate) {
        return arrivageProduitformateRepository.findArrivageProduitformateByIdArrivageProduitFormate(idArrivageProduitformate);
    }

    @Override
    public ArrivageProduitformate saveArrivageNormalEspeceProduitformate(Date dateheurelivraisonArrivage, Date dateheurefacturation,
                                                                   Date dateperemption, Date dateseuilperemption,
                                                                   ProduitFormateUnite produitformateConcerne,
                                                                   Pointvente pointvente)
            throws ArrivageProduitformateException {
        int perissable = produitformateConcerne.getProduitFormate().getProduitAFormate().getPerissable();
        if(perissable == 0){
            /*
                Le produit pour lequel on veut enregistrer un arrivage n'est pas perissable
                donc on verifie simplement la coherence entre le produit, le pointvente et la date de facturation
            */

            switch (isArrivageProduitMalFormed(dateheurelivraisonArrivage, dateheurefacturation,
                    produitformateConcerne, pointvente)){
                case -2: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date de livraison doit etre ulterieure a la date de facturation");
                case -1: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date du jour doit etre ulterieure ou egale a la date de livraison");
                case 0: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "Le produit doit appartenir au point de vente précise");
            }
            ArrivageProduitformate arrivageProduitformateAEnreg = new ArrivageProduitformate();
            arrivageProduitformateAEnreg.setTypeArrivage(TypeArrivage.arrivageNormalEspece);
            arrivageProduitformateAEnreg.setProduitformateConcerne(produitformateConcerne);
            arrivageProduitformateAEnreg.setPointvente(pointvente);
            arrivageProduitformateAEnreg.setDateheurelivraisonArrivage(dateheurelivraisonArrivage);
            return arrivageProduitformateRepository.save(arrivageProduitformateAEnreg);
        }
        else if(perissable == 1){
            switch (isArrivageProduitMalFormed(dateheurelivraisonArrivage, dateperemption, dateseuilperemption, dateheurefacturation,
                    produitformateConcerne, pointvente)){
                case -5: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date de livraison doit etre ulterieure a la date de facturation");
                case -4: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date de peremption doit etre ulterieure a la date seuil de peremption");
                case -3: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date seuil de peremption doit etre ulterieure a la date du jour");
                case -2: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date de peremption doit etre ulterieure a la date de livraison");
                case -1: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date du jour doit etre ulterieure a la date de livraison");
                case 0: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "Le produit doit appartenir au point de vente");
            }
            ArrivageProduitformate arrivageProduitformateAEnreg = new ArrivageProduitformate();
            arrivageProduitformateAEnreg.setTypeArrivage(TypeArrivage.arrivageNormalEspece);
            arrivageProduitformateAEnreg.setProduitformateConcerne(produitformateConcerne);
            arrivageProduitformateAEnreg.setPointvente(pointvente);
            arrivageProduitformateAEnreg.setDateheurelivraisonArrivage(dateheurelivraisonArrivage);
            arrivageProduitformateAEnreg.setDateseuilperemption(dateseuilperemption);
            arrivageProduitformateAEnreg.setDateperemption(dateperemption);
            return arrivageProduitformateRepository.save(arrivageProduitformateAEnreg);
        }
        else{
            throw new ArrivageProduitformateException("Exception levee: Un produit ne saurait etre ni perissable " +
                    "ni non perissable");
        }
    }

    @Override
    public ArrivageProduitformate saveArrivagePonctuelEspeceProduitformate(
            Date dateheurelivraisonArrivage, Date dateperemption, Date dateseuilperemption,
            ProduitFormateUnite produitformateConcerne, Pointvente pointvente)
            throws ArrivageProduitformateException {
        int perissable = produitformateConcerne.getProduitFormate().getProduitAFormate().getPerissable();
        if(perissable == 0){
            switch (isArrivageProduitMalFormed(dateheurelivraisonArrivage, produitformateConcerne,
                    pointvente)){
                case -1: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date du jour doit etre ulterieure a la date de livraison");
                case 0: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "Le produit doit appartenir au point de vente precise");
            }
            ArrivageProduitformate arrivageProduitformateAEnreg = new ArrivageProduitformate();
            arrivageProduitformateAEnreg.setTypeArrivage(TypeArrivage.arrivagePonctuelEspece);
            arrivageProduitformateAEnreg.setProduitformateConcerne(produitformateConcerne);
            arrivageProduitformateAEnreg.setPointvente(pointvente);
            arrivageProduitformateAEnreg.setDateheurelivraisonArrivage(dateheurelivraisonArrivage);
            return arrivageProduitformateRepository.save(arrivageProduitformateAEnreg);
        }
        else if(perissable == 1){
            switch (isArrivageProduitMalFormed(dateheurelivraisonArrivage, dateperemption, dateseuilperemption,
                    produitformateConcerne, pointvente)){
                case -4: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date de peremption doit etre ulterieure a la date seuil de peremption");
                case -3: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date seuil de peremption doit etre ulterieure a la date du jour");
                case -2: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date de peremption doit etre ulterieure a la date de livraison");
                case -1: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "La date du jour doit etre ulterieure a la date de livraison");
                case 0: throw  new ArrivageproduitInPointventeMalFormedException("Exception levee: " +
                        "Le produit doit appartenir au point de vente");
            }
            ArrivageProduitformate arrivageProduitformateAEnreg = new ArrivageProduitformate();
            arrivageProduitformateAEnreg.setTypeArrivage(TypeArrivage.arrivagePonctuelEspece);
            arrivageProduitformateAEnreg.setProduitformateConcerne(produitformateConcerne);
            arrivageProduitformateAEnreg.setPointvente(pointvente);
            arrivageProduitformateAEnreg.setDateheurelivraisonArrivage(dateheurelivraisonArrivage);
            arrivageProduitformateAEnreg.setDateseuilperemption(dateseuilperemption);
            arrivageProduitformateAEnreg.setDateperemption(dateperemption);
            return arrivageProduitformateRepository.save(arrivageProduitformateAEnreg);
        }
        else{
            throw new ArrivageProduitformateException("Exception levee: Un produit ne saurait etre ni perissable " +
                    "ni non perissable");
        }
    }


}

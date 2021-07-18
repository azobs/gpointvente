package org.c2psi.gpointvente.services.facture.factureappro;

import org.c2psi.gpointvente.dao.facture.factureAppro.FactureapproRepository;
import org.c2psi.gpointvente.entities.facture.Facture;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.entities.produit.ArrivageProduitformate;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.c2psi.gpointvente.exceptions.facture.FactureapproMalFormedException;
import org.c2psi.gpointvente.exceptions.facture.FactureapproNonUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FactureapproServiceImplementation implements FactureapproService {
    @Autowired
    FactureapproRepository factureapproRepository;


    @Override
    public int isFactureapproMalFormed(Date dateFacture, Date dateenregFacture) {
        return dateFacture.compareTo(dateenregFacture)<=0?1:0;
    }

    @Override
    public int addArrivageProduitToFactureappro(ArrivageProduitformate arrivageProduitformate,
                                                Factureappro factureappro) {
        factureappro.getListofArrivageProduitformate().add(arrivageProduitformate);
        factureapproRepository.save(factureappro);
        System.out.println("L'association de l'arrivage du produit a la facture appro a ete faite avec success");
        return 1;
    }

    @Override
    public int isFactureapproUnique(String numeroFacture, String typeFactureappro) {
        return getListofFactureapproByNumerofactureAndTypeFacture(numeroFacture, typeFactureappro).size()==0?1:0;
    }

    @Override
    public Optional<Factureappro> findFactureapproByIdFactureappro(String idfactureappro) {
        return factureapproRepository.findFactureapproByIdFactureappro(idfactureappro);
    }

    @Override
    public List<Factureappro> getListofFactureapproByNumerofactureAndTypeFacture(String numeroFacture, String typeFactureappro) {
        return factureapproRepository.findAllByNumeroFactureAndTypeFactureapproOrderByDateFactureappro(
                numeroFacture, typeFactureappro);
    }

    @Override
    public Optional<Factureappro> findFactureapproByNumerofactureAndTypeFacture(String numeroFacture,
                                                                                String typeFacture) {
        List<Factureappro> listofFactureappro = getListofFactureapproByNumerofactureAndTypeFacture(
                numeroFacture, typeFacture);
        return listofFactureappro.size()>0? Optional.ofNullable(listofFactureappro.get(0)) :Optional.empty();
    }

    @Override
    public List<Factureappro> getListofFactureapproByDateenregFactureappro(Date dateenregFactureappro) {
        return factureapproRepository.findAllByDateheureenregFactureapproOrderByDateheureenregFactureapproAsc(
                dateenregFactureappro);
    }

    @Override
    public List<Factureappro> getListofFactureapproByDateFactureappro(Date dateFactureappro) {
        return factureapproRepository.findAllByDateFactureapproOrderByDateheureenregFactureapproAsc(
                dateFactureappro);
    }

    @Override
    public List<Factureappro> getListofFactureapproByTypefactureapproAndDateFacture(String typeFactureappro,
                                                                      Date dateFactureappro) {
        return factureapproRepository.
                findAllByTypeFactureapproAndDateFactureapproOrderByDateheureenregFactureapproAsc(
                        typeFactureappro, dateFactureappro);
    }

    @Override
    public List<Factureappro> getListofFactureapproByTypefactureapproAndDateenregFacture(String typeFactureappro,
                                                                                  Date dateenregFactureappro){
        return factureapproRepository.
                findAllByTypeFactureapproAndDateheureenregFactureapproOrderByDateheureenregFactureapproAsc(
                        typeFactureappro, dateenregFactureappro);
    }

    @Override
    public Factureappro saveFactureappro(String numeroFacture, Date dateFacture, Date dateheureenregFacture,
                                         String typeFactureappro,
                                         String observation, Facture factureAssocie,
                                         Fournisseur fournisseur)
            throws FactureapproMalFormedException, FactureapproNonUniqueException {
        if(isFactureapproMalFormed(dateFacture, dateheureenregFacture)==0){
            throw new FactureapproMalFormedException("Exception levee: La date d'enregistrement de la facture " +
                    " ne saurait etre antérieur à la date que porte la facture");
        }

        if(isFactureapproUnique(numeroFacture, typeFactureappro)==0){
            throw new FactureapproNonUniqueException("Exception levee: On ne saurait avoir 02 facture de même " +
                    "numero et le meme type");
        }

        Factureappro factureappro = new Factureappro();
        factureappro.setNumeroFacture(numeroFacture);
        factureappro.setDateFactureappro(dateFacture);
        factureappro.setDateheureenregFactureappro(dateheureenregFacture);
        factureappro.setTypeFactureappro(typeFactureappro);
        factureappro.setObservationFactureappro(observation);
        factureappro.setFactureAssocie(factureAssocie);
        factureappro.setFournisseurConcerne(fournisseur);
        return factureapproRepository.save(factureappro);
    }
}

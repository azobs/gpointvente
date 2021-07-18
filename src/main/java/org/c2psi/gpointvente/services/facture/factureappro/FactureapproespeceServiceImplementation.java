package org.c2psi.gpointvente.services.facture.factureappro;

import org.c2psi.gpointvente.dao.facture.factureAppro.FactureapproespeceRepository;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapproespece;
import org.c2psi.gpointvente.entities.produit.Arrivageparespece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class FactureapproespeceServiceImplementation implements FactureapproespeceService {
    @Autowired
    FactureapproespeceRepository factureapproespeceRepository;

    @Override
    public Optional<Factureapproespece> findFactureapproespeceByIdFactureapproespece(
            String idFactureapproespece) {
        return factureapproespeceRepository.findFactureapproespeceByIdFactureapproespece(
                idFactureapproespece);
    }

    @Override
    public Factureapproespece saveFactureapproespece(double montantAttendu, double montantverse,
                                                     Factureappro factureappro) {
        Factureapproespece factureapproespece = new Factureapproespece();
        factureapproespece.setFactureapproAssocie(factureappro);
        factureapproespece.setMontantattendu(montantAttendu);
        factureapproespece.setMontantverse(montantverse);
        return factureapproespeceRepository.save(factureapproespece);
    }

    @Override
    public int addArrivageparespeceToFactureapproespece(Arrivageparespece arrivageparespece, Factureapproespece factureapproespece) {
        factureapproespece.getListofArrivageespece().add(arrivageparespece);
        factureapproespeceRepository.save(factureapproespece);
        System.out.println("L'association de l'arrivageparespece a la factureapproespece a ete realise");
        return 1;
    }
}

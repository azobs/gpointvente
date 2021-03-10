package org.c2psi.gpointvente.services.facture.factureappro;

import org.c2psi.gpointvente.dao.facture.factureAppro.FactureapprocapsuleRepository;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.c2psi.gpointvente.entities.facture.factureAppro.Factureapprocapsule;
import org.c2psi.gpointvente.entities.produit.Arrivageparcapsule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class FactureapprocapsuleServiceImplementation implements FactureapprocapsuleService {
    @Autowired
    FactureapprocapsuleRepository factureapprocapsuleRepository;

    @Override
    public Optional<Factureapprocapsule> findFactureapprocapsuleByIdFactureapprocapsule(String idFactureapprocapsule) {
        return factureapprocapsuleRepository.findFactureapprocapsuleByIdfactureapprocapsule(
                idFactureapprocapsule
        );
    }

    @Override
    public Factureapprocapsule saveFactureapprocapsule(double estimationValeur, int nbrecapsuleAchange,
                                                       int nbrecapsuleChange, Factureappro factureappro) {
        Factureapprocapsule factureapprocapsule = new Factureapprocapsule();
        factureapprocapsule.setEstimationvaleur(estimationValeur);
        factureapprocapsule.setFactureapproAssocie(factureappro);
        factureapprocapsule.setNbrecapsuleAchange(nbrecapsuleAchange);
        factureapprocapsule.setNbrecapsulechange(nbrecapsuleChange);
        return factureapprocapsuleRepository.save(factureapprocapsule);
    }

    @Override
    public int addArrivageparcapsuleToFactureapprocaspule(Arrivageparcapsule arrivageparcapsule, Factureapprocapsule factureapprocapsule) {
        factureapprocapsule.getListofArrivagecapsule().add(arrivageparcapsule);
        factureapprocapsuleRepository.save(factureapprocapsule);
        System.out.println("L'association de l'arrivageparcapsule a la factureapprocapsule a ete realisee");
        return 1;
    }
}

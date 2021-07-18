package org.c2psi.gpointvente.services.facture;

import org.c2psi.gpointvente.constantes.TypeFacture;
import org.c2psi.gpointvente.dao.facture.FactureRepository;
import org.c2psi.gpointvente.entities.facture.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FactureServiceImplementation implements FactureService{
    @Autowired
    FactureRepository factureRepository;


    @Override
    public List<String> getListTypeFacture() {
        List<String> listofTypefacture = new ArrayList<>();
        listofTypefacture.add(TypeFacture.factureAppro);
        listofTypefacture.add(TypeFacture.factureVente);
        return listofTypefacture;
    }

    @Override
    public Facture saveFacture(String typeFacture) {
        Facture facture = new Facture();
        facture.setTypeFacture(typeFacture);

        return factureRepository.save(facture);
    }
}

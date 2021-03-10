package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.dao.produit.ComptecapsulePvRepository;
import org.c2psi.gpointvente.entities.produit.ComptecapsulePv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComptecapsulePvServiceImplementation implements ComptecapsulePvService{
    @Autowired
    ComptecapsulePvRepository comptecapsulePvRepository;


    @Override
    public ComptecapsulePv saveComptecapsulePv(int nbrecapsuleInitial) {
        ComptecapsulePv comptecapsulePv = new ComptecapsulePv();
        comptecapsulePv.setSoldecapsulePv(nbrecapsuleInitial);
        ComptecapsulePv ccPv = comptecapsulePvRepository.save(comptecapsulePv);
        return ccPv;
    }

    @Override
    public ComptecapsulePv getComptecapsulePv(String idComptecapsulePv) {
        return null;
    }
}

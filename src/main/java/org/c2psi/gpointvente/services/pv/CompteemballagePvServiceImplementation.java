package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.dao.pv.CompteemballagePvRepository;
import org.c2psi.gpointvente.entities.pv.CompteemballagePv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteemballagePvServiceImplementation implements CompteemballagePvService {
    @Autowired
    CompteemballagePvRepository compteemballagePvRepository;

    @Override
    public CompteemballagePv saveCompteemballagePv(int nbreEmballageInitial) {
        CompteemballagePv compteemballagePv = new CompteemballagePv();
        compteemballagePv.setSoldeinitial(nbreEmballageInitial);
        compteemballagePv.setCommentaire("Création du compte d'emballage associé au type d'emballage");
        CompteemballagePv cePv = compteemballagePvRepository.save(compteemballagePv);
        return cePv;
    }

    @Override
    public CompteemballagePv updateCompteemballagePv(String idCompteemballagePv, int nbreEmballage) {
        return null;
    }

    @Override
    public CompteemballagePv updateCompteemballagePv(CompteemballagePv compteemballagePv) {
        return null;
    }

    @Override
    public CompteemballagePv getCompteemballagePv(String idCompteemballagePv) {
        return null;
    }
}

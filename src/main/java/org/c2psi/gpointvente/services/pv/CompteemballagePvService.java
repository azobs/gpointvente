package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.entities.pv.CompteemballagePv;

public interface CompteemballagePvService {
    CompteemballagePv saveCompteemballagePv(int nbreEmballageInitial);
    CompteemballagePv updateCompteemballagePv(String idCompteemballagePv, int nbreEmballage);
    CompteemballagePv updateCompteemballagePv(CompteemballagePv compteemballagePv);
    CompteemballagePv getCompteemballagePv(String idCompteemballagePv);
}

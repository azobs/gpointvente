package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.entities.produit.ComptecapsulePv;


public interface ComptecapsulePvService {
    ComptecapsulePv saveComptecapsulePv(int nbrecapsuleInitial);
    ComptecapsulePv getComptecapsulePv(String idComptecapsulePv);
}

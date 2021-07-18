package org.c2psi.gpointvente.services.facture;

import org.c2psi.gpointvente.entities.facture.Facture;

import java.util.List;

public interface FactureService {
    List<String> getListTypeFacture();
    Facture saveFacture(String typeFacture);
}

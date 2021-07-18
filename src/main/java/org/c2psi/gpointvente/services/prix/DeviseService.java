package org.c2psi.gpointvente.services.prix;

import org.c2psi.gpointvente.entities.prix.Devise;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.prix.RegleconversionDevise;
import org.c2psi.gpointvente.exceptions.prix.DeviseNotFoundException;
import org.c2psi.gpointvente.exceptions.prix.RegleconversionDeviseMalFormedException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DeviseService {
    int addDeviseToPointvente(Devise devise, Pointvente pointvente);
    Optional<Devise> getDeviseByIdDevise(String idDevise);
    Devise saveDevise(String libelleDeviseEN, String libelleDeviseFR, String abbreviationDeviseEN,
                      String abbreviationDeviseFR, String formataffichageDevise, boolean isDevisepardefaut,
                      Pointvente pointvente);

    Devise updateDevise(String idOldDevise, String newlibelleDeviseEN, String newlibelleDeviseFR,
                        String newabbreviationDeviseEN, String newabbreviationDeviseFR,
                        String newformataffichageDevise) throws DeviseNotFoundException;

    Devise updateDevise(String idOlddevise, Devise newDevise) throws DeviseNotFoundException;

    int setToDefaultDevise(String idOlddevise) throws DeviseNotFoundException;

    RegleconversionDevise saveRegleconversionDevise(String idDevisemultiple, String idDevisesousmultiple,
                                                    Double facteurconversion)
            throws RegleconversionDeviseMalFormedException, DeviseNotFoundException;

    RegleconversionDevise saveRegleconversionDevise(Devise devisemultiple, Devise devisesousmultiple,
                                                    Double facteurconversion)
            throws RegleconversionDeviseMalFormedException;

    int deleteDevise(String idDevise);

    List<Devise> getListofDevise(int ordre);
    List<Devise> getListofDevisePointvente(String idPointvente, int ordre);
    List<Devise> getListofDevise(String motCle, int ordre);
    Page<Devise> getPageofDevise(int numPage, int taillePage, int ordre);
    Page<Devise> getPageofDevisePointvente(String idPointvente, int numPage, int taillePage,  int ordre);
    Page<Devise> getPageofDevise(String motCle, int numPage, int taillePage,  int ordre);
}

package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.entities.pv.Adresse;
import org.c2psi.gpointvente.entities.tier.Tier;
import org.c2psi.gpointvente.entities.user.Utilisateur;
import org.c2psi.gpointvente.exceptions.pv.AdresseNotFoundException;

import java.util.Optional;

public interface AdresseService {
    Adresse saveAdresse(String numtel1Adr, String numtel2Adr, String numtel3Adr, String emailAdr,
                        String quartierAdr, String villeAdr, String paysAdr, String planlocalisationAdr);

    Adresse updateAdresse(String idOldAdressepv, String newnumtel1Adr, String newnumtel2Adr,
                                    String newnumtel3Adr, String newemailAdr, String newquartierAdr,
                                    String newvilleAdr, String newpaysAdr, String newplanlocalisationAdr)
            throws AdresseNotFoundException;

    Adresse updateAdresse (String idOldAdressepv, Adresse newAdressepv) throws AdresseNotFoundException;

    Adresse saveAdresseutilisateur(String numtel1Adr, String numtel2Adr, String numtel3Adr, String emailAdr,
                                   String quartierAdr, String villeAdr, String paysAdr,
                                   String planlocalisationAdr, Utilisateur user);

    Adresse saveAdresseTier(String numtel1Adr, String numtel2Adr, String numtel3Adr, String emailAdr,
                            String quartierAdr, String villeAdr, String paysAdr,
                            String planlocalisationAdr, Tier tier);

    int deleteAdresse(String idAdresse);
    Optional<Adresse> findAdresseByIdadresse(String idAdresse);
}

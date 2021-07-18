package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.dao.pv.AdresseRepository;
import org.c2psi.gpointvente.entities.pv.Adresse;
import org.c2psi.gpointvente.entities.tier.Tier;
import org.c2psi.gpointvente.entities.user.Utilisateur;
import org.c2psi.gpointvente.exceptions.pv.AdresseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdresseServiceImplementation implements AdresseService{

    @Autowired
    AdresseRepository adresseRepository;
    @Override
    public Adresse saveAdresse(String numtel1Adr, String numtel2Adr, String numtel3Adr, String emailAdr,
                                         String quartierAdr, String villeAdr, String paysAdr,
                                         String planlocalisationAdr) {
        Adresse adresse = new Adresse();
        adresse.setEmailAdr(emailAdr);
        adresse.setNumtel1Adr(numtel1Adr);
        adresse.setNumtel2Adr(numtel2Adr);
        adresse.setNumtel3Adr(numtel3Adr);
        adresse.setPaysAdr(paysAdr);
        adresse.setPlanlocalisationAdr(planlocalisationAdr);
        adresse.setQuartierAdr(quartierAdr);
        adresse.setVilleAdr(villeAdr);

        Adresse aE = adresseRepository.save(adresse);
        return aE;
    }

    @Override
    public Adresse updateAdresse(String idOldAdressepv, String newnumtel1Adr, String newnumtel2Adr,
                                 String newnumtel3Adr, String newemailAdr, String newquartierAdr,
                                 String newvilleAdr, String newpaysAdr, String newplanlocalisationAdr)
            throws AdresseNotFoundException {
        Optional<Adresse> adresseAModifier = adresseRepository.findAdresseByIdAdresse(idOldAdressepv);
        if(adresseAModifier.isPresent()){
            adresseAModifier.get().setEmailAdr(newemailAdr);
            adresseAModifier.get().setNumtel1Adr(newnumtel1Adr);
            adresseAModifier.get().setNumtel2Adr(newnumtel2Adr);
            adresseAModifier.get().setNumtel3Adr(newnumtel3Adr);
            adresseAModifier.get().setPaysAdr(newpaysAdr);
            adresseAModifier.get().setPlanlocalisationAdr(newplanlocalisationAdr);
            adresseAModifier.get().setQuartierAdr(newquartierAdr);
            adresseAModifier.get().setVilleAdr(newvilleAdr);

            Adresse aE = adresseRepository.save(adresseAModifier.get());
            return aE;
        }
        else{
            throw new AdresseNotFoundException("L'adresse que vous voulez modifier est inexistante");
        }
    }

    @Override
    public Adresse updateAdresse(String idOldAdressepv, Adresse newAdressepv) throws AdresseNotFoundException {
        return this.updateAdresse(idOldAdressepv, newAdressepv.getNumtel1Adr(), newAdressepv.getNumtel2Adr(),
                newAdressepv.getNumtel3Adr(), newAdressepv.getEmailAdr(), newAdressepv.getQuartierAdr(),
                newAdressepv.getVilleAdr(), newAdressepv.getPaysAdr(), newAdressepv.getPlanlocalisationAdr());
    }

    @Override
    public Adresse saveAdresseutilisateur(String numtel1Adr, String numtel2Adr, String numtel3Adr, String emailAdr, String quartierAdr, String villeAdr, String paysAdr, String planlocalisationAdr, Utilisateur user) {
        return null;
    }

    @Override
    public Adresse saveAdresseTier(String numtel1Adr, String numtel2Adr, String numtel3Adr, String emailAdr, String quartierAdr, String villeAdr, String paysAdr, String planlocalisationAdr, Tier tier) {
        return null;
    }

    @Override
    public int deleteAdresse(String idAdresse) {
        return 0;
    }

    @Override
    public Optional<Adresse> findAdresseByIdadresse(String idAdresse) {
        return adresseRepository.findAdresseByIdAdresse(idAdresse);
    }
}

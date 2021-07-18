package org.c2psi.gpointvente.services.tier;

import org.c2psi.gpointvente.dao.tier.FournirRepository;
import org.c2psi.gpointvente.dao.tier.FournisseurRepository;
import org.c2psi.gpointvente.dao.tier.TierRepository;
import org.c2psi.gpointvente.entities.pv.Adresse;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.tier.Fournir;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.c2psi.gpointvente.entities.tier.Tier;
import org.c2psi.gpointvente.exceptions.tier.TierExistInPointventeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TierServiceImplementation implements TierService {
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    FournirRepository fournirRepository;
    @Autowired
    TierRepository tierRepository;

    @Override
    public int isFournisseurOfPointvente(Fournisseur fournisseur, Pointvente pointvente) {
        List<Fournir> listofFournisseurDePointvente =
                fournirRepository.findAllByFournisseurAndPointvente(fournisseur, pointvente);

        return listofFournisseurDePointvente.size()==0?1:0;
    }

    @Override
    public int isCoupleTierNatureUniqueInPointvente(String nomsTier, String natureTier,
                                                    Pointvente pointvente) {
        /*
        On cherche par la ligne suivante la liste de tous les fournisseurs qui existe deja dans
        le point de vente
         */
        List<Fournir> listofFournisseurPointvente = fournirRepository.findAllByPointvente(pointvente);
        for(Fournir f: listofFournisseurPointvente){
            String nomsTier1 = f.getFournisseur().getTierFournisseur().getNomsTier();
            String natureTier1 = f.getFournisseur().getTierFournisseur().getNatureTier();
            if(nomsTier1.equalsIgnoreCase(nomsTier) && natureTier1.equalsIgnoreCase(natureTier)){
                /*
                Alors on a trouver que les parametres du fournisseur qu'on veut ajouter sont identique
                a celle d'un fournisseur qui est deja enregistrer dans le meme point de vente
                 */
                return 0;
            }
        }
        return 1;
    }

    @Override
    public Fournisseur saveFournisseur(Tier tierFournisseur) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setTierFournisseur(tierFournisseur);
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Tier saveTier(String nomsTier, String aliasTier, String natureTier,
                         String languepardefautTier, Adresse adresseTier, Date dateenregTierPointvente,
                         String observation, Pointvente pointvente)  throws TierExistInPointventeException {
        /*
        Verifier que le couple nomsTier et natureTier est unique
         */
        if(isCoupleTierNatureUniqueInPointvente(nomsTier, natureTier, pointvente)==0){
            throw new TierExistInPointventeException("Exception levee: Le tier existe deja dans la meme avec " +
                    "la meme nature dans le point de vente");
        }
        Tier tier = new Tier();
        tier.setAdresseTier(adresseTier);
        tier.setAliasTier(aliasTier);
        tier.setDateenregTierPointvente(dateenregTierPointvente);
        tier.setLanguepardefautTier(languepardefautTier);
        tier.setNatureTier(natureTier);
        tier.setNomsTier(nomsTier);
        tier.setObservation(observation);
        tier.setPointvente(pointvente);
        return tierRepository.save(tier);
    }

    @Override
    public Fournir saveFournir(Fournisseur fournisseur, Pointvente pointvente)
            throws TierExistInPointventeException {
        if(isFournisseurOfPointvente(fournisseur, pointvente)==0){
            throw new TierExistInPointventeException("Exception levee: Le fournisseur est deja enregistre " +
                    "dans le point de vente");
        }

        Fournir fournir = new Fournir();
        fournir.setFournisseur(fournisseur);
        fournir.setPointvente(pointvente);
        return fournirRepository.save(fournir);
    }

    @Override
    public Optional<Tier> findTierByIdTier(String idTier) {
        return tierRepository.findTierByIdTier(idTier);
    }

    @Override
    public List<Tier> findAllByNomsTierAndNatureTier(String nomsTier, String natureTier) {
        return tierRepository.findAllByNomsTierAndNatureTier(nomsTier, natureTier);
    }

    @Override
    public List<Fournisseur> findFournisseurByTierFournisseur(Tier tierFournisseur) {
        return fournisseurRepository.findFournisseurByTierFournisseur(tierFournisseur);
    }

    @Override
    public Optional<Fournisseur> findFournisseurByNomstierAndNatureTier(String nomsTier, String natureTier) {
        List<Tier> listofTier = findAllByNomsTierAndNatureTier(nomsTier, natureTier);
        if(listofTier.size()>0){
            Tier tierAssocie = listofTier.get(0);
            List<Fournisseur> listofFournisseurAssocie = findFournisseurByTierFournisseur(tierAssocie);
            if(listofFournisseurAssocie.size()>0){
                Fournisseur fournisseurAssocie = listofFournisseurAssocie.get(0);
                return Optional.ofNullable(fournisseurAssocie);
            }
        }
        return Optional.empty();
    }
}

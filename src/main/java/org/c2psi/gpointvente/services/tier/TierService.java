package org.c2psi.gpointvente.services.tier;

import org.c2psi.gpointvente.entities.pv.Adresse;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.tier.Fournir;
import org.c2psi.gpointvente.entities.tier.Fournisseur;
import org.c2psi.gpointvente.entities.tier.Tier;
import org.c2psi.gpointvente.exceptions.tier.TierExistInPointventeException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TierService {
    int isFournisseurOfPointvente(Fournisseur fournisseur, Pointvente pointvente);
    int isCoupleTierNatureUniqueInPointvente(String nomsTier, String natureTier, Pointvente pointvente);
    Fournisseur saveFournisseur(Tier tierFournisseur);
    Tier saveTier(String nomsTier, String aliasTier, String natureTier, String languepardefautTier,
                  Adresse adresseTier, Date dateenregTierPointvente, String observation,
                  Pointvente pointvente) throws TierExistInPointventeException;;
    Fournir saveFournir(Fournisseur fournisseur, Pointvente pointvente) throws TierExistInPointventeException;
    Optional<Tier> findTierByIdTier(String idTier);
    List<Tier> findAllByNomsTierAndNatureTier(String nomsTier, String natureTier);
    List<Fournisseur> findFournisseurByTierFournisseur(Tier tierFournisseur);
    Optional<Fournisseur> findFournisseurByNomstierAndNatureTier(String nomsTier, String natureTier);
}

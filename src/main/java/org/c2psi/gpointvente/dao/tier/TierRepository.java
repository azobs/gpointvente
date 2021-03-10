package org.c2psi.gpointvente.dao.tier;

import org.c2psi.gpointvente.entities.tier.Tier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TierRepository extends MongoRepository<Tier, String> {
    Optional<Tier> findTierByIdTier(String idTier);
    List<Tier> findAllByNomsTierAndNatureTier(String nomsTier, String natureTier);
}

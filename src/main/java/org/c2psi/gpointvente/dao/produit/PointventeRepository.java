package org.c2psi.gpointvente.dao.produit;

import org.c2psi.gpointvente.entities.pv.Entreprise;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface PointventeRepository extends MongoRepository<Pointvente, String> {
   Optional<Pointvente> findPointventeByIdPointvente(String idPointvente);

   List<Pointvente> findAllByOrderByDenominationPvAsc();
   Page<Pointvente> findAllByOrderByDenominationPvAsc(Pageable pageable);
   List<Pointvente> findAllByOrderByDenominationPvDesc();
   Page<Pointvente> findAllByOrderByDenominationPvDesc(Pageable pageable);

   List<Pointvente> findAllByDenominationPvContainingOrderByDenominationPvAsc(String motCle);
   List<Pointvente> findAllByDenominationPvContainingOrderByDenominationPvDesc(String motCle);

   List<Pointvente> findAllByDenominationPvOrderByDenominationPv(String denominationPv);
   List<Pointvente> findAllByDenominationPvAndEntreprisePv(String denominationPv, Entreprise entreprisePv);
   List<Pointvente> findAllByDenominationPvOrderByDenominationPvAsc(String denominationPv);
   List<Pointvente> findAllByDenominationPvOrderByDenominationPvDesc(String denominationPv);
   @Query("SELECT pv FROM Pointvente pv WHERE " +
           " pv.entreprisePv.idEntreprise=:idEntreprise " +
           " ORDER BY pv.denominationPv ASC")
   List<Pointvente> getListofPointventeEntrepriseOrderByDenominationAsc(
           @Param("idEntreprise") String idEntreprise);
   @Query("SELECT pv FROM Pointvente pv WHERE " +
           " pv.entreprisePv.idEntreprise=:idEntreprise " +
           " ORDER BY pv.denominationPv ASC")
   Page<Pointvente> getPageofPointventeEntrepriseOrderByDenominationAsc(
           @Param("idEntreprise") String idEntreprise, Pageable pageable);

   @Query("SELECT pv FROM Pointvente pv WHERE " +
           " pv.entreprisePv.idEntreprise=:idEntreprise " +
           " pv.denominationPv LIKE :motCle " +
           " ORDER BY pv.denominationPv ASC")
   List<Pointvente> getListofPointventeEntrepriseOrderByDenominationAsc_Contains(
           @Param("idEntreprise") String idEntreprise, @Param("motCle") String motCle);

   @Query("SELECT pv FROM Pointvente pv WHERE " +
           " pv.entreprisePv.idEntreprise=:idEntreprise " +
           " ORDER BY pv.denominationPv DESC")
   List<Pointvente> getListofPointventeEntrepriseOrderByDenominationDesc(
           @Param("idEntreprise") String idEntreprise);

   @Query("SELECT pv FROM Pointvente pv WHERE " +
           " pv.entreprisePv.idEntreprise=:idEntreprise " +
           " ORDER BY pv.denominationPv DESC")
   Page<Pointvente> getPageofPointventeEntrepriseOrderByDenominationDesc(
           @Param("idEntreprise") String idEntreprise, Pageable pageable);

   @Query("SELECT pv FROM Pointvente pv WHERE " +
           " pv.entreprisePv.idEntreprise=:idEntreprise " +
           " pv.denominationPv LIKE :motCle " +
           " ORDER BY pv.denominationPv DESC")
   List<Pointvente> getListofPointventeEntrepriseOrderByDenominationDesc_Contains(
           @Param("idEntreprise") String idEntreprise, @Param("motCle") String motCle);

   @Query("SELECT pv FROM Pointvente pv "+
           " ORDER BY pv.entreprisePv.sigleEntr Asc")
   List<Pointvente> findAllByOrderBySigleEntrAsc();

   @Query("SELECT pv FROM Pointvente pv "+
           " ORDER BY pv.entreprisePv.sigleEntr DESC")
   List<Pointvente> findAllByOrderBySigleEntrDesc();


   @Query("SELECT pv FROM Pointvente pv "+
           " ORDER BY pv.entreprisePv.sigleEntr Asc")
   Page<Pointvente> findAllByOrderBySigleEntrAsc(Pageable pageable);

   @Query("SELECT pv FROM Pointvente pv "+
           " ORDER BY pv.entreprisePv.sigleEntr DESC")
   Page<Pointvente> findAllByOrderBySigleEntrDesc(Pageable pageable);

}

package org.c2psi.gpointvente.dao.pv;

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
public interface EntrepriseRepository extends MongoRepository<Entreprise, String> {
    Optional<Entreprise> findEntrepriseBySigleEntr(String sigleEntr);
    Optional<Entreprise> findEntrepriseByIdEntreprise(String idEntreprise);

    @Query("SELECT pv FROM Pointvente pv WHERE " +
            " pv.entreprisePv.idEntreprise=:idEntreprise " +
            " ORDER BY pv.denominationPv ASC")
    List<Pointvente> getListofPointventeEntrepriseOrderByDenominationAsc(
            @Param("idEntreprise") String idEntreprise);
    @Query("SELECT pv FROM Pointvente pv WHERE " +
            " pv.entreprisePv.idEntreprise=:idEntreprise " +
            " ORDER BY pv.denominationPv DESC")
    List<Pointvente> getListofPointventeEntrepriseOrderByDenominationDesc(
            @Param("idEntreprise") String idEntreprise);
    @Query("SELECT pv FROM Pointvente pv WHERE " +
            " pv.entreprisePv.idEntreprise=:idEntreprise " +
            " ORDER BY pv.denominationPv ASC")
    Page<Pointvente> getPageofPointventeEntrepriseOrderByDenominationAsc(
            @Param("idEntreprise") String idEntreprise, Pageable pageable);
    @Query("SELECT pv FROM Pointvente pv WHERE " +
            " pv.entreprisePv.idEntreprise=:idEntreprise " +
            " ORDER BY pv.denominationPv DESC")
    Page<Pointvente> getPageofPointventeEntrepriseOrderByDenominationDesc(
            @Param("idEntreprise") String idEntreprise, Pageable pageable);

    List<Entreprise> findAllByOrderByRaisonsocialeEntrAscSigleEntrAscDeviseEntrAsc();
    Page<Entreprise> findAllByOrderByRaisonsocialeEntrAscSigleEntrAscDeviseEntrAsc(Pageable pageable);
    List<Entreprise> findAllByOrderByRaisonsocialeEntrDescSigleEntrAscDeviseEntrAsc();
    Page<Entreprise> findAllByOrderByRaisonsocialeEntrDescSigleEntrAscDeviseEntrAsc(Pageable pageable);

    List<Entreprise> findAllByOrderBySigleEntrAscRaisonsocialeEntrAscDeviseEntrAsc();
    Page<Entreprise> findAllByOrderBySigleEntrAscRaisonsocialeEntrAscDeviseEntrAsc(Pageable pageable);
    List<Entreprise> findAllByOrderBySigleEntrDescRaisonsocialeEntrAscDeviseEntrAsc();
    Page<Entreprise> findAllByOrderBySigleEntrDescRaisonsocialeEntrAscDeviseEntrAsc(Pageable pageable);
    Page<Entreprise> findAllByOrderByNbrePointventeAscSigleEntrAsc(Pageable pageable);
    Page<Entreprise> findAllByOrderByNbrePointventeDescSigleEntrAsc(Pageable pageable);

}

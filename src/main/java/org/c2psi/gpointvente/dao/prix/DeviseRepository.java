package org.c2psi.gpointvente.dao.prix;

import org.c2psi.gpointvente.entities.prix.Devise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface DeviseRepository extends MongoRepository<Devise, String> {
    Optional<Devise> findDeviseByIdDevise(String idDevise);
    List<Devise> findAllByOrderByAbbreviationDeviseENAsc();
    Page<Devise> findAllByOrderByAbbreviationDeviseENAsc(Pageable pageable);
    List<Devise> findAllByOrderByAbbreviationDeviseENDesc();
    Page<Devise> findAllByOrderByAbbreviationDeviseENDesc(Pageable pageable);
    List<Devise> findAllByOrderByLibelleDeviseENAsc();
    Page<Devise> findAllByOrderByLibelleDeviseENAsc(Pageable pageable);
    List<Devise> findAllByOrderByLibelleDeviseENDesc();
    Page<Devise> findAllByOrderByLibelleDeviseENDesc(Pageable pageable);
//////////
    List<Devise> findAllByOrderByAbbreviationDeviseFRAsc();
    Page<Devise> findAllByOrderByAbbreviationDeviseFRAsc(Pageable pageable);
    List<Devise> findAllByOrderByAbbreviationDeviseFRDesc();
    Page<Devise> findAllByOrderByAbbreviationDeviseFRDesc(Pageable pageable);
    List<Devise> findAllByOrderByLibelleDeviseFRAsc();
    Page<Devise> findAllByOrderByLibelleDeviseFRAsc(Pageable pageable);
    List<Devise> findAllByOrderByLibelleDeviseFRDesc();
    Page<Devise> findAllByOrderByLibelleDeviseFRDesc(Pageable pageable);
////////////////
    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.libelleDeviseEN ASC")
    List<Devise> getListofDevisePointventeOrderByLibelleDeviseENAsc(@Param("idPointvente") String idPointvente);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.libelleDeviseEN DESC")
    List<Devise> getListofDevisePointventeOrderByLibelleDeviseENDesc(@Param("idPointvente") String idPointvente);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.libelleDeviseEN ASC")
    Page<Devise> getListofDevisePointventeOrderByLibelleDeviseENAsc(@Param("idPointvente") String idPointvente,
                                                                    Pageable pageable);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.libelleDeviseEN DESC")
    Page<Devise> getListofDevisePointventeOrderByLibelleDeviseENDesc(@Param("idPointvente") String idPointvente,
                                                                     Pageable pageable);
/////
    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.libelleDeviseFR ASC")
    List<Devise> getListofDevisePointventeOrderByLibelleDeviseFRAsc(@Param("idPointvente") String idPointvente);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.libelleDeviseFR DESC")
    List<Devise> getListofDevisePointventeOrderByLibelleDeviseFRDesc(@Param("idPointvente") String idPointvente);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.libelleDeviseFR ASC")
    Page<Devise> getListofDevisePointventeOrderByLibelleDeviseFRAsc(@Param("idPointvente") String idPointvente,
                                                                    Pageable pageable);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.libelleDeviseFR DESC")
    Page<Devise> getListofDevisePointventeOrderByLibelleDeviseFRDesc(@Param("idPointvente") String idPointvente,
                                                                     Pageable pageable);
/////
    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.abbreviationDeviseFR ASC")
    List<Devise> getListofDevisePointventeOrderByAbbreviationDeviseFRAsc(@Param("idPointvente") String idPointvente);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.abbreviationDeviseFR DESC")
    List<Devise> getListofDevisePointventeOrderByAbbreviationDeviseFRDesc(@Param("idPointvente") String idPointvente);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.abbreviationDeviseFR ASC")
    Page<Devise> getListofDevisePointventeOrderByAbbreviationDeviseFRAsc(@Param("idPointvente") String idPointvente,
                                                                    Pageable pageable);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.abbreviationDeviseFR DESC")
    Page<Devise> getListofDevisePointventeOrderByAbbreviationDeviseFRDesc(@Param("idPointvente") String idPointvente,
                                                                     Pageable pageable);
    /////
    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.abbreviationDeviseEN ASC")
    List<Devise> getListofDevisePointventeOrderByAbbreviationDeviseENAsc(@Param("idPointvente") String idPointvente);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.abbreviationDeviseEN DESC")
    List<Devise> getListofDevisePointventeOrderByAbbreviationDeviseENDesc(@Param("idPointvente") String idPointvente);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.abbreviationDeviseEN ASC")
    Page<Devise> getListofDevisePointventeOrderByAbbreviationDeviseENAsc(@Param("idPointvente") String idPointvente,
                                                                         Pageable pageable);

    @Query("SELECT dev FROM Devise dev WHERE " +
            " dev.pointvente.idPointvente=:idPointvente " +
            " ORDER BY dev.abbreviationDeviseEN DESC")
    Page<Devise> getListofDevisePointventeOrderByAbbreviationDeviseENDesc(@Param("idPointvente") String idPointvente,
                                                                          Pageable pageable);
}

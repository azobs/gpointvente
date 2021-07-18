package org.c2psi.gpointvente.dao.pv;

import org.c2psi.gpointvente.entities.pv.Typeemballage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface TypeemballageRepository extends MongoRepository<Typeemballage, String> {
    Optional<Typeemballage> findTypeemballageByIdTypeemballage(String idTypeemballage);

    List<Typeemballage> findAllByOrderByDesignationEmballageENAsc();
    Page<Typeemballage> findAllByOrderByDesignationEmballageENAsc(Pageable pageable);
    List<Typeemballage> findAllByOrderByDesignationEmballageENDesc();
    Page<Typeemballage> findAllByOrderByDesignationEmballageENDesc(Pageable pageable);
    List<Typeemballage> findAllByOrderByDesignationEmballageFRAsc();
    Page<Typeemballage> findAllByOrderByDesignationEmballageFRAsc(Pageable pageable);
    List<Typeemballage> findAllByOrderByDesignationEmballageFRDesc();
    Page<Typeemballage> findAllByOrderByDesignationEmballageFRDesc(Pageable pageable);
    List<Typeemballage> findAllByOrderByPrixEmballageAsc();
    Page<Typeemballage> findAllByOrderByPrixEmballageAsc(Pageable pageable);
    List<Typeemballage> findAllByOrderByPrixEmballageDesc();
    Page<Typeemballage> findAllByOrderByPrixEmballageDesc(Pageable pageable);

    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.designationEmballageEN ASC")
    List<Typeemballage> getListofTypeemballagePointventeOrderByDesignationEmballageENAsc(
            @Param("idPointvente") String idPointvente);
    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.designationEmballageEN ASC")
    Page<Typeemballage> getListofTypeemballagePointventeOrderByDesignationEmballageENAsc(
            @Param("idPointvente") String idPointvente, Pageable pageable);
    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.designationEmballageFR ASC")
    List<Typeemballage> getListofTypeemballagePointventeOrderByDesignationEmballageFRAsc(
            @Param("idPointvente") String idPointvente);
    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.designationEmballageFR ASC")
    Page<Typeemballage> getListofTypeemballagePointventeOrderByDesignationEmballageFRAsc(
            @Param("idPointvente") String idPointvente, Pageable pageable);

    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.designationEmballageEN DESC")
    List<Typeemballage> getListofTypeemballagePointventeOrderByDesignationEmballageENDesc(
            @Param("idPointvente") String idPointvente);
    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.designationEmballageEN DESC")
    Page<Typeemballage> getListofTypeemballagePointventeOrderByDesignationEmballageENDesc(
            @Param("idPointvente") String idPointvente, Pageable pageable);
    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.designationEmballageFR DESC")
    List<Typeemballage> getListofTypeemballagePointventeOrderByDesignationEmballageFRDesc(
            @Param("idPointvente") String idPointvente);
    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.designationEmballageFR DESC")
    Page<Typeemballage> getListofTypeemballagePointventeOrderByDesignationEmballageFRDesc(
            @Param("idPointvente") String idPointvente, Pageable pageable);

    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.prixEmballage ASC")
    List<Typeemballage> getListofTypeemballagePointventeOrderByPrixEmballageAsc(
            @Param("idPointvente") String idPointvente);
    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.prixEmballage ASC")
    Page<Typeemballage> getListofTypeemballagePointventeOrderByPrixEmballageAsc(
            @Param("idPointvente") String idPointvente, Pageable pageable);

    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.prixEmballage DESC")
    List<Typeemballage> getListofTypeemballagePointventeOrderByPrixEmballageDesc(
            @Param("idPointvente") String idPointvente);
    @Query("SELECT typeemb FROM Typeemballage typeemb WHERE " +
            " typeemb.pointvente.idPointvente=:idPointvente " +
            " ORDER BY typeemb.prixEmballage DESC")
    Page<Typeemballage> getListofTypeemballagePointventeOrderByPrixEmballageDesc(
            @Param("idPointvente") String idPointvente, Pageable pageable);
}

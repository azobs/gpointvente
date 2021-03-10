package org.c2psi.gpointvente.dao.facture.factureAppro;

import org.c2psi.gpointvente.entities.facture.factureAppro.Factureappro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FactureapproRepository extends MongoRepository<Factureappro, String> {
    Optional<Factureappro> findFactureapproByIdFactureappro(String idFactureappro);
    List<Factureappro> findAllByNumeroFactureAndTypeFactureapproOrderByDateFactureappro(String numeroFacture,
                                                                                         String typeFactureappro);
    List<Factureappro> findAllByDateheureenregFactureapproOrderByDateheureenregFactureapproAsc(
            Date dateheureenregFactureappro);
    List<Factureappro> findAllByDateFactureapproOrderByDateheureenregFactureapproAsc(Date datefactureappro);
    List<Factureappro> findAllByTypeFactureapproAndDateFactureapproOrderByDateheureenregFactureapproAsc(
            String typeFactureappro, Date datefactureappro);
    List<Factureappro> findAllByTypeFactureapproAndDateheureenregFactureapproOrderByDateheureenregFactureapproAsc(
            String typeFactureappro, Date dateheureenregFactureappro);
}

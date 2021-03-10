package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.entities.pv.CompteemballagePv;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.pv.Typeemballage;
import org.c2psi.gpointvente.exceptions.pv.TypeemballageNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TypeemballageService {
    Optional<Typeemballage> getTypeemballlageByIdTypeemballage(String idTypeemballage);
    Typeemballage saveTypeemballage(String designationEmballageEN, String designationEmballageFR,
                                    String descriptionEmballageEN, String descriptionEmballageFR,
                                    String couleurphareEmballage, String photoEmballage, Double prixEmballage,
                                    String matiereEmballage, Pointvente pointvente, CompteemballagePv compteemballagePv);

    Typeemballage updateTypeemballage(String idOldTypeemballage, String newdesignationEmballageEN,
                                      String newdesignationEmballageFR, String newdescriptionEmballageEN,
                                      String newdescriptionEmballageFR, String newcouleurphareEmballage,
                                      String newphotoEmballage, Double newprixEmballage,
                                      String newmatiereEmballage)throws TypeemballageNotFoundException;



    Typeemballage setPhotoEmballage(String idTypeemballage, String photoEmballage)throws TypeemballageNotFoundException;

    List<Typeemballage> getListofTypeemballage(int ordre);
    List<Typeemballage> getListofTypeemballagePointvente(String idPointvente, int ordre);
    Page<Typeemballage> getPageofTypeemballage(int numPage, int taillePage, int ordre);
    Page<Typeemballage> getPageofTypeemballagePointvente(String idPointvente, int numPage, int taillePage, int ordre);
}

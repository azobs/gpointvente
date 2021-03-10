package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.constantes.ConstanteOrdre;
import org.c2psi.gpointvente.dao.pv.TypeemballageRepository;
import org.c2psi.gpointvente.entities.pv.CompteemballagePv;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.entities.pv.Typeemballage;
import org.c2psi.gpointvente.exceptions.pv.TypeemballageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeemballageServiceImplementation implements TypeemballageService {
    @Autowired
    PointventeService pointventeService;
    @Autowired
    TypeemballageRepository typeemballageRepository;

    @Override
    public Optional<Typeemballage> getTypeemballlageByIdTypeemballage(String idTypeemballage){
        return typeemballageRepository.findTypeemballageByIdTypeemballage(idTypeemballage);
    }

    @Override
    public Typeemballage saveTypeemballage(String designationEmballageEN, String designationEmballageFR,
                                           String descriptionEmballageEN, String descriptionEmballageFR,
                                           String couleurphareEmballage, String photoEmballage,
                                           Double prixEmballage, String matiereEmballage, Pointvente pointvente,
                                           CompteemballagePv compteemballagePv) {

        Typeemballage typeemballage = new Typeemballage();
        typeemballage.setCouleurphareEmballage(couleurphareEmballage);
        typeemballage.setDescriptionEmballageEN(descriptionEmballageEN);
        typeemballage.setDescriptionEmballageFR(descriptionEmballageFR);
        typeemballage.setDesignationEmballageEN(designationEmballageEN);
        typeemballage.setDescriptionEmballageFR(designationEmballageFR);
        typeemballage.setPrixEmballage(prixEmballage);
        typeemballage.setMatiereEmballage(matiereEmballage);
        typeemballage.setCompteemballagePv(compteemballagePv);
        typeemballage.setPointvente(pointvente);

        Typeemballage typeemballage1 = typeemballageRepository.save(typeemballage);
        return typeemballage1;
    }

    @Override
    public Typeemballage updateTypeemballage(String idOldTypeemballage, String newdesignationEmballageEN,
                                             String newdesignationEmballageFR, String newdescriptionEmballageEN,
                                             String newdescriptionEmballageFR, String newcouleurphareEmballage,
                                             String newphotoEmballage, Double newprixEmballage,
                                             String newmatiereEmballage)
            throws TypeemballageNotFoundException {
        Optional<Typeemballage> optionalTypeemballage = typeemballageRepository.
                findTypeemballageByIdTypeemballage(idOldTypeemballage);
        if(optionalTypeemballage.isPresent()){
            Typeemballage typeemballageAModifier = optionalTypeemballage.get();
            typeemballageAModifier.setMatiereEmballage(newmatiereEmballage);
            typeemballageAModifier.setPrixEmballage(newprixEmballage);
            typeemballageAModifier.setDescriptionEmballageFR(newdescriptionEmballageFR);
            typeemballageAModifier.setDesignationEmballageEN(newdesignationEmballageEN);
            typeemballageAModifier.setDescriptionEmballageEN(newdescriptionEmballageEN);
            typeemballageAModifier.setDesignationEmballageFR(newdesignationEmballageFR);
            typeemballageAModifier.setCouleurphareEmballage(newcouleurphareEmballage);
            return typeemballageRepository.save(typeemballageAModifier);
        }
        else{
            throw new TypeemballageNotFoundException("Le type d'emballage dont vous demandez la modification " +
                    "est introuvable dans la base de données");
        }
    }

    @Override
    public Typeemballage setPhotoEmballage(String idTypeemballage, String photoEmballage)
            throws TypeemballageNotFoundException {
        return null;
    }

    @Override
    public List<Typeemballage> getListofTypeemballage(int ordre) {
        if(ordre == ConstanteOrdre.DesignationEmballageENCroissant){
            return typeemballageRepository.findAllByOrderByDesignationEmballageENAsc();
        }
        if(ordre == ConstanteOrdre.DesignationEmballageENDecroissant){
            return typeemballageRepository.findAllByOrderByDesignationEmballageENDesc();
        }
        if(ordre == ConstanteOrdre.DesignationEmballageFRCroissant){
            return typeemballageRepository.findAllByOrderByDesignationEmballageFRAsc();
        }
        if(ordre == ConstanteOrdre.DesignationEmballageFRDecroissant){
            return typeemballageRepository.findAllByOrderByDesignationEmballageFRDesc();
        }
        if(ordre == ConstanteOrdre.PrixEmballageCroissant){
            return typeemballageRepository.findAllByOrderByPrixEmballageAsc();
        }
        if(ordre == ConstanteOrdre.PrixEmballageDecroissant){
            return typeemballageRepository.findAllByOrderByPrixEmballageDesc();
        }
        return null;
    }

    @Override
    public List<Typeemballage> getListofTypeemballagePointvente(String idPointvente, int ordre) {
        if(ordre == ConstanteOrdre.DesignationEmballageENCroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByDesignationEmballageENAsc(
                    idPointvente);
        }
        if(ordre == ConstanteOrdre.DesignationEmballageENDecroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByDesignationEmballageENDesc(
                    idPointvente);
        }
        if(ordre == ConstanteOrdre.DesignationEmballageFRCroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByDesignationEmballageFRAsc(
                    idPointvente);
        }
        if(ordre == ConstanteOrdre.DesignationEmballageFRDecroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByDesignationEmballageFRDesc(
                    idPointvente);
        }
        if(ordre == ConstanteOrdre.PrixEmballageCroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByPrixEmballageAsc(idPointvente);
        }
        if(ordre == ConstanteOrdre.PrixEmballageDecroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByPrixEmballageDesc(idPointvente);
        }
        return null;
    }

    @Override
    public Page<Typeemballage> getPageofTypeemballage(int numPage, int taillePage, int ordre) {
        if(ordre == ConstanteOrdre.DesignationEmballageENCroissant){
            return typeemballageRepository.findAllByOrderByDesignationEmballageENAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("designationEmballageEN"))));
        }
        if(ordre == ConstanteOrdre.DesignationEmballageENDecroissant){
            return typeemballageRepository.findAllByOrderByDesignationEmballageENDesc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("designationEmballageEN"))));
        }
        if(ordre == ConstanteOrdre.DesignationEmballageFRCroissant){
            return typeemballageRepository.findAllByOrderByDesignationEmballageFRAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("designationEmballageFR"))));
        }
        if(ordre == ConstanteOrdre.DesignationEmballageFRDecroissant){
            return typeemballageRepository.findAllByOrderByDesignationEmballageFRDesc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("designationEmballageFR"))));
        }
        if(ordre == ConstanteOrdre.PrixEmballageCroissant){
            return typeemballageRepository.findAllByOrderByPrixEmballageAsc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("prixEmballage"))));
        }
        if(ordre == ConstanteOrdre.PrixEmballageDecroissant){
            return typeemballageRepository.findAllByOrderByPrixEmballageDesc(
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("prixEmballage"))));
        }

        return null;
    }

    @Override
    public Page<Typeemballage> getPageofTypeemballagePointvente(String idPointvente, int numPage, int taillePage, int ordre) {
        if(ordre == ConstanteOrdre.DesignationEmballageENCroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByDesignationEmballageENAsc(
                    idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("designationEmballageEN"))));
        }
        if(ordre == ConstanteOrdre.DesignationEmballageENDecroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByDesignationEmballageENDesc(
                    idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("designationEmballageEN"))));
        }
        if(ordre == ConstanteOrdre.DesignationEmballageFRCroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByDesignationEmballageFRAsc(
                    idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("designationEmballageFR"))));
        }
        if(ordre == ConstanteOrdre.DesignationEmballageFRDecroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByDesignationEmballageFRDesc(
                    idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("designationEmballageFR"))));
        }
        if(ordre == ConstanteOrdre.PrixEmballageCroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByPrixEmballageAsc(
                    idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.asc("prixEmballage"))));
        }
        if(ordre == ConstanteOrdre.PrixEmballageDecroissant){
            return typeemballageRepository.getListofTypeemballagePointventeOrderByPrixEmballageDesc(
                    idPointvente,
                    PageRequest.of(numPage, taillePage, Sort.by(
                            Sort.Order.desc("prixEmballage"))));
        }
        return null;
    }
}

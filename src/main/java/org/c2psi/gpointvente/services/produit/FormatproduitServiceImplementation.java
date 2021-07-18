package org.c2psi.gpointvente.services.produit;

import org.c2psi.gpointvente.dao.produit.FormatproduitRepository;
import org.c2psi.gpointvente.entities.produit.Formatproduit;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.produit.FormatproduitNonUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormatproduitServiceImplementation implements FormatproduitService{
    @Autowired
    FormatproduitRepository formatproduitRepository;


    @Override
    public int isFormatproduitENUniqueInPointvente(String contenance, String designationFormatproduit, Pointvente pointvente) {
        List<Formatproduit> listofFormatproduit =
                formatproduitRepository.findAllByContenanceAndDesignationFormatproduitENAndPointventeOrderByContenance(
                        contenance, designationFormatproduit,pointvente);
        return listofFormatproduit.size()==0?1:0;
    }

    @Override
    public int isFormatproduitFRUniqueInPointvente(String contenance, String designationFormatproduit, Pointvente pointvente) {
        List<Formatproduit> listofFormatproduit =
                formatproduitRepository.findAllByContenanceAndDesignationFormatproduitFRAndPointventeOrderByContenance(
                        contenance, designationFormatproduit,pointvente);
        return listofFormatproduit.size()==0?1:0;
    }

    @Override
    public Optional<Formatproduit> getFormatproduitByIdFormatproduit(String idFormatproduit) {
        return formatproduitRepository.findFormatproduitByIdFormatproduit(idFormatproduit);
    }

    @Override
    public Formatproduit saveFormatproduit(String contenance, String designationFormatproduitEN,
                                           String designationFormatproduitFR, Pointvente pointvente)
            throws FormatproduitNonUniqueException {

        if(isFormatproduitENUniqueInPointvente(contenance, designationFormatproduitEN, pointvente)==0){
            throw new FormatproduitNonUniqueException("Exception levee: On ne peut avoir 2 formats dans le meme point " +
                    "de vente avec la meme contenance et la meme designantion en anglais ");
        }
        if(isFormatproduitFRUniqueInPointvente(contenance, designationFormatproduitFR, pointvente)==0){
            throw new FormatproduitNonUniqueException("Exception levee: On ne peut avoir 2 formats dans le meme point " +
                    "de vente avec la meme contenance et la meme designantion en francais ");
        }

        Formatproduit formatproduitAEnreg = new Formatproduit();
        formatproduitAEnreg.setContenance(contenance);
        formatproduitAEnreg.setDesignationFormatproduitEN(designationFormatproduitEN);
        formatproduitAEnreg.setDesignationFormatproduitFR(designationFormatproduitFR);
        formatproduitAEnreg.setPointvente(pointvente);
        Formatproduit formatproduit = formatproduitRepository.save(formatproduitAEnreg);
        return formatproduit;
    }

    @Override
    public Formatproduit saveFormatproduit(Formatproduit formatproduit) {
        return formatproduitRepository.save(formatproduit);
    }
}

package org.c2psi.gpointvente.services.pv;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.dao.pv.CompteprincipalRepository;
import org.c2psi.gpointvente.entities.pv.Compteprincipal;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.c2psi.gpointvente.exceptions.pv.UnchangeableProprietaireOfCompteprincipalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CompteprincipalServiceImplementation implements CompteprincipalService{
    @Autowired
    CompteprincipalRepository compteprincipalRepository;
    @Override
    public Compteprincipal saveCompteprincipal(Double soldeespece) {
        Compteprincipal compteprincipal = new Compteprincipal();
        compteprincipal.setSoldeespece(soldeespece);
        Compteprincipal cP=compteprincipalRepository.save(compteprincipal);
        return cP;
    }

    @Override
    public Compteprincipal updateCompteprincipal(String idCompteprincipal, Double newsoldeespece) {

        return null;
    }

    @Override
    public Compteprincipal updateCompteprincipal(Compteprincipal compteprincipal) {
        return null;
    }

    @Override
    public Compteprincipal getCompteprincipal(String idCompteprincipal) {
        return null;
    }

    @Override
    public int AssocierCompteprincipalAPointvente(Compteprincipal compteprincipal, Pointvente pointvente) throws
            UnchangeableProprietaireOfCompteprincipalException {
        Optional<Pointvente> pointventeProp = Optional.ofNullable(compteprincipal.getPointvente());
        if(pointventeProp.isPresent()){
            /*
            Si on est la alors le compteprincipal pris en parametre a deja un point de vente proprietaire
             */
            System.out.println("pointventeProp == "+pointventeProp.get().toString());
            if(pointventeProp.get().getIdPointvente().equals(pointvente.getIdPointvente())){
                return ValeurRetour.associationCompteprincipalPointventeDejaDefini;
            }
            else{
                /*
                Si on est ici alors le compte parametre est associe a un point de vente qui n'est pas celui
                passe en parametre donc une exception de type UnchangeableProprietaireOfCompteprincipalException
                doit être lance
                 */
                throw new UnchangeableProprietaireOfCompteprincipalException("Ce compte principal est deja " +
                        "associe a un autre point de vente.");
            }
        }
        else{
            /*
            Si on est ici alors le compteprincipal pris en parametre n'a pas encore de point de vente proprietaire
             */
            compteprincipal.setPointvente(pointvente);
            compteprincipalRepository.save(compteprincipal);
            return ValeurRetour.associationCompteprincipalPointventeDefini;

        }
    }
}

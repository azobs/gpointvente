package org.c2psi.gpointvente.controllers.pv;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.entities.pv.Entreprise;
import org.c2psi.gpointvente.forms.FormUpdateEntreprise;
import org.c2psi.gpointvente.services.pv.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EntrepriseController {
    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping("/testAPI")
    public int testAPI(){
        System.out.println("Appel reussi du controlleur de l'api");
        return 1;
    }

    @PostMapping("/enregistrerEntreprise")
    public String enregEntreprise(@Valid @RequestBody FormUpdateEntreprise formUpdateEntreprise,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }

        if(entrepriseService.isSigleEntrUnique(formUpdateEntreprise.getSigleEntr())== ValeurRetour.sigleEntrExist){
            return ValeurRetour.entrepriseExist;
        }

        Entreprise ent = entrepriseService.saveEntreprise(formUpdateEntreprise.getRegimeEntr(),
                formUpdateEntreprise.getRaisonsocialeEntr(),formUpdateEntreprise.getDescriptionEntr(),
                formUpdateEntreprise.getLogoEntr(),formUpdateEntreprise.getDeviseEntr(),
                formUpdateEntreprise.getSigleEntr());
        return ValeurRetour.enregEntrepriseSuccess;

    }

    @RequestMapping(value = "/updateEntreprise", method = RequestMethod.PATCH)
    public String updateEntreprise(@Valid @RequestBody FormUpdateEntreprise formUpdateEntreprise,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList){
                return error.getDefaultMessage();
            }
        }
        try {
            Entreprise entAModifie = entrepriseService.getEntrepriseById(formUpdateEntreprise.getIdEntreprise());
            entrepriseService.updateEntreprise(entAModifie.getIdEntreprise(), formUpdateEntreprise.getRegimeEntr(),
                    formUpdateEntreprise.getRaisonsocialeEntr(), formUpdateEntreprise.getDescriptionEntr(),
                    formUpdateEntreprise.getLogoEntr(), formUpdateEntreprise.getDeviseEntr(),
                    formUpdateEntreprise.getSigleEntr());
            return ValeurRetour.updateEntrepriseSuccess;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            //l'id de l'entreprise est inexistante
            return ValeurRetour.entrepriseNotExist;
        }
    }

    @GetMapping("/getListofEntreprise")
    public List<Entreprise> getListofEntreprise(@RequestParam(name="ordre", defaultValue="0")int ordre){
        List<Entreprise> listofEntreprise = null;
        /***************************************************
         * SigleEntrCroissant=0
         * SigleEntrDecroissant=1
         * RaisonsocialeEntrCroissant=2
         * RaisonsocialeEntrDecroissant=3
         * NbrePointventeCroissant=4
         * NbrePointventeDecroissant=5
         ***************************************************/
        listofEntreprise = entrepriseService.getListofEntreprise(ordre);
        return listofEntreprise;
    }

    @GetMapping("/getPageofEntreprise")
    public Page<Entreprise> getPageofEntreprise(@RequestParam(name="numPage", defaultValue="0")int numPage,
                                                @RequestParam(name="taillePage", defaultValue="1")int taillePage,
                                                @RequestParam(name="ordre", defaultValue="0")int ordre){
        Page<Entreprise> pageofEntreprise = null;
        /***************************************************
         * SigleEntrCroissant=0
         * SigleEntrDecroissant=1
         * RaisonsocialeEntrCroissant=2
         * RaisonsocialeEntrDecroissant=3
         * NbrePointventeCroissant=4
         * NbrePointventeDecroissant=5
         ***************************************************/
        pageofEntreprise = entrepriseService.getPageofEntreprise(numPage, taillePage, ordre);

        return pageofEntreprise;
    }

    @RequestMapping(value = "/deleteEntreprise", method = RequestMethod.DELETE)
    public String deleteEntreprise(@RequestParam(name="idEntreprise", defaultValue="0") String idEntreprise){
        try {
            System.out.println("idEntreprise== "+idEntreprise);
            Entreprise entAModifie = entrepriseService.getEntrepriseById(idEntreprise);
            entrepriseService.deleteEntreprise(idEntreprise);
            return ValeurRetour.deleteEntrepriseSuccess;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            //l'id de l'entreprise est inexistante
            return ValeurRetour.entrepriseNotExist;
        }
    }
}

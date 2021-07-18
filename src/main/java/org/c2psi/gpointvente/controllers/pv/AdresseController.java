package org.c2psi.gpointvente.controllers.pv;

import org.c2psi.gpointvente.constantes.ValeurRetour;
import org.c2psi.gpointvente.forms.formsEnreg.pv.FormEnregAdresse;
import org.c2psi.gpointvente.services.pv.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdresseController {
    @Autowired
    AdresseService adresseService;

    @PostMapping("/enregistrerAdresse")
    public String enregAdresse(@Valid @RequestBody FormEnregAdresse formEnregAdresse,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.toString());
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                return error.getDefaultMessage();
            }
        }
        adresseService.saveAdresse(formEnregAdresse.getNumtel1Adr(), formEnregAdresse.getNumtel2Adr(),
                formEnregAdresse.getNumtel3Adr(), formEnregAdresse.getEmailAdr(), formEnregAdresse.getQuartierAdr(),
                formEnregAdresse.getVilleAdr(), formEnregAdresse.getPaysAdr(),
                formEnregAdresse.getPlanlocalisationAdr());

        return ValeurRetour.adresseEnregSuccess;
    }
}

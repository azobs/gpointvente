package org.c2psi.gpointvente;

import org.c2psi.gpointvente.services.pv.EntrepriseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GpointventeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpointventeApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EntrepriseService entrepriseService){
        return args -> {
            System.out.println("LE PROGRAMME A DEMARRE AVEC SUCCES ET LES ROUTES DANS LES CONTROLEURS " +
                    " PEUVENT DEJA ETRE APPELLE");
            try{
                /*entrepriseService.saveEntreprise("Ets", "DJOUTSA", "Commerce",
                        "", "", "C3PSI");
                entrepriseService
                        .getListofEntreprise(ConstanteOrdre.ordreAlphabetiqueSigleEntrCroissant)
                        .forEach(ent -> {
                            System.out.println(ent.toString());
                        });*/
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println(entrepriseService.getEntrepriseBySigle("C2PSI").toString());
            }
        };
    }

}

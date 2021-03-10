package org.c2psi.gpointvente.entities.user;

import org.c2psi.gpointvente.entities.pv.Entreprise;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Administrateur {
    @Id
    String idAdmin;

    /**
     * Un administrateur est d'abord un utilisateur
     */
    @DBRef
    Utilisateur userAssocie;
    /**
     * Un administrateur administre une entreprise
     */
    @DBRef
    Entreprise entrepriseAdministre;

    public Administrateur() {
    }

    public Administrateur(String idAdmin, Utilisateur userAssocie, Entreprise entrepriseAdministre) {
        this.idAdmin = idAdmin;
        this.userAssocie = userAssocie;
        this.entrepriseAdministre = entrepriseAdministre;
    }

    public Administrateur(Utilisateur userAssocie, Entreprise entrepriseAdministre) {
        this.userAssocie = userAssocie;
        this.entrepriseAdministre = entrepriseAdministre;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Utilisateur getUserAssocie() {
        return userAssocie;
    }

    public void setUserAssocie(Utilisateur userAssocie) {
        this.userAssocie = userAssocie;
    }

    public Entreprise getEntrepriseAdministre() {
        return entrepriseAdministre;
    }

    public void setEntrepriseAdministre(Entreprise entrepriseAdministre) {
        this.entrepriseAdministre = entrepriseAdministre;
    }


}

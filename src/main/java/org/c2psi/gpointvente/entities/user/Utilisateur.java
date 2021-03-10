package org.c2psi.gpointvente.entities.user;

import org.c2psi.gpointvente.entities.pv.Adresse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Utilisateur {
    @Id
    String idUtilisateur;
    String loginUtilisateur;
    String passwordUtilisateur;
    String nomsUtilisateur;
    String prenomsUtilisateur;
    String cniUtilisateur;
    String photoUtilisateur;
    String etatUtilisateur;
    String typeUtilisateur;

    /**
     * L'adresse de l'utilisateur
     */
    @DBRef
    Adresse adresseUtilisateur;

    public Utilisateur() {
    }

    public Utilisateur(String idUtilisateur, String loginUtilisateur, String passwordUtilisateur,
                       String nomsUtilisateur, String prenomsUtilisateur, String cniUtilisateur,
                       String photoUtilisateur, String etatUtilisateur, String typeUtilisateur,
                       Adresse adresseUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.loginUtilisateur = loginUtilisateur;
        this.passwordUtilisateur = passwordUtilisateur;
        this.nomsUtilisateur = nomsUtilisateur;
        this.prenomsUtilisateur = prenomsUtilisateur;
        this.cniUtilisateur = cniUtilisateur;
        this.photoUtilisateur = photoUtilisateur;
        this.etatUtilisateur = etatUtilisateur;
        this.typeUtilisateur = typeUtilisateur;
        this.adresseUtilisateur = adresseUtilisateur;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getLoginUtilisateur() {
        return loginUtilisateur;
    }

    public void setLoginUtilisateur(String loginUtilisateur) {
        this.loginUtilisateur = loginUtilisateur;
    }

    public String getPasswordUtilisateur() {
        return passwordUtilisateur;
    }

    public void setPasswordUtilisateur(String passwordUtilisateur) {
        this.passwordUtilisateur = passwordUtilisateur;
    }

    public String getNomsUtilisateur() {
        return nomsUtilisateur;
    }

    public void setNomsUtilisateur(String nomsUtilisateur) {
        this.nomsUtilisateur = nomsUtilisateur;
    }

    public String getPrenomsUtilisateur() {
        return prenomsUtilisateur;
    }

    public void setPrenomsUtilisateur(String prenomsUtilisateur) {
        this.prenomsUtilisateur = prenomsUtilisateur;
    }

    public String getCniUtilisateur() {
        return cniUtilisateur;
    }

    public void setCniUtilisateur(String cniUtilisateur) {
        this.cniUtilisateur = cniUtilisateur;
    }

    public String getPhotoUtilisateur() {
        return photoUtilisateur;
    }

    public void setPhotoUtilisateur(String photoUtilisateur) {
        this.photoUtilisateur = photoUtilisateur;
    }

    public String getEtatUtilisateur() {
        return etatUtilisateur;
    }

    public void setEtatUtilisateur(String etatUtilisateur) {
        this.etatUtilisateur = etatUtilisateur;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    public Adresse getAdresseUtilisateur() {
        return adresseUtilisateur;
    }

    public void setAdresseUtilisateur(Adresse adresseUtilisateur) {
        this.adresseUtilisateur = adresseUtilisateur;
    }
}

package org.c2psi.gpointvente.entities.tier;

import org.c2psi.gpointvente.entities.pv.Adresse;
import org.c2psi.gpointvente.entities.pv.Pointvente;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Tier {
    @Id
    String idTier;
    String nomsTier;
    String aliasTier;
    String natureTier;//client ou  fournisseur
    String languepardefautTier;
    @DBRef
    Adresse adresseTier;
    Date dateenregTierPointvente;//Puisque chaque tier c'est pour un point de vente
    String observation;

    @DBRef
    Pointvente pointvente;

    public Tier() {
    }

    public Tier(String idTier, String nomsTier, String aliasTier, String natureTier,
                String languepardefautTier, Adresse adresseTier, Date dateenregTierPointvente,
                Pointvente pointvente) {
        this.idTier = idTier;
        this.nomsTier = nomsTier;
        this.aliasTier = aliasTier;
        this.natureTier = natureTier;
        this.languepardefautTier = languepardefautTier;
        this.adresseTier = adresseTier;
        this.dateenregTierPointvente = dateenregTierPointvente;
        this.pointvente = pointvente;
    }

    public String getIdTier() {
        return idTier;
    }

    public void setIdTier(String idTier) {
        this.idTier = idTier;
    }

    public String getNomsTier() {
        return nomsTier;
    }

    public void setNomsTier(String nomsTier) {
        this.nomsTier = nomsTier;
    }

    public String getAliasTier() {
        return aliasTier;
    }

    public void setAliasTier(String aliasTier) {
        this.aliasTier = aliasTier;
    }

    public String getNatureTier() {
        return natureTier;
    }

    public void setNatureTier(String natureTier) {
        this.natureTier = natureTier;
    }

    public String getLanguepardefautTier() {
        return languepardefautTier;
    }

    public void setLanguepardefautTier(String languepardefautTier) {
        this.languepardefautTier = languepardefautTier;
    }

    public Adresse getAdresseTier() {
        return adresseTier;
    }

    public void setAdresseTier(Adresse adresseTier) {
        this.adresseTier = adresseTier;
    }

    public Date getDateenregTierPointvente() {
        return dateenregTierPointvente;
    }

    public void setDateenregTierPointvente(Date dateenregTierPointvente) {
        this.dateenregTierPointvente = dateenregTierPointvente;
    }

    public Pointvente getPointvente() {
        return pointvente;
    }

    public void setPointvente(Pointvente pointvente) {
        this.pointvente = pointvente;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}

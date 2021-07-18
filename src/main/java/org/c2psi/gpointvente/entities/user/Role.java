package org.c2psi.gpointvente.entities.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role {
    @Id
    String idRole;
    String nomRole;
    String aliasRole;
    String descriptionRole;

    public Role() {
    }

    public Role(String idRole, String nomRole, String aliasRole, String descriptionRole) {
        this.idRole = idRole;
        this.nomRole = nomRole;
        this.aliasRole = aliasRole;
        this.descriptionRole = descriptionRole;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    public String getAliasRole() {
        return aliasRole;
    }

    public void setAliasRole(String aliasRole) {
        this.aliasRole = aliasRole;
    }

    public String getDescriptionRole() {
        return descriptionRole;
    }

    public void setDescriptionRole(String descriptionRole) {
        this.descriptionRole = descriptionRole;
    }
}

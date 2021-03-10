package org.c2psi.gpointvente.entities.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UtilisateurRole {
    @Id
    String idUserRole;

    @DBRef
    Role roleAssocie;
    @DBRef
    Utilisateur userAssocie;

    public UtilisateurRole() {
    }

    public UtilisateurRole(String idUserRole, Role roleAssocie, Utilisateur userAssocie) {
        this.idUserRole = idUserRole;
        this.roleAssocie = roleAssocie;
        this.userAssocie = userAssocie;
    }

    public String getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(String idUserRole) {
        this.idUserRole = idUserRole;
    }

    public Role getRoleAssocie() {
        return roleAssocie;
    }

    public void setRoleAssocie(Role roleAssocie) {
        this.roleAssocie = roleAssocie;
    }

    public Utilisateur getUserAssocie() {
        return userAssocie;
    }

    public void setUserAssocie(Utilisateur userAssocie) {
        this.userAssocie = userAssocie;
    }
}

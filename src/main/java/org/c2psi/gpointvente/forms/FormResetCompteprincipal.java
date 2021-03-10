package org.c2psi.gpointvente.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FormResetCompteprincipal implements java.io.Serializable {
    @NotNull(message = "L'identifiant du compte principal dont le solde sera reinitialiser ne peut être null")
    @NotBlank(message = "L'identifiant du compte principal dont le solde sera reinitialiser ne peut être blanc")
    @NotEmpty(message = "L'identifiant du compte principal dont le solde sera reinitialiser ne peut être vide")
    String idPointventeCompteprincipalAReset;
    @Min(value=0)
    Double newsoldeespece;

    public FormResetCompteprincipal() {
    }

    public FormResetCompteprincipal(String idPointventeCompteprincipalAReset, Double newsoldeespece) {
        this.idPointventeCompteprincipalAReset = idPointventeCompteprincipalAReset;
        this.newsoldeespece = newsoldeespece;
    }

    public String getIdPointventeCompteprincipalAReset() {
        return idPointventeCompteprincipalAReset;
    }

    public void setIdPointventeCompteprincipalAReset(String idPointventeCompteprincipalAReset) {
        this.idPointventeCompteprincipalAReset = idPointventeCompteprincipalAReset;
    }

    public Double getNewsoldeespece() {
        return newsoldeespece;
    }

    public void setNewsoldeespece(Double newsoldeespece) {
        this.newsoldeespece = newsoldeespece;
    }
}

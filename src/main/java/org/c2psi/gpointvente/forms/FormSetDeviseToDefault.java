package org.c2psi.gpointvente.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FormSetDeviseToDefault implements java.io.Serializable {
    @NotNull(message = "L'identifiant de la devise ne peut etre null")
    @NotBlank(message = "L'identifiant de la devise ne peut etre vide")
    @NotEmpty(message = "L'identifiant de la devise ne peut etre une chaine vide")
    String idDevise;

    public FormSetDeviseToDefault() {
    }

    public FormSetDeviseToDefault(String idDevise) {
        this.idDevise = idDevise;
    }

    public String getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(String idDevise) {
        this.idDevise = idDevise;
    }
}

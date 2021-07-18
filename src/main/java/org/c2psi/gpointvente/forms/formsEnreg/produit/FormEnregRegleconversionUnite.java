package org.c2psi.gpointvente.forms.formsEnreg.produit;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FormEnregRegleconversionUnite implements java.io.Serializable {
    @NotNull(message = "L'identifiant de l'unite multiple ne peut etre null")
    @NotBlank(message = "L'identifiant de l'unite multiple ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de l'unite multiple ne peut etre vide")
    String idUnitemultiple;
    @NotNull(message = "L'identifiant de l'unite sous multiple ne peut etre null")
    @NotBlank(message = "L'identifiant de l'unite sous multiple ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de l'unite sous multiple ne peut etre vide")
    String idUnitesousmultiple;
    @Min(value=0)
    int facteurconversionUnite;

    public FormEnregRegleconversionUnite() {
    }

    public FormEnregRegleconversionUnite(String idUnitemultiple, String idUnitesousmultiple,
                                         int facteurconversionUnite) {
        this.idUnitemultiple = idUnitemultiple;
        this.idUnitesousmultiple = idUnitesousmultiple;
        this.facteurconversionUnite = facteurconversionUnite;
    }

    public String getIdUnitemultiple() {
        return idUnitemultiple;
    }

    public void setIdUnitemultiple(String idUnitemultiple) {
        this.idUnitemultiple = idUnitemultiple;
    }

    public String getIdUnitesousmultiple() {
        return idUnitesousmultiple;
    }

    public void setIdUnitesousmultiple(String idUnitesousmultiple) {
        this.idUnitesousmultiple = idUnitesousmultiple;
    }

    public int getFacteurconversionUnite() {
        return facteurconversionUnite;
    }

    public void setFacteurconversionUnite(int facteurconversionUnite) {
        this.facteurconversionUnite = facteurconversionUnite;
    }
}

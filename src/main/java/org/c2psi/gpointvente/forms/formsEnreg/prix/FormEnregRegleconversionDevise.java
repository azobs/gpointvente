package org.c2psi.gpointvente.forms.formsEnreg.prix;

import javax.validation.constraints.*;

public class FormEnregRegleconversionDevise implements java.io.Serializable {
    @NotNull(message = "L'identifiant de la devise multiple ne peut etre null")
    @NotBlank(message = "L'identifiant de la devise multiple ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de la devise multiple ne peut etre vide")
    String idDevisemultiple;
    @NotNull(message = "L'identifiant de la devise sous multiple ne peut etre null")
    @NotBlank(message = "L'identifiant de la devise sous multiple ne peut etre blanc")
    @NotEmpty(message = "L'identifiant de la devise sous multiple ne peut etre vide")
    String idDevisesousmultiple;
    @Min(value=0)
    Double facteurconversionDevise;

    public FormEnregRegleconversionDevise() {
    }

    public FormEnregRegleconversionDevise(String idDevisemultiple, String idDevisesousmultiple,
                                          Double facteurconversionDevise) {
        this.idDevisemultiple = idDevisemultiple;
        this.idDevisesousmultiple = idDevisesousmultiple;
        this.facteurconversionDevise = facteurconversionDevise;
    }

    public String getIdDevisemultiple() {
        return idDevisemultiple;
    }

    public void setIdDevisemultiple(String idDevisemultiple) {
        this.idDevisemultiple = idDevisemultiple;
    }

    public String getIdDevisesousmultiple() {
        return idDevisesousmultiple;
    }

    public void setIdDevisesousmultiple(String idDevisesousmultiple) {
        this.idDevisesousmultiple = idDevisesousmultiple;
    }

    public Double getFacteurconversionDevise() {
        return facteurconversionDevise;
    }

    public void setFacteurconversionDevise(Double facteurconversionDevise) {
        this.facteurconversionDevise = facteurconversionDevise;
    }
}

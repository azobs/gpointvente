package org.c2psi.gpointvente.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FormUpdateParamPointvente implements java.io.Serializable {
    @NotNull (message = "L'identifiant du point de vente à modifier ne peut etre null")
    @NotEmpty (message = "L'identifiant du point de vente à modifier ne peut etre vide")
    String idPointventeAModifie;
    @NotNull (message = "La nouvelle description du point de vente ne peut etre null")
    @NotEmpty (message = "La nouvelle description du point de vente ne peut etre vide")
    String newDescriptionPv;
    @NotNull (message = "La nouvelle denomination du point de vente ne peut etre null")
    @NotEmpty (message = "La nouvelle denomination du point de vente ne peut etre vide")
    String newDenominationPv;

    public FormUpdateParamPointvente() {
    }

    public FormUpdateParamPointvente(String idPointventeAModifie, String newDescriptionPv,
                                     String newDenominationPv) {
        this.idPointventeAModifie = idPointventeAModifie;
        this.newDescriptionPv = newDescriptionPv;
        this.newDenominationPv = newDenominationPv;
    }

    public String getIdPointventeAModifie() {
        return idPointventeAModifie;
    }

    public void setIdPointventeAModifie(String idPointventeAModifie) {
        this.idPointventeAModifie = idPointventeAModifie;
    }

    public String getNewDescriptionPv() {
        return newDescriptionPv;
    }

    public void setNewDescriptionPv(String newDescriptionPv) {
        this.newDescriptionPv = newDescriptionPv;
    }

    public String getNewDenominationPv() {
        return newDenominationPv;
    }

    public void setNewDenominationPv(String newDenominationPv) {
        this.newDenominationPv = newDenominationPv;
    }
}

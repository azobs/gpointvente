package org.c2psi.gpointvente.forms.formsEnreg.produit;

public class FormEnregProduitFormate implements java.io.Serializable {
    String photoPF;
    String idProduitAFormate;
    String idFormat;

    public FormEnregProduitFormate() {
    }

    public FormEnregProduitFormate(String photoPF, String idProduitAFormate, String idFormat) {
        this.photoPF = photoPF;
        this.idProduitAFormate = idProduitAFormate;
        this.idFormat = idFormat;
    }

    public String getPhotoPF() {
        return photoPF;
    }

    public void setPhotoPF(String photoPF) {
        this.photoPF = photoPF;
    }

    public String getIdProduitAFormate() {
        return idProduitAFormate;
    }

    public void setIdProduitAFormate(String idProduitAFormate) {
        this.idProduitAFormate = idProduitAFormate;
    }

    public String getIdFormat() {
        return idFormat;
    }

    public void setIdFormat(String idFormat) {
        this.idFormat = idFormat;
    }
}

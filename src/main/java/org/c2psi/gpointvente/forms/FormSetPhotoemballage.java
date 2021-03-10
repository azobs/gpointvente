package org.c2psi.gpointvente.forms;

public class FormSetPhotoemballage implements java.io.Serializable {
    String idTypeemballage;
    String photoEmballage;

    public FormSetPhotoemballage() {
    }

    public FormSetPhotoemballage(String idTypeemballage, String photoEmballage) {
        this.idTypeemballage = idTypeemballage;
        this.photoEmballage = photoEmballage;
    }

    public String getIdTypeemballage() {
        return idTypeemballage;
    }

    public void setIdTypeemballage(String idTypeemballage) {
        this.idTypeemballage = idTypeemballage;
    }

    public String getPhotoEmballage() {
        return photoEmballage;
    }

    public void setPhotoEmballage(String photoEmballage) {
        this.photoEmballage = photoEmballage;
    }
}

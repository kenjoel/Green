
package com.kenjoel.green;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrients {

    @SerializedName("ENERC_KCAL")
    @Expose
    private Float eNERCKCAL;
    @SerializedName("PROCNT")
    @Expose
    private Float pROCNT;
    @SerializedName("FAT")
    @Expose
    private Float fAT;
    @SerializedName("CHOCDF")
    @Expose
    private Float cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    private Float fIBTG;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Nutrients() {
    }

    /**
     * 
     * @param cHOCDF
     * @param fAT
     * @param eNERCKCAL
     * @param pROCNT
     * @param fIBTG
     */
    public Nutrients(Float eNERCKCAL, Float pROCNT, Float fAT, Float cHOCDF, Float fIBTG) {
        super();
        this.eNERCKCAL = eNERCKCAL;
        this.pROCNT = pROCNT;
        this.fAT = fAT;
        this.cHOCDF = cHOCDF;
        this.fIBTG = fIBTG;
    }

    public Float getENERCKCAL() {
        return eNERCKCAL;
    }

    public void setENERCKCAL(Float eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    public Float getPROCNT() {
        return pROCNT;
    }

    public void setPROCNT(Float pROCNT) {
        this.pROCNT = pROCNT;
    }

    public Float getFAT() {
        return fAT;
    }

    public void setFAT(Float fAT) {
        this.fAT = fAT;
    }

    public Float getCHOCDF() {
        return cHOCDF;
    }

    public void setCHOCDF(Float cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    public Float getFIBTG() {
        return fIBTG;
    }

    public void setFIBTG(Float fIBTG) {
        this.fIBTG = fIBTG;
    }

}

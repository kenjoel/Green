
package com.kenjoel.green;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qualified {

    @SerializedName("qualifiers")
    @Expose
    private List<Qualifier> qualifiers = null;
    @SerializedName("weight")
    @Expose
    private Float weight;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Qualified() {
    }

    /**
     * 
     * @param qualifiers
     * @param weight
     */
    public Qualified(List<Qualifier> qualifiers, Float weight) {
        super();
        this.qualifiers = qualifiers;
        this.weight = weight;
    }

    public List<Qualifier> getQualifiers() {
        return qualifiers;
    }

    public void setQualifiers(List<Qualifier> qualifiers) {
        this.qualifiers = qualifiers;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

}

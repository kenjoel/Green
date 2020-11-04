
package com.kenjoel.green;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measure {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("weight")
    @Expose
    private Float weight;
    @SerializedName("qualified")
    @Expose
    private List<Qualified> qualified = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Measure() {
    }

    /**
     * 
     * @param qualified
     * @param weight
     * @param label
     * @param uri
     */
    public Measure(String uri, String label, Float weight, List<Qualified> qualified) {
        super();
        this.uri = uri;
        this.label = label;
        this.weight = weight;
        this.qualified = qualified;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public List<Qualified> getQualified() {
        return qualified;
    }

    public void setQualified(List<Qualified> qualified) {
        this.qualified = qualified;
    }

}

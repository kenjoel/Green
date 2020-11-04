
package com.kenjoel.green;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qualifier {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Qualifier() {
    }

    /**
     * 
     * @param label
     * @param uri
     */
    public Qualifier(String uri, String label) {
        super();
        this.uri = uri;
        this.label = label;
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

}

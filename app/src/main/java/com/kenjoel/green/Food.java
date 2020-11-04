
package com.kenjoel.green;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("food")
    @Expose
    private Food_ food;
    @SerializedName("measures")
    @Expose
    private List<Measure> measures = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Food() {
    }

    /**
     * 
     * @param measures
     * @param food
     */
    public Food(Food_ food, List<Measure> measures) {
        super();
        this.food = food;
        this.measures = measures;
    }

    public Food_ getFood() {
        return food;
    }

    public void setFood(Food_ food) {
        this.food = food;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

}

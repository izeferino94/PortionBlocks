package edu.izeferinucsd.portionblocks;

/**
 * Created by Isaiah on 11/3/2016.
 */

public class Portion {
    private String portionName;
    private int numberOfPortions;
    private int caloriesPerPortion;

    public Portion(String portionName, int numberOfPortions, int caloriesPerPortion) {
        this.portionName = portionName;
        this.numberOfPortions = numberOfPortions;
        this.caloriesPerPortion = caloriesPerPortion;
    }

    public String getPortionName() {
        return portionName;
    }

    public int getNumberOfPortions() {
        return numberOfPortions;
    }

    public int getCaloriesPerPortion() {
        return caloriesPerPortion;
    }
}

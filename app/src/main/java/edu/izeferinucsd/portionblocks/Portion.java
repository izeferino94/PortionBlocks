package edu.izeferinucsd.portionblocks;

import java.util.HashMap;
import java.util.Map;

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

    public Map<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("portionName", portionName);
        map.put("numberOfPortions", numberOfPortions);
        map.put("caloriesPerPortion", caloriesPerPortion);
        return map;
    }
}

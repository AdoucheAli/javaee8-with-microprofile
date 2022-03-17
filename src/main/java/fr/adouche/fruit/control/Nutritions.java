package fr.adouche.fruit.control;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class Nutritions {
    private final String carbohydrates;
    private final String calories;

    @JsonbCreator
    public Nutritions(@JsonbProperty("carbohydrates") String carbohydrates,
                      @JsonbProperty("calories") String calories) {
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public String getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Nutritions{" +
                "carbohydrates='" + carbohydrates + '\'' +
                ", calories='" + calories + '\'' +
                '}';
    }
}

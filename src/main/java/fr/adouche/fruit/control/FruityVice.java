package fr.adouche.fruit.control;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class FruityVice {
    private final Nutritions nutritions;
    private final String family;
    private final String name;

    @JsonbCreator
    public FruityVice(@JsonbProperty("nutritions") Nutritions nutritions,
                      @JsonbProperty("family") String family,
                      @JsonbProperty("name") String name) {
        this.nutritions = nutritions;
        this.family = family;
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public Nutritions getNutritions() {
        return nutritions;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FruityVice{" +
                "nutritions=" + nutritions +
                ", family='" + family + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
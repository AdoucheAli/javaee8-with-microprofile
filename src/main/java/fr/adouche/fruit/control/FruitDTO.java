package fr.adouche.fruit.control;

public class FruitDTO {

    private String name;
    private String season;
    private String carbohydrates;
    private String calories;
    private String family;

    private FruitDTO(String name, String season, String carbohydrates, String calories, String family) {
        this.name = name;
        this.season = season;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
        this.family = family;
    }

    public static FruitDTO of(String name, String season, FruityVice fruityVice) {
        return new FruitDTO(name, season,
                fruityVice.getNutritions().getCarbohydrates(),
                fruityVice.getNutritions().getCalories(),
                fruityVice.getFamily());
    }

    @Override
    public String toString() {
        return "FruitDTO{" +
                "name='" + name + '\'' +
                ", season='" + season + '\'' +
                ", carbohydrates='" + carbohydrates + '\'' +
                ", calories='" + calories + '\'' +
                ", family='" + family + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public String getCalories() {
        return calories;
    }

    public String getFamily() {
        return family;
    }
}

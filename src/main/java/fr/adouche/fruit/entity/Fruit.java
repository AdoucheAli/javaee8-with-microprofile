package fr.adouche.fruit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name = "fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String season;

    public Fruit() {
    }

    public Fruit(String name, String season) {
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", season='" + season + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

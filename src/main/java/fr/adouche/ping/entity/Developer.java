package fr.adouche.ping.entity;

import java.util.Objects;

public class Developer {

    private final String message;
    private final int age;

    public Developer(String message, int age) {
        this.message = message;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "message='" + message + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return age == developer.age && Objects.equals(message, developer.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, age);
    }
}

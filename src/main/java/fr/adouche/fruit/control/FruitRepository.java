package fr.adouche.fruit.control;

import fr.adouche.fruit.entity.Fruit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class FruitRepository {

    @PersistenceContext(unitName = "microprofile-unit")
    private EntityManager entityManager;

    public List<Fruit> getAll() {
        return entityManager.createQuery("select f from Fruit f", Fruit.class).getResultList();
    }

    public List<Fruit> getFruitBySeason(String season) {
        TypedQuery<Fruit> query = entityManager.createQuery("select f from Fruit f where f.season = :season", Fruit.class);

        query.setParameter("season", season);

        return query.getResultList();
    }

    public Optional<Fruit> getFruitByName(String name) {
        TypedQuery<Fruit> query = entityManager.createQuery("select f from Fruit f where f.name = :name", Fruit.class);
        query.setParameter("name", name);
        List<Fruit> fruits = query.getResultList();

        return fruits != null && !fruits.isEmpty()
                ? Optional.of(fruits.get(0))
                : Optional.empty();
    }
}

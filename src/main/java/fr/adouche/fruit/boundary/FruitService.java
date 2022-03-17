package fr.adouche.fruit.boundary;


import fr.adouche.fruit.control.FruitRepository;
import fr.adouche.fruit.entity.Fruit;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class FruitService {

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry metricRegistry;

    @Inject
    private FruitRepository fruitRepo;


    @Fallback(fallbackMethod = "fakeFruits")
    @Retry(maxRetries = 2)
    public List<Fruit> getAll() {
        return fruitRepo.getAll()
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    @Fallback(fallbackMethod = "fakeFruitBySeason")
    @Retry(maxRetries = 2)
    public List<Fruit> getFruitBySeason(String season) {
        return fruitRepo.getFruitBySeason(season);
    }

    @Fallback(fallbackMethod = "fakeFruit")
    @Retry(maxRetries = 2)
    public Fruit getFruitByName(String name) {
        return fruitRepo.getFruitByName(name)
                .orElse(new Fruit());
    }

    public List<Fruit> fakeFruits() {
        metricRegistry.counter("fruits_fake_404").inc();

        return Arrays.asList(new Fruit("banana", "spring"), new Fruit("banana", "spring"));
    }

    public List<Fruit> fakeFruitBySeason(String season) {
        metricRegistry.counter("fruits_fake_404").inc();

        return Arrays.asList(new Fruit("banana", season), new Fruit("banana", season));
    }


    public Fruit fakeFruit(String season) {
        metricRegistry.counter("fruit_fake_404").inc();

        return new Fruit("banana", season);
    }
}

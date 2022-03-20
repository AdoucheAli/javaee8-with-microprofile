package fr.adouche.fruit.boundary;

import fr.adouche.fruit.control.FruitDTO;
import fr.adouche.fruit.entity.Fruit;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("fruit")
public class FruitResource {

    @Inject
    FruityService fruityService;

    @Inject
    FruitService fruitService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Metered
    public Response getAll(@QueryParam("name") String name, @QueryParam("season") String season) {

        if (name != null && !name.trim().isEmpty()) {
            return byName(name);
        }

        if (season != null && !season.isEmpty()) {
            return bySeason(season);
        }

        List<Fruit> fruits = fruitService.getAll();
        List<FruitDTO> fruitDtos = fruits.stream()
                .map(fruit ->
                        FruitDTO.of(fruit.getName(), fruit.getSeason(), fruityService.getFruitByName(fruit.getName()))
                ).collect(Collectors.toList());

        return Response.ok()
                .entity(fruitDtos)
                .build();
    }


    private Response byName(String name) {
        Fruit fruit = fruitService.getFruitByName(name);
        return Response.ok()
                .entity(FruitDTO.of(fruit.getName(), fruit.getSeason(), fruityService.getFruitByName(name)))
                .build();
    }


    private Response bySeason(String season) {
        List<FruitDTO> fruitDtos = fruitService.getFruitBySeason(season)
                .stream()
                .map(fruit ->
                        FruitDTO.of(fruit.getName(), fruit.getSeason(), fruityService.getFruitByName(fruit.getName()))
                ).collect(Collectors.toList());

        return Response.ok()
                .entity(fruitDtos)
                .build();
    }
}

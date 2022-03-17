package fr.adouche.fruit.boundary;

import fr.adouche.fruit.control.FruitDTO;
import fr.adouche.fruit.entity.Fruit;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public Response getAll() {
        List<Fruit> fruits = fruitService.getAll();
        List<FruitDTO> fruitDtos = fruits.stream()
                .map(fruit ->
                        FruitDTO.of(fruit.getName(), fruit.getSeason(), fruityService.getFruitByName(fruit.getName()))
                ).collect(Collectors.toList());

        return Response.ok()
                .entity(fruitDtos)
                .build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Metered
    public Response getOne(@PathParam("name") String name) {
        Fruit fruit = fruitService.getFruitByName(name);

        return Response.ok()
                .entity(FruitDTO.of(fruit.getName(), fruit.getSeason(), fruityService.getFruitByName(name)))
                .build();
    }

    @GET
    @Path("/season/{season}")
    @Produces(MediaType.APPLICATION_JSON)
    @Metered
    public Response bySeason(@PathParam("season") String season) {
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

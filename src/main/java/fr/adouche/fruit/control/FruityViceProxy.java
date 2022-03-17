package fr.adouche.fruit.control;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Path("/api/fruit")
@RegisterRestClient
public interface FruityViceProxy {

    @GET
    @Path("/api/fruit/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getFruitByName(@PathParam("name") String name);
}

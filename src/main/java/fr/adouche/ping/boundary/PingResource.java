package fr.adouche.ping.boundary;

import fr.adouche.ping.entity.Developer;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @Inject
    @ConfigProperty(name = "message")
    String message;

    @Inject
    DeveloperShop ds;

    @GET
    @Metered
    public Developer ping() {
        return ds.theOne(message);
    }

    @GET
    @Path("/exception")
    @Metered
    public Developer exception() {
        return ds.exception("hit by a bus");
    }

    @GET
    @Path("/webException")
    @Metered
    public Developer webException() {
        throw new TooLateToPingException("....bye");
    }
}

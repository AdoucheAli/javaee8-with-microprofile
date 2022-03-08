package fr.adouche.ping.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.adouche.entity.Developer;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

/*    @Inject
    @ConfigProperty(name = "message")
    String message;*/

    @Inject
    DeveloperShop ds;

    @GET
    public Developer ping() {
        //return this.message + " Jakarta EE with MicroProfile 2+!";
        return ds.theOne();

    }

}

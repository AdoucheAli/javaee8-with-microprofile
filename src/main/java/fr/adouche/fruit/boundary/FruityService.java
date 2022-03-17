package fr.adouche.fruit.boundary;


import fr.adouche.fruit.control.FruityVice;
import fr.adouche.fruit.control.FruityViceProxy;
import fr.adouche.fruit.control.Nutritions;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class FruityService {

    @Inject
    @ConfigProperty(name = "fr.adouche.fruit.control.FruityViceProxy/mp-rest/url")
    String uriFruityVice;

    @Inject
    @RestClient
    FruityViceProxy fruityViceProxy;

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry metricRegistry;


    @Fallback(fallbackMethod = "fakeFruityVice")
    @Retry(maxRetries = 2)
    public FruityVice getFruitByName(String name) {
        Response response = fruityViceProxy.getFruitByName(name);

        //response.readEntity ne peut etre lu que 1 fois Entity input stream has already been closed.
        FruityVice fruityVice = response.readEntity(FruityVice.class);
        int status = response.getStatus();

        metricRegistry.counter("fruityVice_" + fruityVice.getName() + "_" + status).inc();

        return fruityVice;
    }

    public FruityVice fakeFruityVice(String name) {
        metricRegistry.counter("fruityVice_fake_404").inc();
        return new FruityVice(new Nutritions("unknown", "unknown"), "unknown", name);
    }
}

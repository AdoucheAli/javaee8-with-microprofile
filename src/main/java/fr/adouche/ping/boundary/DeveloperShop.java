package fr.adouche.ping.boundary;

import fr.adouche.entity.Developer;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DeveloperShop {


    @Inject
    DeveloperCounter developerCounter;

    //@Counted can be use instead of developercounter with gauge
    public Developer theOne() {
        developerCounter.increment();
        return new Developer("duke", 42);
    }
}

package fr.adouche.ping.boundary;

import fr.adouche.ping.control.DeveloperCounter;
import fr.adouche.ping.entity.Developer;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DeveloperShop {


    @Inject
    DeveloperCounter developerCounter;

    //@Counted can be use instead of developercounter with gauge
    public Developer theOne(String message) {
        developerCounter.increment();
        return new Developer(message, 42);
    }

    @Fallback(fallbackMethod = "ironman"
//dans la verison 5.0 de microprofile
//            applyOn = IllegalStateException.class,
//            skipOn = IllegalArgumentException.class
    )
    @Retry(maxRetries = 2) //by default maxRetries = 3
    //Retrying as long as maxDuration (180,000ms) isn't breached, and no more than 2 times|#]
    public Developer exception(String message) {
        System.out.println("******* to show retry : " + message);
        throw new IllegalArgumentException(message);
    }

    /*
     * Fallback method should have exactly same arguments and return type.
     * Only exception is you can have an extra argument of type Throwable, to get hold of the originial exception that occured.
     * This will help you in decidin what to send back to user(based on the exception)
     * */
    public Developer ironman(String message) {
        return new Developer("Iron man " + message, 60);
    }
}

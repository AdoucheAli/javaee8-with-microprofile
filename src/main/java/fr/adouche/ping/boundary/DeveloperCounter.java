package fr.adouche.ping.boundary;

import org.eclipse.microprofile.metrics.annotation.Gauge;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

@ApplicationScoped
public class DeveloperCounter {

    private final LongAdder adder = new LongAdder(); //we can use AtomicInteger too

    @Gauge(unit = "counter")
    public int developersCreated() {
        return this.adder.intValue();
    }

    public void increment() {
        this.adder.increment();;
    }
}

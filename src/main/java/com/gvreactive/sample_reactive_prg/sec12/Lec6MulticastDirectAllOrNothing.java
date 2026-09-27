package com.gvreactive.sample_reactive_prg.sec12;

import com.gvreactive.sample_reactive_prg.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec6MulticastDirectAllOrNothing {
    private static final Logger log= LoggerFactory.getLogger(Lec6MulticastDirectAllOrNothing.class);

    public static void main(String[] args) {
        demo1();
        Util.sleepSeconds(10);
    }
    private static void demo1(){
        System.setProperty("reactor.bufferSize.small","16");
        var sink= Sinks.many().multicast().directAllOrNothing();
        var flux=sink.asFlux();
        flux.subscribe(Util.subscriber("sam"));
        flux.delayElements(Duration.ofMillis(2000)).subscribe(Util.subscriber("mike"));
        for (int i = 0; i < 100; i++) {
            var result=  sink.tryEmitNext(i);
            log.info("item: {}, result: {}",i,result);
        }

    }
}

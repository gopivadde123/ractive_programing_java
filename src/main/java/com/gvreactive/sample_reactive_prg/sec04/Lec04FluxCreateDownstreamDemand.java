package com.gvreactive.sample_reactive_prg.sec04;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateDownstreamDemand {
    private static final Logger log= (Logger) LoggerFactory.getLogger(Lec04FluxCreateDownstreamDemand.class);
   // this is sink in pub side
    public static void main(String[] args) {
        productOnDemand();
    }
    private static void productOnEarly(){
        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                var name = Util.faker().name().firstName();
                log.info("generated: {}",name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();
    }
    // fluxsink is only for single subscriber
    private static void productOnDemand(){
        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
           fluxSink.onRequest(request -> {
               for (int i = 0; i < request && !fluxSink.isCancelled(); i++) {
                   var name = Util.faker().name().firstName();
                   log.info("generated: {}",name);
                   fluxSink.next(name);
               }
           });
           fluxSink.isCancelled();
        }).subscribe(subscriber);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }
}

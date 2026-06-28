package com.gvreactive.sample_reactive_prg.sec02;

import com.gvreactive.sample_reactive_prg.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;


public class Lec01LazyStream {
    private static final Logger log= (Logger) LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {
//        Stream.of(2)
//        .peek(i -> log.info("received : {}",i))
//                .toList();
       var mono= Mono.just("gopi");
       var subscriber=new SubscriberImpl();
       mono.subscribe(subscriber);
       subscriber.getSubscription().request(10);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
//        save(Mono.just("ram"));

    }

//    public static void save(Publisher<String> publisher) {
//
//    }
}

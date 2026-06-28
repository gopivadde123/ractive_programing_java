package com.gvreactive.sample_reactive_prg.sec04;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec08GenerateWithState {
    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        Flux.generate(synchronousSink -> {
//            var country = Util.faker().country().name();
//            atomicInteger.incrementAndGet();
//            synchronousSink.next(country);
//            if(atomicInteger.incrementAndGet() == 10 || country.equalsIgnoreCase("canada")){
//                synchronousSink.complete();
//            }
//        }).subscribe(Util.subscriber());
//        atomicInteger.incrementAndGet();
        Flux.generate(
                () -> 0,
                (counter,sink) -> {
                    var country = Util.faker().country().name();
                    sink.next(country);
                    counter ++;
                    if(counter == 10 || country.equalsIgnoreCase("canada")){
                        sink.complete();;
                    }
                    return counter;
                }
        ).subscribe(Util.subscriber());
    }
}

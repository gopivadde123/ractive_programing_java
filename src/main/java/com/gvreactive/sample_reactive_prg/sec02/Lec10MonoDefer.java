package com.gvreactive.sample_reactive_prg.sec02;

import com.gvreactive.sample_reactive_prg.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec10MonoDefer {
    private static final Logger log = LoggerFactory.getLogger(Lec10MonoDefer.class);

    public static void main(String[] args) {
        // here publisher is executing without sub to make lazy use Mono.defer()
//        createPublisher();

//                .subscribe(Util.subscriber());
        // make lazy
        Mono.defer(() -> createPublisher()).subscribe(Util.subscriber());
    }
    public static Mono<Integer> createPublisher(){
        var list = List.of(1,2,3);
        Util.sleepSeconds(1);
        return Mono.fromSupplier(() -> {
            try {
                return sum(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    // time-consuming busniess logic
    private static int sum(List<Integer> list) throws InterruptedException {
        log.info("finding the sum of {}",list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(a->a).sum();
    }
}

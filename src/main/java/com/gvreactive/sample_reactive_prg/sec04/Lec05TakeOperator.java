package com.gvreactive.sample_reactive_prg.sec04;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

// the take operator is very similar to java's stream limit
public class Lec05TakeOperator {
    public static void main(String[] args) {
//        IntStream.rangeClosed(1,10).limit(3).forEach(System.out::println);
        // same with flux
//        Flux.range(1,10)
//                .log("take")
//                .take(3)
//                .log("sub ")
//                .subscribe(Util.subscriber());
        takeUntil();
    }
    private static void take(){
        Flux.range(1,10)
                .log("take")
                .take(3)
                .log("sub ")
                .subscribe(Util.subscriber());
    }
    private static void takeWhile(){
        Flux.range(1,10)
                .log("take")
                .takeWhile(i -> i < 5)//stop when condiotn not met
                .log("sub ")
                .subscribe(Util.subscriber());
    }
    private static void takeUntil(){
        Flux.range(1,10)
                .log("take")
                .takeUntil(i -> i < 5)//stop when condiotn met
                .log("sub ")
                .subscribe(Util.subscriber());
    }

}

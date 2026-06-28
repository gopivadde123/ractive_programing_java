package com.gvreactive.sample_reactive_prg.sec04;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateUntil {
    public static void main(String[] args) {
       demo2();
    }
    public static void demo1(){
        Flux.generate(synchronousSink -> {
            var country = Util.faker().country().name();
            synchronousSink.next(country);
            if(country.equalsIgnoreCase("canada")){
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }
    public static void demo2(){
        Flux.<String>generate(synchronousSink -> {
            var country = Util.faker().country().name();
            synchronousSink.next(country);

        })
                .takeUntil(c -> c.equalsIgnoreCase("canada"))
                .subscribe(Util.subscriber());
    }
}

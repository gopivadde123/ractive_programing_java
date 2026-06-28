package com.gvreactive.sample_reactive_prg.sec04;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class Lec03FluxSinkThreadSafety {
    private static final Logger log= (Logger) LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) {
       demo2();
    }
    // this is not thread safe
    private static void demo1(){
        // the ArrayList is not thread safe
        var list = new ArrayList<Integer>();
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }

        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleepSeconds(3);
        log.info("list size: {}",list.size());
    }
    // flux sink is thread safe
    private static void demo2(){
        var list = new ArrayList<String>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(name -> list.add(name));
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                generator.generate();
            }

        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleepSeconds(3);
        log.info("list size: {}",list.size());
    }
}

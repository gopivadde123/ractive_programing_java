package com.gvreactive.sample_reactive_prg.sec05;

import com.gvreactive.sample_reactive_prg.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Similar to error handling. Handling empty!
public class Lec08SwitchIfEmpty {
    public static final Logger log = LoggerFactory.getLogger(Lec08SwitchIfEmpty.class);

    public static void main(String[] args) {
        Flux.range(1,10)
                .filter(i->i>11)
//                .defaultIfEmpty(50)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }
    private static Flux<Integer> fallback(){
        return Flux.range(100,3);
    }
}

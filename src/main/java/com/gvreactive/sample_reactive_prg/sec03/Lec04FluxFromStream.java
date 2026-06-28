package com.gvreactive.sample_reactive_prg.sec03;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        var list = List.of(1,2,3,4);
        var stream = list.stream();//java stream is one time use
//        var flux = Flux.fromStream(stream);
//        flux.subscribe(Util.subscriber("sub1"));
//        flux.subscribe(Util.subscriber("sub2")); // throw error because only one time use only
//
        var flux = Flux.fromStream(() -> list.stream());
        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2")); // throw error because only one time use only


    }
}

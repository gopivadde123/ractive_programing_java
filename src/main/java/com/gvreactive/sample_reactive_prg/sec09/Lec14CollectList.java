package com.gvreactive.sample_reactive_prg.sec09;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec14CollectList {
    public static void main(String[] args){
//  To collect the items received via Flux. Assuming we will have finite items!
        Flux.range(1,10)
                .concatWith(Mono.error(new RuntimeException("error")))
                .collectList()
                .subscribe(Util.subscriber());
    }
}

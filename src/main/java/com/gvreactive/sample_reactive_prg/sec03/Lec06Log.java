package com.gvreactive.sample_reactive_prg.sec03;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Flux;

public class Lec06Log {
    public static void main(String[] args) {
        Flux.range(1,5)
                .log("zxzxz") // this acts as sub to pub and pub for sub
                .map(i -> Util.faker().name().firstName())
                .log("zxz")
                .subscribe(Util.subscriber());
    }
}

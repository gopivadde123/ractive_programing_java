package com.gvreactive.sample_reactive_prg.sec12;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Sinks;

public class Lec07Replay {
    public static void main(String[] args) {
        demo1();
    }
    private static void demo1(){
        var sink= Sinks.many().replay().all();
        var flux=sink.asFlux();
        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("hi");
        sink.tryEmitNext("hopi");
        sink.tryEmitNext("cool");
        Util.sleepSeconds(2);
        flux.subscribe(Util.subscriber("jake"));
        sink.tryEmitNext("new msg");
    }
}

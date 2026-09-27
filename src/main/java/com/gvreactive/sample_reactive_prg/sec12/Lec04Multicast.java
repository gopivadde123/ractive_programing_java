package com.gvreactive.sample_reactive_prg.sec12;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Sinks;

public class Lec04Multicast {
    public static void main(String[] args) {
        demo2();
    }
    private static void demo1(){
        var sink= Sinks.many().multicast().onBackpressureBuffer();
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
    private static void demo2(){
        var sink= Sinks.many().multicast().onBackpressureBuffer();
        var flux=sink.asFlux();
        sink.tryEmitNext("hi");
        sink.tryEmitNext("hopi");
        sink.tryEmitNext("cool");
        Util.sleepSeconds(2);
        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        flux.subscribe(Util.subscriber("jake"));
        sink.tryEmitNext("new msg 23");
    }

}

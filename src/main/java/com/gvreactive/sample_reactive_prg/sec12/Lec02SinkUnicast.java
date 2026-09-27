package com.gvreactive.sample_reactive_prg.sec12;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Sinks;

public class Lec02SinkUnicast {
    public static void main(String[] args){
    demo2();
    }
    private static void demo1(){
        var sink= Sinks.many().unicast().onBackpressureBuffer();
        var flux=sink.asFlux();
        sink.tryEmitNext("hi");
        sink.tryEmitNext("hopi");
        sink.tryEmitNext("cool");
        flux.subscribe(Util.subscriber("sam"));
    }
    private static void demo2(){
        var sink= Sinks.many().unicast().onBackpressureBuffer();
        var flux=sink.asFlux();
        sink.tryEmitNext("hi");
        sink.tryEmitNext("hopi");
        sink.tryEmitNext("cool");
        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
    }
}

package com.gvreactive.sample_reactive_prg.sec12;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec09.Lec01StartWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {
    private static final Logger log= LoggerFactory.getLogger(Lec01SinkOne.class);
    public static void main(String[] args){
//        Sinks.One<Object> sink=Sinks.one();
       demo3();
    }
    public static void demo1(){
        var sink=Sinks.one();
        var mono=sink.asMono();
        mono.subscribe(Util.subscriber());
//        sink.tryEmitValue("hi");
//        sink.tryEmitEmpty();
        sink.tryEmitError(new RuntimeException("Error"));
    }
    public static void demo2(){
        var sink=Sinks.one();
        var mono=sink.asMono();
        sink.tryEmitValue("hi");
        mono.subscribe(Util.subscriber("sam"));
        mono.subscribe(Util.subscriber("mike"));

//        sink.tryEmitEmpty();
//        sink.tryEmitError(new RuntimeException("Error"));
    }
    public static void demo3(){
        var sink=Sinks.one();
        var mono=sink.asMono();
        mono.subscribe(Util.subscriber("sam"));
        sink.emitValue("hi",(((signalType, emitResult) -> {
            log.info("hi");
            log.info(signalType.name());
            log.info(emitResult.name());
            return false;
        })));
        sink.emitValue("hello",(((signalType, emitResult) -> {
            log.info("hello");
            log.info(signalType.name());
            log.info(emitResult.name());
            return false;
        })));

    }
}

package com.gvreactive.sample_reactive_prg.sec02;

import com.gvreactive.sample_reactive_prg.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec06MonoFromCallable {
    private static final Logger log = LoggerFactory.getLogger(Lec06MonoFromCallable.class);
    public static void main(String[] args) {
        var list= List.of(1,2,3);
//    fromSupplier and fromCallable are functional interface in java
//    fromSupplier do not have exception as part of method signature and no checked exception
        Mono.fromCallable(()->sum(list)).subscribe(Util.subscriber());
    }
    private static int sum(List<Integer> list){
        log.info("finding the sum of {}",list);
        return list.stream().mapToInt(a->a).sum();
    }
}

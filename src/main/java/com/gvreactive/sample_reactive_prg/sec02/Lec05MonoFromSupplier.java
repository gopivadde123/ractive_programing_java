package com.gvreactive.sample_reactive_prg.sec02;
import com.gvreactive.sample_reactive_prg.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec05MonoFromSupplier {
    private static final Logger log = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);
    public static void main(String[] args) {
        var list = List.of(1,2,3);
//     here just can only used data in memory, but to perform some operation on that
//     not recomended better to use fromSupplier because just will run even though no subscribe method
//        Mono.just(sum(list));
//                .subscribe(Util.subscriber());
// on memory list performing sum opertion it executetion starts only when subscribe
        // to deplay intensive operations use fromSupplier method
        Mono.fromSupplier(() -> sum(list)).subscribe(Util.subscriber());
//        Mono.fromSupplier(() -> sum(list)).subscribe(Util.subscriber());
    }
    private static int sum(List<Integer> list){
        log.info("finding the sum of {}",list);
        return list.stream().mapToInt(a->a).sum();
    }
}

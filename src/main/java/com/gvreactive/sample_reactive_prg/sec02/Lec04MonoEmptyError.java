package com.gvreactive.sample_reactive_prg.sec02;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {
    public static void main(String[] args) {
        // this is passing general subscriber to publisher
//        getUsername(3)
//                .subscribe(Util.subscriber());
        getUsername(1)
                .subscribe(
                        s->System.out.println(s),
                        err -> {}
                );
    }
    private static Mono<String> getUsername(int userId){
        return switch (userId){
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty();//null
            default -> Mono.error(new RuntimeException("invalid input"));
        };
    }
}

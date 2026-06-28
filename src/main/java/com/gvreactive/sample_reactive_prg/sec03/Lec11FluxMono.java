package com.gvreactive.sample_reactive_prg.sec03;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// convert a flux to mono
public class Lec11FluxMono {
    public static void main(String[] args) {
//         save(getUsername(1));// here return type is flux not accept mono
          var flux = Flux.range(1,10);
//          flux.next()
//                  .subscribe(Util.subscriber());
        Mono.from(flux)
                .subscribe(Util.subscriber());
    }
    private static void monoToFlux(){
        var mono = getUsername(1);
        save(Flux.from(mono));//here convertion happen
    }
    private static Mono<String> getUsername(int userId){
        return switch (userId){
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty();//null
            default -> Mono.error(new RuntimeException("invalid input"));
        };
    }
    private static void save(Flux<String> flux){
        flux.subscribe(Util.subscriber());
    }
}

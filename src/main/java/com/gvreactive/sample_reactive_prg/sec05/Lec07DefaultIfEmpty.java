package com.gvreactive.sample_reactive_prg.sec05;

import com.gvreactive.sample_reactive_prg.common.Util;
import reactor.core.publisher.Mono;

import java.util.Optional;

// Similar to error handling, handle empty!
public class Lec07DefaultIfEmpty {
    public static void main(String[] args) {
        Mono.empty()
                .defaultIfEmpty("fallback")
                .subscribe(Util.subscriber());
    }
}

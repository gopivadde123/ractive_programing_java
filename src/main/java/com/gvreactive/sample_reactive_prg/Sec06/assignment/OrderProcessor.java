package com.gvreactive.sample_reactive_prg.Sec06.assignment;

import reactor.core.publisher.Flux;

public interface OrderProcessor {
    void consume(Order order);
    Flux<String> stream();
}

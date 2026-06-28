package com.gvreactive.sample_reactive_prg.sec04.assignment;

import reactor.core.publisher.Flux;
import java.nio.file.Path;
public interface FileReaderService {
    Flux<String> read(Path path);
}

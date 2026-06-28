package com.gvreactive.sample_reactive_prg.sec04;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec04.assignment.FileReaderServiceImpl;

import java.nio.file.Path;

public class Lec09Assignment {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        var path = Path.of("C:/Users/vgopi/OneDrive/Desktop/Java_reactive_prgs/sample_reactive_prg/sample_reactive_prg/src/main/resources/sec4/file.txt");
        var fileReaderService = new FileReaderServiceImpl();
        fileReaderService.read(path)
//                .take(6)
                .takeUntil(s -> s.equalsIgnoreCase("line7"))
                .subscribe(Util.subscriber());
    }
}

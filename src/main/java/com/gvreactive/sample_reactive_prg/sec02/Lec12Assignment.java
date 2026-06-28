package com.gvreactive.sample_reactive_prg.sec02;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec02.assignment.FileServiceImpl;

public class Lec12Assignment {
    public static void main(String[] args) {
        var fileService = new FileServiceImpl();
        fileService.write("file.txt","This is a test file").subscribe(Util.subscriber());
        fileService.read("file.txt")
                .subscribe(Util.subscriber());
        fileService.delete("file.txt").subscribe(Util.subscriber());
    }
}

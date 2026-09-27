package com.gvreactive.sample_reactive_prg.sec09;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec09.helper.Kayak;

public class Lec06MergeUseCase {
    public static void main(String[] args){
        Kayak.getFlights()
                .subscribe(Util.subscriber());
        Util.sleepSeconds(3);
    }
}

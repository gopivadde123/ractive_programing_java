package com.gvreactive.sample_reactive_prg.sec03;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec03.client.ExternalServiceClient;

public class Lec08NonBlockingStreamingMessages {
    public static void main(String[] args) {
       var client = new ExternalServiceClient();
       client.getNames().subscribe(Util.subscriber("sub1"));
        client.getNames().subscribe(Util.subscriber("sub2"));
       Util.sleepSeconds(8);
    }
}

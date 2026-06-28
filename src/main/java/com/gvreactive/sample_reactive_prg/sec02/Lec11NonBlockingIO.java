package com.gvreactive.sample_reactive_prg.sec02;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11NonBlockingIO {
    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        log.info("starting");
        for (int i = 0; i <= 5 ; i++) {
//            client.getProductName(i)
//                    .subscribe(Util.subscriber());
         var name =   client.getProductName(i)
                    .block();// should not use
         log.info(name);
        }

        Util.sleepSeconds(2);
    }
}

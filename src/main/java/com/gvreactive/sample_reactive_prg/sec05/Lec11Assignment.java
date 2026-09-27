package com.gvreactive.sample_reactive_prg.sec05;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec05.assignment.ExternalServiceClient;

// Ensure that the external service is up and running!
public class Lec11Assignment {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        for (int i = 1; i < 5; i++) {
            client.getProductName(i)
                    .subscribe(  item -> System.out.println("received: " + item),
                            error -> System.out.println("error: " + error.getMessage()),
                            () -> System.out.println("completed"));
        }
        Util.sleepSeconds(3);
    }
}

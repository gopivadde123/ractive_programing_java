package com.gvreactive.sample_reactive_prg.sec03;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec03.assignment.StockPriceObserver;
import com.gvreactive.sample_reactive_prg.sec03.client.ExternalServiceClient;

public class Lec12Assignment {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        var subscriber = new StockPriceObserver();
        client.getPriceChanges()
                .subscribe(subscriber);
        Util.sleepSeconds(20);
    }
}

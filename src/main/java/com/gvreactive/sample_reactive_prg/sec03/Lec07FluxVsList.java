package com.gvreactive.sample_reactive_prg.sec03;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec03.helper.NameGenerator;
import com.gvreactive.sample_reactive_prg.subscriber.SubscriberImpl;

public class Lec07FluxVsList {
    public static void main(String[] args) {
//       var list = NameGenerator.getNamesList(10);
//        System.out.println(list);
//        NameGenerator.getNamesFlux(10).subscribe(Util.subscriber());
        var subscriber = new SubscriberImpl();
        NameGenerator.getNamesFlux(10).subscribe(subscriber);
        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();
    }
}

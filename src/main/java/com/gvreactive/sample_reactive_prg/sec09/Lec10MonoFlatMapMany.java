package com.gvreactive.sample_reactive_prg.sec09;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec09.applications.OrderService;
import com.gvreactive.sample_reactive_prg.sec09.applications.UserService;


public class Lec10MonoFlatMapMany {
    public static void main(String[] args){
   UserService.getUserId("sam")
                .flatMapMany(userId -> OrderService.getUserOrders(userId))
               .subscribe(Util.subscriber());
     Util.sleepSeconds(3);
    }
}

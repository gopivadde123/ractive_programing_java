package com.gvreactive.sample_reactive_prg.sec09;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec09.applications.Order;
import com.gvreactive.sample_reactive_prg.sec09.applications.OrderService;
import com.gvreactive.sample_reactive_prg.sec09.applications.User;
import com.gvreactive.sample_reactive_prg.sec09.applications.UserService;
import reactor.core.publisher.Flux;

public class Lec11FluxFlatMap {
    public static void main(String[] args){
//     Get all the orders from order service
             UserService.getAllUsers()
              .map(User::id)
                .flatMap(OrderService::getUserOrders,1)
              .subscribe(Util.subscriber());
             Util.sleepSeconds(4);
    }
}

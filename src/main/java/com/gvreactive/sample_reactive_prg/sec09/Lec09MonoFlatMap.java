package com.gvreactive.sample_reactive_prg.sec09;

import com.gvreactive.sample_reactive_prg.common.Util;
import com.gvreactive.sample_reactive_prg.sec09.applications.PaymentService;
import com.gvreactive.sample_reactive_prg.sec09.applications.UserService;
import reactor.core.publisher.Mono;

public class Lec09MonoFlatMap {
    public static void main(String[] args){
//        we have username, Get user account balance
//        UserService.getUserId("sam")
//                .map(userId-> PaymentService.getUserBalance(userId))
//                .subscribe(Util.subscriber());
        // flatmap flattens
//        UserService.getUserId("sam")
//                .flatMap(userId-> Mono.fromSupplier(()->"Hello"+userId))
//                .subscribe(Util.subscriber());
        UserService.getUserId("sam")
                .flatMap(userId-> PaymentService.getUserBalance(userId))
                .subscribe(Util.subscriber());

    }
}

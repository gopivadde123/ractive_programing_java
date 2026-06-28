package com.gvreactive.sample_reactive_prg.sec02;

import com.gvreactive.sample_reactive_prg.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec07MonoRunnable {
    private static final Logger log = LoggerFactory.getLogger(Lec07MonoRunnable.class);

    public static void main(String[] args) {
      getProductName(2)
              .subscribe(Util.subscriber());
    }
    public static Mono<String> getProductName(int productId){
        if(productId == 1){
            return Mono.fromSupplier(() -> Util.faker().commerce().productName()
            );
        }
//        return Mono.empty();
        return Mono.fromRunnable(() -> notifyBusiness(productId));
    }
    private static void notifyBusiness(int productId){
        log.info("notify business on unavailable product {}",productId);
    }
}

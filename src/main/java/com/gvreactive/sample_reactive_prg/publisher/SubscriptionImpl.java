package com.gvreactive.sample_reactive_prg.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private  Subscriber<? super String> subscriber;
    private static final int Max_ITEMS = 10;
    private final Faker faker;
    private boolean isCancelled;
    private int count = 0;
    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber=subscriber;
        this.faker=Faker.instance();
    }

    @Override
    public void request(long requested) {
      if(isCancelled){
          return;
      }
      log.info("subscriber has requested  {} items",requested);
      if(requested > Max_ITEMS){
          this.subscriber.onError(new RuntimeException("validation failed"));
          this.isCancelled=true;
          return;
      }
      for(int i=0; i < requested && count < Max_ITEMS; i++){
          count ++;
          this.subscriber.onNext(this.faker.internet().emailAddress());
      }
      if(count == Max_ITEMS){
          log.info("no more data to produce");
          this.subscriber.onComplete();
          this.isCancelled = true;
      }
    }

    @Override
    public void cancel() {
     log.info("subscriber has cancelled");
     this.isCancelled = true;
    }
}

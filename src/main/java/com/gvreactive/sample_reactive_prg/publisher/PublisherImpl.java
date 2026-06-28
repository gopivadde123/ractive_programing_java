package com.gvreactive.sample_reactive_prg.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class PublisherImpl implements Publisher<String> {
    @Override
    public void subscribe(Subscriber subscriber) {
        var subscription = new SubscriptionImpl(subscriber);
        subscriber.onSubscribe(subscription);
    }
}

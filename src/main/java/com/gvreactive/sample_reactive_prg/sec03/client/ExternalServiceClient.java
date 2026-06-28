package com.gvreactive.sample_reactive_prg.sec03.client;

import com.gvreactive.sample_reactive_prg.common.AbstractHttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    public Flux<String> getNames(){
      return   this.httpClient.get()
                .uri("/demo02/name/stream")
                .responseContent()// get the response
                .asString();
      // next for mono
//                .next();// this takes first item convert into mono
    }
    public Flux<Integer> getPriceChanges(){
        return   this.httpClient.get()
                .uri("/demo02/stock/stream")
                .responseContent()// get the response
                .asString()
                .map(Integer::parseInt);
        // next for mono
//                .next();// this takes first item convert into mono
    }
}

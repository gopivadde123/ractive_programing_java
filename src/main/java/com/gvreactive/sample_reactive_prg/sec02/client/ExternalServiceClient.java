package com.gvreactive.sample_reactive_prg.sec02.client;

import com.gvreactive.sample_reactive_prg.common.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {
    public Mono<String> getProductName(int productId){
      return   this.httpClient.get()
                .uri("/demo01/product/"+productId)
                .responseContent()// get the response
                .asString()
                .next();// this takes first item convert into mono
    }
}

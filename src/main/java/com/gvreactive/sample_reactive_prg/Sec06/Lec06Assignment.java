package com.gvreactive.sample_reactive_prg.Sec06;

import com.gvreactive.sample_reactive_prg.Sec06.assignment.InventoryService;
import com.gvreactive.sample_reactive_prg.Sec06.assignment.RevenueService;
import com.gvreactive.sample_reactive_prg.sec03.client.ExternalServiceClient;

public class Lec06Assignment {
    public static void main(String[] args){
        var client=new ExternalServiceClient();
        var inventoryService=new InventoryService();
        var revenueService=new RevenueService();
        // client.orderStream().subscribe(inventoryService::consume); external call
        // client.orderStream().subscribe(revenueService::consume); external call
        // inventoryService.stream()
        //            .subscribe(Util.subscriber("inventory"));
        // revenueService.stream()
        //            .subscribe(Util.subscriber("inventory"));

    }
}

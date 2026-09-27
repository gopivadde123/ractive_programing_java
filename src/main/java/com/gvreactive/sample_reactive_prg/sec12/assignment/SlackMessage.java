package com.gvreactive.sample_reactive_prg.sec12.assignment;

public record SlackMessage(String sender,String messgae) {
   private static final String MESSAGE_FORMAT="[%s -> %s] : %s";
   public String formatForDelivery(String receiver){
       return MESSAGE_FORMAT.formatted(sender,receiver,messgae);
   }
}

package com.own.eosp.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryListener {

    @EventListener
    public void listener(GreetingEvent event) {
        System.out.println(">> InventoryListener পেল event: " + event.getMessage());
    }
}

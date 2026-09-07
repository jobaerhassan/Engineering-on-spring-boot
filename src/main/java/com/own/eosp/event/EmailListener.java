package com.own.eosp.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @EventListener
    public void listener(GreetingEvent event) {
        System.out.println(">> EmailListener পেল event: " + event.getMessage());
    }
}

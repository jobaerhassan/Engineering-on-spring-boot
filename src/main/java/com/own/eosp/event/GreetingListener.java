package com.own.eosp.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * এই bean টা GreetingEvent "শোনে"।
 * কেউ event publish করলেই @EventListener method টা automatically চলে।
 */
@Component
public class GreetingListener {

    @EventListener
    public void onGreeting(GreetingEvent event) {
        System.out.println(">> Listener পেল event: " + event.getMessage());
    }
}

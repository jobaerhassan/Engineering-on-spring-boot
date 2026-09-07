package com.own.eosp.event;

import lombok.Getter;

/**
 * একটা simple custom event.
 * modern Spring-এ event কে ApplicationEvent extend করতেই হয় না —
 * plain POJO হলেই চলে।
 */
@Getter
public class GreetingEvent {

    private final String message;

    public GreetingEvent(String message) {
        this.message = message;
    }
}

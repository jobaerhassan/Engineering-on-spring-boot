package com.own.eosp.handler;

import com.own.eosp.event.CricketMatchUpdateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class MatchEventHandler {
    private final Set<SseEmitter> emitters = new CopyOnWriteArraySet<>();


    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        return emitter;
    }

    @Async
    @EventListener
    public void cricketMatchUpdate(CricketMatchUpdateEvent event) {
        // we can implement try catch here
        for (SseEmitter sseEmitter : emitters) {
            try {
                sseEmitter.send(event.getMatchInfo());
            } catch (Exception e) {
                emitters.remove(sseEmitter);
            }
        }
    }
}

package com.own.eosp.controller;

import com.own.eosp.model.MatchInfo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Controller
public class LiveMatchController {

    private final Set<SseEmitter> emitters = new CopyOnWriteArraySet<>();

    @GetMapping("/cricket-match")
    public String cricketMatch() {
        return "game-play";
    }

    @GetMapping("/get-match-data")
    public SseEmitter matchData() {
        SseEmitter emitter = new SseEmitter((long)Integer.MAX_VALUE);
        emitter.onError(throwable -> { // browser tab close kore dile or kono karone connection error hole remove from the list
            emitters.remove(emitter);
        });
        emitter.onTimeout(() -> emitters.remove(emitter)); // time out hoye gele remove kore dilam list theke
        emitters.add(emitter); // request er por add kore nilam new emitter
        return emitter;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/update-match-data")
    public void updateMatchData(@RequestBody MatchInfo matchInfo) {
        for(SseEmitter sseEmitter : emitters) {
            try {
                sseEmitter.send(matchInfo);
            } catch (Exception e) {
                emitters.remove(sseEmitter);
            }
        }
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

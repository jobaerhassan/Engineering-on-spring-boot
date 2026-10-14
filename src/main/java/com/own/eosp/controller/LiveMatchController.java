package com.own.eosp.controller;

import com.own.eosp.event.CricketMatchUpdateEvent;
import com.own.eosp.handler.MatchEventHandler;
import com.own.eosp.model.MatchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class LiveMatchController {

    @Autowired
    private MatchEventHandler matchEventHandler;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/cricket-match")
    public String cricketMatch() {
        return "game-play";
    }

    @GetMapping("/get-match-data")
    public SseEmitter matchData() {
        return matchEventHandler.subscribe();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/update-match-data")
    public void updateMatchData(@RequestBody MatchInfo matchInfo) {
        CricketMatchUpdateEvent event = new CricketMatchUpdateEvent(this, matchInfo);
        eventPublisher.publishEvent(event);
    }

    @GetMapping("/calculate")
    public int calculate(@RequestParam int a, @RequestParam int b) throws Exception {
        if (b == 0) {
            throw new Exception("Cannot divide by zero");
        }
        return a / b;
    }
    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

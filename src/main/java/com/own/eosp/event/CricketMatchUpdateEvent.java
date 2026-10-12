package com.own.eosp.event;

import com.own.eosp.model.MatchInfo;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CricketMatchUpdateEvent extends ApplicationEvent {
    private final MatchInfo matchInfo;

    public CricketMatchUpdateEvent(Object source, MatchInfo matchInfo) {
        super(source);
        this.matchInfo = matchInfo;
    }
}

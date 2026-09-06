package com.own.eosp.scope;

import com.own.eosp.model.TimedBean;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

@Component
public class TimedScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return new TimedBean(); // akhon ei custom bean ta prototype er moto kaj kortese. eta ke 5 sec er system moto destroy kore dibe + new create korbe emon banate hobe
    }

    @Override
    public @Nullable Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }
}

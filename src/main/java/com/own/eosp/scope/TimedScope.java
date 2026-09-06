package com.own.eosp.scope;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TimedScope implements Scope {
    private final Map<String, Object> beans = new ConcurrentHashMap<>();

    public TimedScope() {
        new Thread(this::cleanBeans).start();
    }

    private void cleanBeans() {
        while(true) {
            try {
                Thread.sleep(5000);
                beans.clear();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(beans.containsKey(name)) {
            return beans.get(name);
        }

        Object bean = objectFactory.getObject();
        beans.put(name, bean);
        return bean;
    }

    @Override
    public @Nullable Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }
}

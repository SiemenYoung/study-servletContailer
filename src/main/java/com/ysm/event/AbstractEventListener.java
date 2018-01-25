package com.ysm.event;

import com.ysm.handler.*;
import com.ysm.handler.HandlerException;


/**
 * Created by shiming on 2018/1/25.
 */
public abstract class AbstractEventListener<T> implements EventListener<T>{

    @Override
    public void onEvent(T event) throws HandlerException {

        EventHandler eventHandler = getHandler(event);

        eventHandler.handle(event);

    }

    protected abstract EventHandler<T> getHandler(T t);
}

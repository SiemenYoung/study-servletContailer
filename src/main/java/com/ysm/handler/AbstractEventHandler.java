package com.ysm.handler;



import java.io.IOException;

/**
 * Created by shiming on 2018/1/25.
 */
public abstract class AbstractEventHandler<T> implements EventHandler<T> {
    @Override
    public void handle(T obj) throws HandlerException {
        beforeHandle(obj);
        doHandle(obj);
        afterHandle(obj);
    }

    protected void beforeHandle(T obj) {
    }

    protected abstract void doHandle(T obj);

    protected void afterHandle(T obj) {
    }

}
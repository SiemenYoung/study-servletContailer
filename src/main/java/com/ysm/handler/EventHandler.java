package com.ysm.handler;

/**
 * Created by shiming on 2018/1/25.
 */
public interface EventHandler<T> {

    void handle(T event) throws HandlerException;
}

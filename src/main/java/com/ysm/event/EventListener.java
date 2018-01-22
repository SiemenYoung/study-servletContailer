package com.ysm.event;

/**
 * Created by larry01 on 2018/1/22.
 */
public interface EventListener<T> {

    void onEvent(T event) throws EventException;
}

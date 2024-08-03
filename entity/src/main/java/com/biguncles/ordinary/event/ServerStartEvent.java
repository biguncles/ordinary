package com.biguncles.ordinary.event;

import org.springframework.context.ApplicationEvent;

/**
 * 服务启动通知事件
 * @author yc
 * */
public class ServerStartEvent extends ApplicationEvent {

    /**
     * 服务启动事件
     * */
    public ServerStartEvent(Object source) {
        super(source);
    }
}

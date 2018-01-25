/**
 * @Title: SocketEventListener
 * @Package com.ysm.event.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 15:20
 * @version V1.0
 */
package com.ysm.event.impl;

import com.ysm.event.AbstractEventListener;
import com.ysm.handler.EventHandler;
import com.ysm.handler.impl.EchoEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

/**
 * @version 1.0.0
 * @Title: SocketEventListener
 * @Package: com.ysm.event.impl
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 15:20
 */
public class SocketEventListener extends AbstractEventListener<Socket> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketEventListener.class);

    private final EchoEventHandler echoEventHandler;

    public SocketEventListener(EchoEventHandler echoEventHandler) {
        this.echoEventHandler = echoEventHandler;
    }

    @Override
    protected EventHandler<Socket> getHandler(Socket socket) {
        return echoEventHandler;
    }




}

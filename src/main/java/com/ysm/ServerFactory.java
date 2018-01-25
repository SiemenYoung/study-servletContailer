/**
 * @Title: ServerFactory
 * @Package com.ysm
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 17:05
 * @version V1.0
 */
package com.ysm;

import com.ysm.config.ServerConfig;
import com.ysm.event.EventListener;
import com.ysm.event.impl.SocketEventListener;
import com.ysm.handler.impl.EchoEventHandler;
import com.ysm.impl.SimpleServer;
import com.ysm.io.Connector;
import com.ysm.io.ConnectorFactory;
import com.ysm.io.socket.SocketConnectorConfig;
import com.ysm.io.socket.SocketConnectorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @Title: ServerFactory
 * @Package: com.ysm
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 17:05
 */
public class ServerFactory {

    /**
     * 返回server实例
     * @return
     */
    public static  Server produce(ServerConfig serverConfig) {

        List<Connector> list = new ArrayList<>();

        EventListener eventListener =
                new SocketEventListener(new EchoEventHandler());

        ConnectorFactory connectorFactory =
                new SocketConnectorFactory(new SocketConnectorConfig(serverConfig.getPORT()),eventListener);

        list.add(connectorFactory.getConnector());

        return new SimpleServer(serverConfig,list);
    }
}

/**
 * @Title: SocketConnectorFactory
 * @Package com.ysm.io.socket
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 11:42
 * @version V1.0
 */
package com.ysm.io.socket;

import com.ysm.event.EventListener;
import com.ysm.io.Connector;
import com.ysm.io.ConnectorFactory;

/**
 * @version 1.0.0
 * @Title: SocketConnectorFactory
 * @Package: com.ysm.io.socket
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 11:42
 */
public class SocketConnectorFactory implements ConnectorFactory {

    private final SocketConnectorConfig socketConnectorConfig;

    private final EventListener eventListener;

    public SocketConnectorFactory(SocketConnectorConfig socketConnectorConfig,EventListener eventListener) {
        this.socketConnectorConfig = socketConnectorConfig;
        this.eventListener = eventListener;
    }

    @Override
    public Connector getConnector() {
        return new SocketConnector(this.socketConnectorConfig.getPort(),eventListener);
    }
}

/**
 * @Title: SimpleServer
 * @Package com.ysm.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 16:58
 * @version V1.0
 */
package com.ysm.impl;

import com.ysm.Server;
import com.ysm.config.ServerConfig;
import com.ysm.ServerStatus;
import com.ysm.io.Connector;
import com.ysm.io.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


/**
 * @version 1.0.0
 * @Title: SimpleServer
 * @Package: com.ysm.impl
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 16:58
 */
public class SimpleServer implements Server {

    private static Logger logger = LoggerFactory.getLogger(SimpleServer.class);

    private volatile ServerStatus serverStatus = ServerStatus.STOPED;

    private final int PORT ;

    private final List<Connector> connectorList;


    public SimpleServer(ServerConfig serverConfig,List<Connector> connectorList) {
        this.connectorList = connectorList;
        this.PORT = serverConfig.getPORT();
    }


    @Override
    public void start() {
        connectorList.stream().forEach(connector -> connector.start());
        this.serverStatus = ServerStatus.STARTED;


    }

    @Override
    public void stop() {

        connectorList.stream().forEach(connector -> connector.stop());
        this.serverStatus = ServerStatus.STOPED;
        logger.info("Server stop");
    }

    @Override
    public ServerStatus getStatus() {

        return serverStatus;

    }

    public int getPORT(){

        return this.PORT;

    }
}

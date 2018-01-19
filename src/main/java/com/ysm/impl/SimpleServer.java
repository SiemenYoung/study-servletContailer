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
import com.ysm.ServerConfig;
import com.ysm.ServerStatus;

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

    private ServerStatus serverStatus = ServerStatus.STOPED;

    private final int PORT ;


    public SimpleServer(ServerConfig serverConfig) {
        this.PORT = serverConfig.getPORT();
    }

    @Override
    public void start() {

        serverStatus = ServerStatus.STARTED;

        System.out.println("server start ");
    }

    @Override
    public void stop() {

        serverStatus = ServerStatus.STOPED;

        System.out.println("server end ");
    }

    @Override
    public ServerStatus getStatus() {

        return serverStatus;

    }

    public int getPORT(){

        return this.PORT;

    }
}

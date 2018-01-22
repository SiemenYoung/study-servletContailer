/**
 * @Title: SocketConnectorConfig
 * @Package com.ysm.io.socket
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 11:42
 * @version V1.0
 */
package com.ysm.io.socket;

/**
 * @version 1.0.0
 * @Title: SocketConnectorConfig
 * @Package: com.ysm.io.socket
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 11:42
 */
public class SocketConnectorConfig {

    private final int port;

    public SocketConnectorConfig(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}

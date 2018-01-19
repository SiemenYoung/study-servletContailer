/**
 * @Title: ServerConfig
 * @Package com.ysm
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 17:26
 * @version V1.0
 */
package com.ysm;

/**
 * @version 1.0.0
 * @Title: ServerConfig
 * @Package: com.ysm
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 17:26
 */
public class ServerConfig {

    public static final int DEFAULT_PORT = 18080;

    private final int PORT ;

    public ServerConfig() {
        this.PORT = DEFAULT_PORT;
    }

    public ServerConfig(int port) {
        this.PORT = port;
    }

    public int getPORT(){

        return this.PORT;

    }
}

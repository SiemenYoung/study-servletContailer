/**
 * @Title: BootStrap
 * @Package com.ysm
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 15:35
 * @version V1.0
 */
package com.ysm;

import com.ysm.config.ServerConfig;

import java.io.IOException;

/**
 * @version 1.0.0
 * @Title: BootStrap
 * @Package: com.ysm
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 15:35
 */
public class BootStrap {

    public static void main(String[] args) throws IOException {
        ServerConfig serverConfig = new ServerConfig();
        Server server = ServerFactory.produce(serverConfig);
        server.start();
    }

}

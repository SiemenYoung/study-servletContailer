/**
 * @Title: TestServer
 * @Package com.ysm
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 16:59
 * @version V1.0
 */
package com.ysm;

import com.ysm.impl.SimpleServer;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @version 1.0.0
 * @Title: TestServer
 * @Package: com.ysm
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 16:59
 */
public class TestServer {

    private static  Server server ;

    @BeforeClass
    public static void init() {

        ServerConfig serverConfig = new ServerConfig();

        server = ServerFactory.produce(serverConfig);

    }

    @Test
    public void testServerStart() {

        server.start();

        assertTrue("服务器启动后，状态是STARTED",server.getStatus().equals(ServerStatus.STARTED));
    }

    @Test
    public void testServerStop() {

        server.stop();

        assertTrue("服务器关闭后，状态是STOPED",server.getStatus().equals(ServerStatus.STOPED));
    }
    @Test
    public void testServerPort() {

        int port = server.getPORT();

        assertTrue("默认端口号", ServerConfig.DEFAULT_PORT == port);
    }


}

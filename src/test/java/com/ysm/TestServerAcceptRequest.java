/**
 * @Title: TestServerAcceptRequest
 * @Package com.ysm
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 17:54
 * @version V1.0
 */
package com.ysm;

import com.ysm.config.ServerConfig;
import com.ysm.io.IoUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import static org.junit.Assert.assertTrue;

/**
 * @version 1.0.0
 * @Title: TestServerAcceptRequest
 * @Package: com.ysm
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 17:54
 */
public class TestServerAcceptRequest extends TestServerBase{

    private static Logger logger = LoggerFactory.getLogger(TestServerAcceptRequest.class);

    private static Server server;
    // 设置超时时间为500毫秒
    private static final int TIMEOUT = 500;

    @BeforeClass
    public static void init() {
        ServerConfig serverConfig = new ServerConfig();
        server = ServerFactory.produce(serverConfig);
    }

    @Test
    public void testServerAcceptRequest() {

        if (server.getStatus().equals(ServerStatus.STOPED)) {

            startServer(server);

            waitServerStart(server);

            Socket socket = new Socket();

            SocketAddress endPoint = new InetSocketAddress("localhost", ServerConfig.DEFAULT_PORT);

            try {
                socket.connect(endPoint,TIMEOUT);

                assertTrue("服务器启动后，能接受请求", socket.isConnected());
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                IoUtils.closeQuietly(socket);
            }
        }
    }


    @AfterClass
    public static void destroy() {
        server.stop();
    }


}

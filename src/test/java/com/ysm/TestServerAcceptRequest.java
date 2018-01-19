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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
public class TestServerAcceptRequest {

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
            new Thread(() -> {
                server.start();
            }).run();

            while (server.getStatus().equals(ServerStatus.STOPED)) {

                System.out.println(" 等待启动中");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Socket socket = new Socket();

                SocketAddress endPoint = new InetSocketAddress("localhost", ServerConfig.DEFAULT_PORT);

                try {
                    socket.connect(endPoint,TIMEOUT);

                    assertTrue("服务器启动后，能接受请求", socket.isConnected());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @AfterClass
    public static void destroy() {
        server.stop();
    }
}

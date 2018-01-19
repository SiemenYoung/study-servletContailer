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

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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

    private volatile ServerStatus serverStatus = ServerStatus.STOPED;

    private final int PORT ;

    private ServerSocket serverSocket;


    public SimpleServer(ServerConfig serverConfig) {
        this.PORT = serverConfig.getPORT();
    }

    @Override
    public void start() {
        Socket socket = null;
        try {
             this.serverSocket = new ServerSocket(this.PORT);

             this.serverStatus = ServerStatus.STARTED;

             System.out.println("server start ");

            while (true) {
                socket = serverSocket.accept();

                System.out.println(
                        "新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public void stop() {

        if (this.serverSocket != null) {
            try {
                this.serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

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

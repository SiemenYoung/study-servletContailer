/**
 * @Title: SocketEventListener
 * @Package com.ysm.event.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 15:20
 * @version V1.0
 */
package com.ysm.event.impl;

import com.ysm.event.EventException;
import com.ysm.event.EventListener;
import com.ysm.io.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @Title: SocketEventListener
 * @Package: com.ysm.event.impl
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 15:20
 */
public class SocketEventListener implements EventListener<Socket> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketEventListener.class);

    @Override
    public void onEvent(Socket socket) throws EventException {

        LOGGER.info("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
        try {
            echo(socket);
        } catch (IOException e) {
            throw new EventException(e);
        }

    }

    private void echo(Socket socket) throws IOException{
        InputStream inputstream = null;
        OutputStream outputStream = null;
        try {
            inputstream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(inputstream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.append("Server connected.Welcome to echo.\n");
            printWriter.flush();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("stop")) {
                    printWriter.append("bye bye.\n");
                    printWriter.flush();
                    break;
                } else {
                    printWriter.append(line);
                    printWriter.append("\n");
                    printWriter.flush();
                }
            }
        } finally {
            IoUtils.closeQuietly(inputstream);
            IoUtils.closeQuietly(outputStream);
        }
    }
}

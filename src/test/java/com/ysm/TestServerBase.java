/**
 * @Title: TestServerBase
 * @Package com.ysm
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 10:56
 * @version V1.0
 */
package com.ysm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @version 1.0.0
 * @Title: TestServerBase
 * @Package: com.ysm
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 10:56
 */
public abstract class TestServerBase {

    private static Logger logger = LoggerFactory.getLogger(TestServerBase.class);


    protected  void  startServer(Server server){
        //在另外一个线程中启动server
        new Thread(() -> {

                server.start();

        }).start();
    }

    protected void waitServerStart(Server server){
        //如果server未启动，就sleep一下
        while (server.getStatus().equals(ServerStatus.STOPED)) {
            logger.info("等待server启动");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}

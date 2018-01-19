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

    private static final Server server = new SimpleServer();

    @BeforeClass

    @Test
    public void testServerStart() {
        server.start();
    }

    @Test
    public void testServerStop() {
        server.stop();
    }
}

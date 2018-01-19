/**
 * @Title: ServerFactory
 * @Package com.ysm
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 17:05
 * @version V1.0
 */
package com.ysm;

import com.ysm.impl.SimpleServer;

/**
 * @version 1.0.0
 * @Title: ServerFactory
 * @Package: com.ysm
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 17:05
 */
public class ServerFactory {

    /**
     * 返回server实例
     * @return
     */
    public static  Server produce() {
        return new SimpleServer();
    }
}

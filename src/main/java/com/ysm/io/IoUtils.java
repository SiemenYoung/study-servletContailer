/**
 * @Title: IoUtils
 * @Package com.ysm.io
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 10:04
 * @version V1.0
 */
package com.ysm.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * @version 1.0.0
 * @Title: IoUtils
 * @Package: com.ysm.io
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 10:04
 */
public class IoUtils {

    private static Logger logger = LoggerFactory.getLogger(IoUtils.class);

    /**
     * 安静地关闭，不抛出异常
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if(closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
        }
    }
}

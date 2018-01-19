/**
 * @Title: Server
 * @Package com.ysm
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/19 16:56
 * @version V1.0
 */
package com.ysm;

/**
 * @version 1.0.0
 * @Title: Server
 * @Package: com.ysm
 * @author yangshiming.ysm
 * @date 2018/1/19 16:56
 */
public interface Server {

    /**
     * 启动服务器
     */
    void start();

    /**
     * 关闭服务器
     */
    void stop();

    /**
     * 获取server状态
     * @return
     */
    ServerStatus getStatus();
}

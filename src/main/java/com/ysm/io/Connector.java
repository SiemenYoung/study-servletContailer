/**
 * @Title: Connector
 * @Package com.ysm.io
 * @Description: TODO
 * Copyright: Copyright (c) 2016
 * Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 11:36
 * @version V1.0
 */
package com.ysm.io;

import com.ysm.LifeCycle;

/**
 * @version 1.0.0
 * @Title: Connector
 * @Package: com.ysm.io
 * @Description: Copyright: Copyright (c) 2016
 * @Company: 成都壹柒互动科技有限公司
 * @author yangshiming.ysm
 * @date 2018/1/22 11:36
 */
public abstract class Connector<T> implements LifeCycle {

    @Override
    public void start() {

        init();

        acceptConnect();
    }

    protected abstract void init() throws ConnectorException;

    protected abstract void acceptConnect() throws ConnectorException;

    protected abstract void whenAccept(T connect) throws ConnectorException;
}

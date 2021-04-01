package com.zy.msgbus;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public interface MsgObserver {
    void notify(Object... params);
}

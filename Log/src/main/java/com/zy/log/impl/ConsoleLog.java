package com.zy.log.impl;

import com.zy.log.IZLog;

/**
 * @author:zhangyue
 * @date:2021/3/29
 */
public class ConsoleLog  implements IZLog {
    @Override
    public void d(String log) {
        System.out.println("");
    }

    @Override
    public void i(String log) {

    }

    @Override
    public void w(String log) {

    }

    @Override
    public void e(String log) {

    }

    @Override
    public void setTag(String tag) {

    }

    @Override
    public void setLogLevel(int level) {

    }
}

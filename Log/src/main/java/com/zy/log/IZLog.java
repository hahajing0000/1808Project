package com.zy.log;

/**
 * @author:zhangyue
 * @date:2021/3/29
 */
public interface IZLog {
    void d(String log);
    void i(String log);
    void w(String log);
    void e(String log);

    void setTag(String tag);
    void setLogLevel(int level);
}

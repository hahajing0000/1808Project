package com.zy.zg6.designmode.command.impl;

import com.zy.zg6.designmode.command.IJSCmd;

/**
 * @author:zhangyue
 * @date:2021/4/2
 */
public class ChenCmd implements IJSCmd {
    @Override
    public int js(int a, int b) {
        return a*b;
    }
}

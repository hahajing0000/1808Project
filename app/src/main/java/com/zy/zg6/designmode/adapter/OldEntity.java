package com.zy.zg6.designmode.adapter;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public class OldEntity implements IEntity {
    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String setName() {
        return null;
    }
}

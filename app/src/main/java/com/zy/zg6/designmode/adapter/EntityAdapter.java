package com.zy.zg6.designmode.adapter;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public class EntityAdapter implements IEntity {

    NewEntity entity=new NewEntity();
    @Override
    public String getName() {
        return entity.getUserName();
    }

    @Override
    public String setName() {
        return entity.setUsername();
    }
}

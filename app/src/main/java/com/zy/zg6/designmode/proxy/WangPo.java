package com.zy.zg6.designmode.proxy;

/**
 * @author:zhangyue
 * @date:2021/4/2
 */
public class WangPo implements IDO{
    private IDO do1;
    public WangPo(IDO _do){
        do1=_do;
    }
    @Override
    public void Do() {
        do1.Do();
    }
}

package com.zy.zg6.designmode.decorator;

/**
 * @author:zhangyue
 * @date:2021/4/2
 */
public class DecoratorTest implements ITest {

    private ITest test;
    public DecoratorTest(ITest _test){
        test=_test;
    }

    @Override
    public void test() {
        test.test();
        System.out.println("new Test");
    }
}

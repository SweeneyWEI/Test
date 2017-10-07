package org.Test.Proxy;

import java.lang.reflect.Proxy;

/**
 * Created by weixin on 17-8-11.
 */
public class TestDog {
    public static void main(String[] args) {
        Dog target = new PedigreeDog();
        MyInvokeHandler handler = new MyInvokeHandler();
        handler.setTarget(target);
        Dog dog =(Dog) Proxy.newProxyInstance(target.getClass().getClassLoader(),//静态代理
                target.getClass().getInterfaces(),handler);
        dog.run();
        dog.info();
    }
}

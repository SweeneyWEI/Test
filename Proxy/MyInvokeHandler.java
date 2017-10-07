package org.Test.Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;

/**
 * Created by weixin on 17-8-11.
 */
public class MyInvokeHandler implements InvocationHandler {
    private Object target;
    public void setTarget(Object target){
         this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogExtern dogExtern=new DogExtern();
        dogExtern.method1();
        Object result=method.invoke(target,args);
        dogExtern.method2();
        return result;
    }
}

package org.Test.Instances.Singleton;

/**
 * Created by weixin on 17-9-23.
 */
public class SingleExample {
//    private static final SingleExample example=new SingleExample();//饿汉模式
//    private SingleExample(){
//
//    }
//    public static SingleExample getInstance(){
//        return example;
//    }
//
//}
    private static volatile SingleExample INSTANCE=null;//懒汉模式
    private SingleExample(){

    }
    public static SingleExample getInstance(){
        if(INSTANCE==null){
            synchronized (SingleExample.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleExample();
                }
            }
        }
        return INSTANCE;
    }
}

package org.Test.Instances;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weixin on 17-8-24.
 */
class MyThread implements Runnable{

//    static int a=0;
    static AtomicInteger integer=new AtomicInteger(0);
    @Override
    public void run() {
        for(int i=0;i<100000;i++){
//            a++;
            integer.getAndIncrement();
        }
//        System.out.println(integer);
    }
}
public class atomicInteger {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread=new MyThread();
        Thread t1=new Thread(thread);
        Thread t2=new Thread(thread);
        t1.start();
        t2.start();
        Thread.sleep(500);
        System.out.println(MyThread.integer.get());

    }
}

package org.Test.Instances;

/**
 * Created by weixin on 17-9-23.
 */
public class ThreadTest {
    public static ThreadLocal<String> threadLocal=new ThreadLocal<String>();
    public static void main(String[] args) {
        Thread a=new Thread(){
            public void run(){
                for(int i=0;i<10;i++){
                    threadLocal.set(threadLocal.get()+".."+i);
                }
                System.out.println(Thread.currentThread().getName()+".."+threadLocal.get());
            }
        };
        Thread b=new Thread(){
            public void run(){
                for(int i=0;i<15;i++){
                    threadLocal.set(threadLocal.get()+".."+i);
                }
                System.out.println(Thread.currentThread().getName()+".."+threadLocal.get());
            }
        };
        a.start();
        b.start();
    }
}

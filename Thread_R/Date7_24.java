package org.Test.Thread_R;

/**
 * Created by weixin on 17-7-24.
 */

class Mytask implements Runnable{


    @Override
    public void run() {
        for(int a=1;a<2;a++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName());
    }
}
public class Date7_24 {
    public static void main(String[] args) throws InterruptedException {
        Mytask matask=new Mytask();
        Thread t1=new Thread(matask,"aaaa");
        t1.setPriority(2);
        t1.setDaemon(true);
        t1.start();//start时执行run（）
//        t1.join();//join()必须t1结束之后继续执行main主线程
        Mytask matask1=new Mytask();
        Thread t2=new Thread(matask1,"bbbb");
        t2.setPriority(10);
        t2.setDaemon(true);
        t2.start();
//        t2.join();
        System.out.println("ok");//跟着main主线程执行。
    }
}

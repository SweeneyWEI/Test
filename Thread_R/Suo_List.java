package org.Test.Thread_R;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.ConcurrentMap;

/**
 * Created by weixin on 17-7-24.
 */
//long state = System.currentTimeMillis();//时间
class MyRun implements Runnable {
    final Object Lock="";
    static ArrayList<String> arrl = new ArrayList<String>();
    private String job;

       public MyRun(String str) {
        job = str;
    }
    class Read{
        public void add(){
            arrl.add(0, String.valueOf(new Random().nextInt(100))+"  1");

        }
    }
    @Override
    public void run() {
        Read a=new Read();
        while(true) {
//            synchronized (Lock) {
            if (job.equals("Read")) {
                a.add();
//                    System.out.println(Thread.currentThread().getName());
            } else if (job.equals("Write")) {
                if (arrl.size() > 0) {
                    arrl.remove(0);
                    System.out.println(arrl.get(0)+"  "+arrl.size()+"  2");
                }
                else{
                    a.add();
                }
            }
        }
    }
}
public class Suo_List {
    public static void main(String[] args) {
        ExecutorService Pool=Executors.newFixedThreadPool(2);
        MyRun a = new MyRun("Read");
        MyRun b = new MyRun("Write");
        Pool.submit(new Thread(a));
        Pool.submit(new Thread(b));
        Pool.shutdown();
    }
}



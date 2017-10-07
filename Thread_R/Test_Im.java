package org.Test.Thread_R;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by weixin on 17-7-26.
 */

public class Test_Im {
    static ArrayBlockingQueue arrl=new ArrayBlockingQueue(100);

    public static void main(String[] args) {
        final Test_Im T_i = new Test_Im();
        ScheduledThreadPoolExecutor Pool = new ScheduledThreadPoolExecutor(5);
        Pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                T_i.arrl.add(String.valueOf(new Random().nextInt(100)));
                try {
                    System.out.println("size:"+T_i.arrl.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
            Pool.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
//                        System.out.println(T_i.arrl.poll());
                        System.out.println("The random num:"+T_i.arrl.poll());

                }

            }, 1000, 2000, TimeUnit.MILLISECONDS);
        }
    }


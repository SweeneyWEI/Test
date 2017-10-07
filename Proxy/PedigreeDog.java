package org.Test.Proxy;

/**
 * Created by weixin on 17-8-11.
 */
public class PedigreeDog implements Dog {
    @Override
    public void run() {
        System.out.println("PedigreeDog is running");
    }

    @Override
    public void info() {
        System.out.println("PedigreeDog's info");
    }
}

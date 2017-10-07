package org.Test.Instances.Singleton;

/**
 * Created by weixin on 17-9-23.
 */
public class Queen {
    private static final Queen queen=new Queen();
    public String name;
    private Queen() {
    }
    public static Queen getInstance(){
        return queen;
    }
    public void say(){
        System.out.println("本宫是环环，而等跪安吧");
    }
}

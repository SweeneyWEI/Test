package org.Test.Instances.Singleton;

/**
 * Created by weixin on 17-9-23.
 */
public class Maid {
    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            Queen queen=Queen.getInstance();
//            Queen queen1=Queen.getInstance();
//            queen.name="huanhuan";
//            queen1.name="缓缓";
//            System.out.println(queen.name+"..."+queen1.name);
            System.out.println("今天是第"+i+"天请安！");
            queen.say();
        }
    }
}

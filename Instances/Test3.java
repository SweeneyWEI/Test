package org.Test.Instances;

/**
 * Created by weixin on 17-7-21.
 */
abstract class T3{
    public boolean readTTY(){
        Object t=new Object();
        read(t);
        return true;
    }
    abstract protected boolean read(Object t);
}
class T4 extends T3{
    @Override
    protected boolean read(Object t) {
        System.out.println("aaaaaa");
        return true;
    }
}
public class Test3 {
    public static void main(String[] args) throws Exception {
        T3 a=new T4();
        a.readTTY();
    }
}

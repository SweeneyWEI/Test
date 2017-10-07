package org.Test.Instances;

/**
 * Created by weixin on 17-7-20.
 */
class T{
    static int a;

}
class T1 {
    static int a;


}
public class Test2 {



    public static void main(String[] args) {
        T t1=new T();
        T t2=new T();
        T1 t3=new T1();
        t1.a=2;
        t3.a=3;
        System.out.println(T.a);
        System.out.println(t2.a);


    }
}

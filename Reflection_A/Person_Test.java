package org.Test.Reflection_A;

/**
 * Created by weixin on 17-8-12.
 */
public class Person_Test {
    public String name;
    public String age;
    public String sex;

    public Person_Test(){

    }
    public Person_Test(String name,String age,String sex){
        this.age=age;
        this.name=name;
        this.sex=sex;
    }
    public void show(int a){
        System.out.println("i'm a good person.");
    }

}

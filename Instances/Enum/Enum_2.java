package org.Test.Instances.Enum;

/**
 * Created by weixin on 17-8-31.
 */
public enum Enum_2 {
    MALE("weixin"),FAMALE("leizong");
    private String name;
    private Enum_2(String name){
        this.name=name;
    }


    public static void main(String[] args) {
        System.out.println(Enum_2.MALE.name);
        System.out.println(Enum_2.FAMALE.name);
    }
}

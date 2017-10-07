package org.Test.Instances.Enum;

/**
 * Created by weixin on 17-8-31.
 */
public enum Enum_5 implements Enum_4{
    MALE("wx"){
        @Override
        public void info() {
            System.out.println(MALE.str);//(this.str)即为错
        }
    },
    FAMALE("aa"){
        @Override
        public void info() {
            System.out.println("asdddd");
        }
    };
    private String str;
    private Enum_5(String str){
        this.str=str;
    }

    public static void main(String[] args) {
        Enum_5.MALE.info();
    }
}

package org.Test.Instances.Enum;

/**
 * Created by weixin on 17-8-31.
 */
abstract public class Enum_3 {
    private String str;
    public Enum_3(String str){
        this.str=str;
    }
    public static Enum_3 enum3=new Enum_3("XM") {
        @Override
        public void xxxx() {
            System.out.println("ssssssss");
        }
    };
    public static Enum_3 enum4=new Enum_3("MX") {
        @Override
        public void xxxx() {
            System.out.println("aaaaaaaaaa");
        }
    };

    abstract public void xxxx();

    public static void main(String[] args) {
        System.out.println(Enum_3.enum3.str);
        enum3.xxxx();
    }

}

package org.Test.Instances.Enum;

/**
 * Created by weixin on 17-8-31.
 */
public enum Enum_1 {
    PLUS{
        @Override
        public double eval(double x, double y) {
            return x+y;
        }
    },
    SUB{
        @Override
        public double eval(double x, double y) {
            return x-y;
        }
    },
    MULTI{
        @Override
        public double eval(double x, double y) {
            return x*y;
        }
    },
    DIVIDE{
        @Override
        public double eval(double x, double y) {
            return x/y;
        }
    };
    public abstract double eval(double x,double y);

    public static void main(String[] args) {
        System.out.println(Enum_1.PLUS.eval(5,5));
        System.out.println(Enum_1.SUB.eval(5,2));
        System.out.println(Enum_1.MULTI.eval(2,6));
        System.out.println(Enum_1.DIVIDE.eval(5,2));
    }
}

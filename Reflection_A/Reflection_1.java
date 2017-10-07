package org.Test.Reflection_A;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by weixin on 17-8-11.
 */
public class Reflection_1 {
    public static void main(String[] args) {
        try {
            String classname="org.Test.Reflection_A.Person_Test";
            Class clazz = Class.forName(classname);
            showFeild(clazz);
            showConstructor(clazz);
            showMethod(clazz);
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

        public static void showFeild(Class clazz){
            Field fields[]=clazz.getDeclaredFields();
            for(Field f:fields){
                String m= Modifier.toString(f.getModifiers());
                Class type=f.getType();
                String t=f.getName();
                System.out.println(m+" "+type+" "+t);
            }
    }

    public static void showConstructor(Class clazz2){
        Constructor constructors[]=clazz2.getConstructors();
        for(Constructor c:constructors){
            String C=Modifier.toString(c.getModifiers());
            String q=c.getName();
            System.out.println(C+"123"+q);
            Class[] params=c.getParameterTypes();
            for(int i=0;i<params.length;i++){
                System.out.println(params[i].getSimpleName()+",");
            }

        }

    }
    public static void showMethod(Class clazz3){
        Method methods[]= clazz3.getMethods();
        for(Method m:methods){
            String p=Modifier.toString(m.getModifiers());
            String g=m.getName();
            System.out.println("方法名："+g);
            Class returntype=m.getReturnType();
            System.out.println("返回类型："+returntype);
            Class[] params=m.getParameterTypes();
            for(int i=0;i<params.length;i++){
                System.out.println("方法参数类型："+params[i].getSimpleName());
            }
        }
    }

}

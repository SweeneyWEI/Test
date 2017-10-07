package org.Test.Instances.Enum;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by weixin on 17-8-31.
 */
public class Generic {
    private Map<String,Integer>score;

    public static void main(String[] args) throws NoSuchFieldException {
        Class<Generic> clazz=Generic.class;
        Field f=clazz.getDeclaredField("score");
        Class<?> a=f.getType();
        System.out.println("score的类型："+a);
        Type gType=f.getGenericType();
        System.out.println(gType.getClass().toString());

        if(gType instanceof ParameterizedType){
            ParameterizedType pType=(ParameterizedType)gType;
            Type rType=pType.getRawType();
            System.out.println("原始类型："+rType);
            Type[] types=pType.getActualTypeArguments();
            for(int i=0;i<types.length;i++){
                System.out.println("第"+i+"个泛型类型为："+types[i]);
            }
        }
    }
}

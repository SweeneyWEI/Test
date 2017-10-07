package org.Test.Instances;

/**
 * Created by weixin on 17-7-28.
 */
import java.io.*;
import java.lang.reflect.AccessibleObject;

public class Test5 {

    public static void main(String[] args) throws IOException {
        File tmp=File.createTempFile("aaa",null);
        tmp.deleteOnExit();
        RandomAccessFile ran=new RandomAccessFile("a.txt","rw");
        FileInputStream tmpIn=new FileInputStream(tmp);
        FileOutputStream tmpOut=new FileOutputStream(tmp);
        ran.seek(9);
        byte [] by=new byte[60];
        int hasRead=0;
        hasRead=ran.read(by);
        tmpOut.write(by,0,hasRead);
        ran.seek(9);
        String str="";
        str=" OK ";
        ran.write(str.getBytes());
        hasRead=tmpIn.read(by);
        ran.write(by,0,hasRead);
        tmpIn.close();
        tmpOut.close();
        ran.close();

    }
}

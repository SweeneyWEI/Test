package org.Test.Serialize;

import java.io.*;
import java.text.MessageFormat;

/**
 * Created by weixin on 17-7-30.
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializePerson();
        try{
            Person p=DeserializePerson();
            System.out.println(MessageFormat.format("姓名={0},性别={1},年龄={2},学号={3}",
                    p.getName(),p.getSex(),p.getAge(),p.getSnumber()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void SerializePerson() throws IOException {
        Person person=new Person();

        person.setName("Sweeney");//存入java内存
        person.setSex("male");
        person.setAge(20);
        person.setSnumber(28);

//        System.out.println(person+"0000000000");

        ObjectOutputStream ab=new ObjectOutputStream(new FileOutputStream("a.txt"));//存入硬盘（文件...）
        ab.writeObject(person);
        System.out.println("Serialization Success");
        ab.close();
    }
    private static Person DeserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream cd=new ObjectInputStream(new FileInputStream("a.txt"));
        Person person=(Person)cd.readObject();
        System.out.println("Deserialization Success");
        cd.close();
        return person;
    }
}

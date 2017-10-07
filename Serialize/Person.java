package org.Test.Serialize;

import java.io.Serializable;

/**
 * Created by weixin on 17-7-30.
 */
public class Person implements Serializable{
    private String name;
    private String sex;
    private int age;
    private int Snumber;

    public int getSnumber() {
        return Snumber;
    }

    public void setSnumber(int snumber) {
        Snumber = snumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

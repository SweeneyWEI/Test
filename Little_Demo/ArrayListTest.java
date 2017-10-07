package org.Test.Little_Demo;

import java.util.*;

/**
 * Created by weixin on 17-7-21.
 */


public class ArrayListTest<E> {
    int MySize = 0;//the number of elements.
    Object[] Arr;
    private static final int Def_Size = 2;//define the initial length.

    public ArrayListTest() {
        this.Arr = new Object[Def_Size];//cover the Arr.length with the Def_Size
    }


    private void Extend() {//grow
        int OldLength = Arr.length;
        int NewLength = OldLength + (OldLength >> 1);
        if (MySize > OldLength * 0.8f)
            Arr = Arrays.copyOf(Arr, NewLength);
    }

    public void MyAdd(E a) {//add
        Arr[MySize] = a;
        MySize++;
        Extend();
    }

    public E MyGet(int x) throws Exception {//get
        try{
        if (x>MySize)
            return (E) Arr[x];}
        catch (Exception e){
            throw new Exception("your input is out of bound");
        }
        return (E) Arr[x];
    }

    public void MyDelete(int x) throws Exception {//delete
        if(x<Arr.length){
        for(int i=x;i<MySize-x;i++) {
            Arr[i] = Arr[i + 1];
        }
        }
        else throw new Exception("Out of bound");
    }

    public E MySet(int x,E y) throws Exception {//set
        if(x<Arr.length){
            Arr[x]=y;
            return(E) Arr[x];
        }
        else
            throw new Exception("Out of bound");
    }

    public void MyOutput(){//output
        for(int i=0;i<MySize;i++){
            System.out.println(Arr[i]);
        }
        int Length=Arr.length-MySize;//Delete the empty cell of the List with 2 free.
        if(Length>2){
            Arr=Arrays.copyOf(Arr,MySize+2);

        }
//        System.out.println("the newest length is:"+Arr.length);
    }

    public int MySizeOf(){
       return Arr.length;
    }

    public static void main(String[] args) throws Exception{
        ArrayListTest<String> MyList = new ArrayListTest<String>();
        System.out.println("input:");
        Scanner a=new Scanner(System.in);
        String b=a.nextLine();
        MyList.MyAdd(b);
        MyList.MyAdd("b");
        MyList.MyAdd("c");
        MyList.MyAdd("d");
        MyList.MyAdd("e");
        MyList.MyAdd("f");
        MyList.MyAdd("f");
        MyList.MyAdd("f");
        MyList.MyAdd("f");
//        MyList.MyDelete(23);
//        System.out.println(MyList.MyGet(15));
//        MyList.MySet(8,"asd");
        MyList.MyOutput();
//        System.out.println("the newest length is:"+MyList.MySizeOf());



        }


    }


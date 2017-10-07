package org.Test.Instances;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by weixin on 17-9-14.
 */
public class BackNumber {
    public static void main(String[] args) throws IOException {
        ArrayList list=new ArrayList();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        list.add(reader.readLine());
//        Scanner scanner=new Scanner(System.in);
//        while (scanner.hasNext()){
//            list.add(scanner.nextInt());
//
//        }

        System.out.println(list.size());
    }
}


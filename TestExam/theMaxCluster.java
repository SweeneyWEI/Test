package org.Test.TestExam;

import java.util.Scanner;

/**
 * Created by weixin on 17-8-27.
 */
public class theMaxCluster {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String str=scanner.next();
            int maxlen=1;
            int len=1;
            for(int i=1;i<str.length();i++){
                if(str.charAt(i-1)!=str.charAt(i)){
                    len++;
                    if(len>maxlen){
                        maxlen=len;
                    }else
                    {
                        len=1;
                    }
                }
            }
            System.out.println(maxlen);
        }
    }
}

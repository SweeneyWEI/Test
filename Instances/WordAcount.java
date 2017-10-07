package org.Test.Instances;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weixin on 17-9-22.
 */
public class WordAcount {
        static Map<String,Integer> map=new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        FileReader reader=new FileReader("a.txt");
        BufferedReader reader1=new BufferedReader(reader);
        String string="";
        while ((string=reader1.readLine())!=null) {
            String str[] = string.split("((?=[\\x21-\\x7e]+)[^A-Za-z0-9])| ");
            for (int i = 0; i < str.length; i++) {
                int count = 1;
                for (int j = 0; j < str.length; j++) {
                    if (str[i].equals(str[j])) {
                        map.put(str[i], count++);
                    }
                }
                if (count == 0) {
                    map.put(str[i], 1);
                } else continue;
            }
        }
        System.out.println(map.size()+"..."+map);
//        StringBuffer article=new StringBuffer();
//        article.append("i am a good man ,you are not a good man");
//        System.out.println(article.capacity());
    }
}

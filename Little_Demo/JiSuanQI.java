package org.Test.Little_Demo;

import java.util.*;

/**
 * Created by weixin on 17-7-23.
 */
public class JiSuanQI {
    ArrayList<String> Arr1=new ArrayList();
public JiSuanQI(){
}

    public void InArray(String str) throws Exception {
        int b;
        double m=0;
        for (b = 0; b < str.length(); b++) {
            Arr1.add(str.substring(b, b + 1));
//            System.out.println(Arr1.get(b));
        }
        for (int i = 0; i <Arr1.size(); i++) {
            if (Arr1.get(i).equals("*")) {
                m = Double.parseDouble(Arr1.get(i - 1)) * Double.parseDouble(Arr1.get(i + 1));
                Arr1.add(i - 1, m + "");
                for (int q = 0; q<3; q++) {
                    Arr1.remove(i);
                }
                i--;
            }
            else if(Arr1.get(i).equals("/")){
                m = Double.parseDouble(Arr1.get(i - 1)) / Double.parseDouble(Arr1.get(i + 1));
                Arr1.add(i - 1, m + "");
                for (int q = 0; q<3; q++) {
                    Arr1.remove(i);
                }
                i--;
            }
        }
        for (int i = 0; i <Arr1.size(); i++) {
            if (Arr1.get(i).equals("/")) {
                if (Double.parseDouble(Arr1.get(i + 1)) != 0) {
                    m = Double.parseDouble(Arr1.get(i - 1)) / Double.parseDouble(Arr1.get(i + 1));
                    Arr1.add(i - 1, m + "");
                    for (int q = 0; q < 3; q++) {
                        Arr1.remove(i);
                    }
                    i--;
                } else throw new Exception("Error input!");
            }
        }
        for (int i = 0; i <Arr1.size(); i++) {
            if (Arr1.get(i).equals("+")) {
                m = Double.parseDouble(Arr1.get(i - 1)) + Double.parseDouble(Arr1.get(i + 1));
                Arr1.add(i - 1, m + "");
                for (int q = 0; q < 3; q++) {
                    Arr1.remove(i);
                }
                i--;
            }
            else if(Arr1.get(i).equals("-")){
                m = Double.parseDouble(Arr1.get(i - 1)) - Double.parseDouble(Arr1.get(i + 1));
                Arr1.add(i - 1, m + "");
                for (int q = 0; q<3; q++) {
                    Arr1.remove(i);
                }
                i--;
            }
        }
        for (int i = 0; i <Arr1.size(); i++) {
            if (Arr1.get(i).equals("-")) {
                m = Double.parseDouble(Arr1.get(i - 1)) - Double.parseDouble(Arr1.get(i + 1));
                Arr1.add(i - 1, m + "");
                for (int q = 0; q < 3; q++) {
                    Arr1.remove(i);
                }
                i--;
            }
        }
        for (String re : Arr1)
            System.out.println(re);

    }

    public static void main(String[] args) throws Exception {
        JiSuanQI MyList = new JiSuanQI();
        System.out.println("input:");
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
        MyList.InArray(b);


    }
}

package org.Test.Instances;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by weixin on 17-7-21.
 */
public class Test4 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd" + "  " + "HH:mm:ss");
        System.out.println(sdf.format(d));

        String str = "2017-20-21  15:20:23";

        Date dd = null;
        try {
            dd = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(dd);
    }
}

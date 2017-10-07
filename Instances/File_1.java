package org.Test.Instances;
import java.io.*;

/**
 * Created by weixin on 17-7-28.
 */
public class File_1 {
    public static void main(String[] args) throws IOException {
        try {
            FileWriter fw = new FileWriter("a.txt", false);
            FileWriter fw1 = new FileWriter("b.txt", false);
            FileInputStream fir = new FileInputStream("a.txt");
            FileOutputStream fos = new FileOutputStream("b.txt");
            FileReader fr=new FileReader("b.txt");
            BufferedReader br=new BufferedReader(fr);
            String str="";
            fw.write("HelloWord");
            fw1.write("Nothing");
            fw.flush();
            fw1.flush();
            fw.close();
            fw1.close();
            int read = 0;
            byte[] b = new byte[500];
            read = fir.read(b);
            fos.write(b, 0, read);
            fir.close();
            fos.close();
            System.in.read();
            str=br.readLine();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

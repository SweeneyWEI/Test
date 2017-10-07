package org.Test.Server_Client;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by weixin on 17-8-2.
 */
class Run_1 implements Runnable {
    public void run() {
//        synchronized (Lock) {
        try {
            Socket s = new Socket("127.0.0.1", 30000);
            PrintStream buf=new PrintStream(s.getOutputStream());
            buf.println("/home/weixin/software/html/CRAWLER.html");
            buf.flush();
            BufferedReader reader=new BufferedReader(new InputStreamReader(s.getInputStream()));
            File file=new File("/home/weixin/software/html/CRAWLER.html");
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter buff=new BufferedWriter(fileWriter);
            String string=null;
            while((string=reader.readLine())!=null){
                buff.write(string);
                buff.write("\n");
                buff.flush();
            }
            Desktop dp=Desktop.getDesktop();
            dp.open(new File("/home/weixin/software/html/CRAWLER.html"));
            if(buf!=null)
                buf.close();
                if(buff!=null)
                    buff.close();
            if(reader!=null)
                reader.close();
            if(s!=null)
                s.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Client_1 {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        Run_1 a = new Run_1();
//        Run_1 b=new Run_1();
        executorService.submit(new Thread(a));
//        executorService.submit(new Thread(b));
        executorService.shutdown();
    }
}


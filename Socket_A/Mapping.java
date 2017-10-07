package org.Test.Socket_A;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by weixin on 17-7-26.
 */

class Run extends Thread {
    String strServer;
    String strPage = "/";
     Socket socket = null;
    static int flag=0;
    public Run(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                line = br.readLine();
                System.out.println(line);
//
                String[] array = line.split("GET /");
                String[] array1 = array[1].split(" HTTP");
                System.out.println(array1[0]);
                strServer = array1[0];
                InetAddress addr = InetAddress.getByName(strServer);
                Socket socket = new Socket(addr, 80);
            PrintStream buf=new PrintStream(socket.getOutputStream());
            buf.println("HTTP/1.1 200 OK");
            buf.println("Content-Type:text/html;charset=utf-8");
//                bufr2.write("Content-Length:" + file.length());
            buf.println();
            buf.flush();
//                PrintStream printStream=new PrintStream(socket.getOutputStream());
                BufferedReader bufr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufr2=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));

            bufr2.write("GET " + strPage + " HTTP/1.1\r\n");
            bufr2.write("HOST:" + strServer + "\r\n");
//            bufr2.write("Accept:*/*\r\n");
            bufr2.write("\r\n");
            bufr2.flush();
                    String hasread = null;
                    while ((hasread = bufr.readLine()) != null) {
                        System.out.println(hasread);
                        buf.println(hasread);
                        buf.flush();

                    }
                    if (br != null)
                        br.close();
                    if (buf != null)
                        buf.close();
                    if (bufr != null)
                        bufr.close();


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Mapping {
    public static void main(String[] args) throws InterruptedException {
        try {
            ExecutorService a=Executors.newFixedThreadPool(3);
            ServerSocket S = new ServerSocket(8000);
            while(true) {
                Socket s = S.accept();
                Run t1 = new Run(s);
                a.submit(new Thread(t1));
//                a.shutdown();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("成功");
    }
}

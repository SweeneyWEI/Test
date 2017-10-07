package org.Test.Server_Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by weixin on 17-7-26.
 */

class Run extends Thread {
    Socket socket = null;
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

            String[] array = line.split("GET ");
            String[] array1 = array[1].split(" HTTP");
            System.out.println(array1[0]);
            PrintStream buf = new PrintStream(socket.getOutputStream());
            File file = new File(array1[0]);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            buf.println("HTTP/1.1 200 OK");
            buf.println("Content-Type:text/html;charset:GBK");
            buf.println("Content-Length:" + file.length());
            buf.println();
            buf.flush();
            if (array1[0].equals("/favicon.ico")) {
                buf.println("s");
            } else {
                String hasread = null;
                while ((hasread = bufferedReader.readLine()) != null) {
                    System.out.println(hasread);
                    buf.println(hasread);
                    buf.flush();
                }

                if (br != null)
                    br.close();
                if (buf != null)
                    buf.close();
                if (bufferedReader != null)
                    bufferedReader.close();

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Server_1 {
    public static void main(String[] args) throws InterruptedException {
        try {
            ExecutorService a=Executors.newFixedThreadPool(3);
            ServerSocket S = new ServerSocket(30000);
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

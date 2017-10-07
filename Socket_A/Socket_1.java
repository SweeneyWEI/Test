package org.Test.Socket_A;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by weixin on 17-8-5.
 */
public class Socket_1 {
    public static void main(String[] args){
        String strServer = "blog.csdn.net";
        String strPage = "/xifeijian/article/details/20313977";
        try {

            int port = 80;
            InetAddress addr = InetAddress.getByName(strServer);
            Socket socket=new Socket(addr,port);
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            buf.write("GET "+strPage+" HTTP/1.1\r\n");
            buf.write("HOST:"+strServer+"\r\n");
            buf.write("Accept:*/*\r\n");
            buf.write("\r\n");
            buf.flush();

            BufferedReader bufr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            FileWriter fos = new FileWriter("/home/weixin/software/html/mysqlLock.html");
            String line = "";
            while ((line = bufr.readLine()) != null) {
                fos.write(line);
                fos.flush();
                System.out.println(line);
            }

            buf.close();
            bufr.close();
            fos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

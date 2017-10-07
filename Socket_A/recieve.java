package org.Test.Socket_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by weixin on 17-8-6.
 */
public class recieve {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            ServerSocket s = new ServerSocket(8000);
            System.out.println("等待连接\n");
            while (true) {
                socket = s.accept();
                System.out.println("连接已建立。端口号：" + socket.getPort());
                new MyWebServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyWebServerThread extends Thread {
    private Socket socket;

    MyWebServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            char[] bs = new char[2048];
            PrintStream out = new PrintStream(socket.getOutputStream());
            StringBuilder msg = new StringBuilder();
            socket.setSoTimeout(10);
            // 此处读入请求数据并做相应的处理
            //
            int len =0;
            try {
                while ((len = is.read(bs)) != -1) {
                    msg.append(bs, 0, len);
                    msg.append("\n");
                }
            } catch (Exception ex) {
                 ex.printStackTrace();
            }
            // 下面是由服务器直接生成的主页内容
            // 1、首先向浏览器输出响应头信息
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type:text/html;charset:utf-8");
            out.println();
            // 2、输出主页信息
            out
                    .println("<HTML><BODY>"
                            + "<form method='get'>username:<input type='text' name='username'/>password:<input type='text' name='password'/>" +
                            "<input type='submit' value='GET'/></form><br/>" +"</pre></BODY></HTML>");
            out.flush();
            out.close();
            is.close();
            System.out.println("close");
            // 关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


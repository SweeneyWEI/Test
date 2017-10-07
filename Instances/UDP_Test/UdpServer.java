package org.Test.Instances.UDP_Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created by weixin on 17-9-4.
 */
public class UdpServer {
    public static final int PORT = 30001;
    private static final int DATA_LEN = 4096;
    byte[] inBuff = new byte[DATA_LEN];
    private DatagramPacket inPacket = new DatagramPacket(inBuff,inBuff.length);
    private DatagramPacket outPacket;
    private static int FLAG=0;


    public void init() throws IOException {
        try (
                final DatagramSocket socket = new DatagramSocket(PORT)) {
            for (int i = 0; i < 1000; i++) {
                Scanner scanner=new Scanner(System.in);
                socket.receive(inPacket);
//                System.out.println(inBuff == inPacket.getData());
                System.out.println("他说："+new String(inBuff,0,inPacket.getLength()));
//                byte[] sendData = books[i % 4].getBytes();
                while (scanner.hasNextLine()){
                    byte[] bytes=scanner.nextLine().getBytes();
                    outPacket=new DatagramPacket(bytes,bytes.length,
                            inPacket.getSocketAddress());
                    System.out.println("我说："+new String(bytes,0,bytes.length));
                    socket.send(outPacket);
                    break;
                }
//                outPacket = new DatagramPacket(sendData, sendData.length,
//                        inPacket.getSocketAddress());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        UdpServer server=new UdpServer();
        server.init();
    }
}



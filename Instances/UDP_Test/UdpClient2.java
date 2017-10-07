package org.Test.Instances.UDP_Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by weixin on 17-10-1.
 */
public class UdpClient2 {
    public static final int DEST_PORT=30001;
    public static final String DEST_IP="255.255.255.255";
    private static final int DATA_LEN=4096;
    byte[] inBuff=new byte[DATA_LEN];

    private DatagramPacket inPacket=new DatagramPacket(inBuff,inBuff.length);
    private DatagramPacket outPacket=null;

    public void init() throws IOException {
        try (

                DatagramSocket socket=new DatagramSocket()){
            outPacket=new DatagramPacket(new byte[0],0, InetAddress.getByName(DEST_IP),DEST_PORT);
            FileOutputStream stream=new FileOutputStream("/home/weixin/inPacket.txt");

            Scanner scanner=new Scanner(System.in);
            while (scanner.hasNextLine()){
                byte[] buff=scanner.nextLine().getBytes();
                outPacket.setData(buff);
                socket.send(outPacket);
//                System.out.println(new String(buff,0,outPacket.getLength()));
//                socket.setSoTimeout(5000);
                socket.receive(inPacket);
                System.out.println(inPacket.getAddress()+" "+inPacket.getPort());
                String str=new String(inBuff,0,inPacket.getLength());
                System.out.println(str);
                PrintStream printStream=new PrintStream(stream);
                printStream.println(str);

            }
        }
    }

    public static void main(String[] args) throws IOException {
        UdpClient2 client1=new UdpClient2();
        client1.init();
    }
}

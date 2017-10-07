package org.Test.Instances.UDP_Test;

import com.sun.imageio.spi.FileImageOutputStreamSpi;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by weixin on 17-9-4.
 */
public class UdpClient {
    public static final int DEST_PORT=30000;
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
        UdpClient client=new UdpClient();
        client.init();
    }
}



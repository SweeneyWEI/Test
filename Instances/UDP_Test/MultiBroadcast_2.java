package org.Test.Instances.UDP_Test;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by weixin on 17-9-6.
 */
public class MultiBroadcast_2 {
    private static final String IP="230.0.0.1";
    public static final int PORT=30000;
    private static int DATA_LEN=4096;
    private MulticastSocket socket=null;
    private InetAddress address=null;
    byte[] inBuff=new byte[DATA_LEN];
    private DatagramPacket inPacket=new DatagramPacket(inBuff,inBuff.length);
    private DatagramPacket outPacket=null;


    public void init() throws IOException {
        try {

        socket = new MulticastSocket(PORT);
        address = InetAddress.getByName(IP);
        socket.joinGroup(address);

        while (true) {
            socket.receive(inPacket);
            System.out.println("收到信息：" + new String(inBuff, 0, inPacket.getLength()));
        }
    }finally {
            socket.leaveGroup(address);
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        MultiBroadcast_2 broadcast2=new MultiBroadcast_2();
        broadcast2.init();
    }
}

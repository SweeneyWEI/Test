package org.Test.Instances.UDP_Test;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by weixin on 17-9-6.
 */
public class MultiBroadcast implements Runnable {
    private static final String BROADCAST_IP="230.0.0.1";
    public static final int BROADCAST_PORT=30000;
    private static final int DATA_LEN=4096;
    private MulticastSocket socket=null;
    private InetAddress broadcastAddress=null;
    byte[] inBuff=new byte[DATA_LEN];
    private DatagramPacket inPacket=new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outPacket=null;


    public void init() throws IOException {
        try (
        Scanner scanner=new Scanner(System.in)) {
            socket = new MulticastSocket(BROADCAST_PORT);
            broadcastAddress = InetAddress.getByName(BROADCAST_IP);
            socket.joinGroup(broadcastAddress);
            socket.setLoopbackMode(false);
            outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
            new Thread(this).start();

            while (scanner.hasNextLine()) {
                byte[] buff = scanner.nextLine().getBytes();
                outPacket.setData(buff);
                socket.send(outPacket);
            }
        }finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                socket.receive(inPacket);
                System.out.println(new String(inBuff,0,inPacket.getLength()));
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    socket.leaveGroup(broadcastAddress);
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        MultiBroadcast broadcast=new MultiBroadcast();
        broadcast.init();

    }
}

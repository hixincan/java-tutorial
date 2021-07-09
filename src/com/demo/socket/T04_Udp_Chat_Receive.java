package com.demo.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class T04_Udp_Chat_Receive implements Runnable{
    DatagramSocket socket = null;
    private int fromPort;

    public T04_Udp_Chat_Receive(int fromPort) {
        this.fromPort = fromPort;
        try {
            socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                if ("bye".equals(message)) {
                    break;
                }
                System.out.println("receive：" + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

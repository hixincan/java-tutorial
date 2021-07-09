package com.demo.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class T03_Udp_Server {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        try (
                // udp 服务端需要端口号
                DatagramSocket socket = new DatagramSocket(9090);
        ) {
            socket.receive(packet);

            System.out.println(packet.getAddress().getHostAddress());
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

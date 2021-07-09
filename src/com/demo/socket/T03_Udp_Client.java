package com.demo.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class T03_Udp_Client {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9090;
        // 数据包
        String message = "udp 数据包";
        DatagramPacket packet = new DatagramPacket(message.getBytes(), 0, message.getBytes().length, address, port);

        try (
            // udp 客户端不需要端口号
            DatagramSocket socket = new DatagramSocket();
        ) {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package com.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class T04_Udp_Chat_Send implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;
    private String toAddress;
    private int toPort;

    public T04_Udp_Chat_Send(String toAddress, int toPort)  {
        this.toAddress = toAddress;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = reader.readLine();
                DatagramPacket packet = new DatagramPacket(message.getBytes(), 0, message.getBytes().length, new InetSocketAddress(InetAddress.getByName(toAddress), toPort));
                socket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

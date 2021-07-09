package com.demo.socket;

import java.io.IOException;

public class T04_Udp_Chat_User1 {
    public static void main(String[] args) throws IOException {
        int fromPort = 7050;
        int toPort = 7060;
        // 为什么这里是多线程
        new Thread(new T04_Udp_Chat_Send("localhost", toPort)).start();
        new Thread(new T04_Udp_Chat_Receive(fromPort)).start();

    }
}

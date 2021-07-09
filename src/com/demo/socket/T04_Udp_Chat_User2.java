package com.demo.socket;

import java.io.IOException;

public class T04_Udp_Chat_User2 {
    public static void main(String[] args) throws IOException {
        int fromPort = 7060;
        int toPort = 7050;
        new Thread(new T04_Udp_Chat_Send("localhost", toPort)).start();
        new Thread(new T04_Udp_Chat_Receive(fromPort)).start();


    }
}

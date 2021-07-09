package com.demo.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 建立简单的客户端-服务端通信
 */
public class T01_Tcp_Client {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 9999;
        try(
                Socket s = new Socket(address, port);
                // 输出流对应往里写入
                OutputStream os = s.getOutputStream()
        ) {
            os.write("学海无涯苦作舟".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.demo.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接");
            // 阻塞方法，等待客户端的连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了..");
            new Thread(()->{
                try {
                    handler(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read..");
        // 阻塞方法：等待客户发送数据
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read done..");
        if (read != -1) {
            System.out.println("接收客户端的数据：" + new String(bytes,0,read));
        }
    }
}

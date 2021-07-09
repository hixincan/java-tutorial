package com.demo.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class T01_Tcp_Server {
    public static void main(String[] args) {
        try(
                // 开启一个服务
                ServerSocket ss = new ServerSocket(9999);
                // 同步（阻塞）监听客户端连接
                Socket s = ss.accept();
                // 读取字节流
                InputStream is = s.getInputStream();
                // 防乱码
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ) {

            // 读取字节
            byte[] buffer = new byte[1024];
            int len;

            while((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

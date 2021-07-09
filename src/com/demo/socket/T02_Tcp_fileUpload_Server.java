package com.demo.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class T02_Tcp_fileUpload_Server {
    public static void main(String[] args) {

        try(ServerSocket ss = new ServerSocket(9000);
            Socket socket = ss.accept();
            FileOutputStream fos = new FileOutputStream("solo-copy.jpg");
        ) {
            InputStream is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            // 下载文件
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            socket.getOutputStream().write("下载完毕".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

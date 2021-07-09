package com.demo.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class T02_Tcp_fileUpload_Client {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 9000;
        try (Socket socket = new Socket(address, port);
             // 相对 idea 工程根目录
             FileInputStream fis =  new FileInputStream("solo.jpg");
             // 读取缓冲区
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ) {
            OutputStream os = socket.getOutputStream();
            byte[] buffer = new byte[1024];
            int len ;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            // 文件输出
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            socket.shutdownInput();
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

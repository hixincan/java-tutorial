package com.demo.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class T05_Url_Down {
    public static void main(String[] args) throws IOException {
        try(FileOutputStream fos = new FileOutputStream("media/m.jpg");) {
            URL url = new URL("http://p1.music.126.net/3H3Rm50Yqk1wUuI-s9d84w==/109951166104748558.jpg?imageView&quality=89");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer))!=-1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

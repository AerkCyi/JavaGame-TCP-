package com.huayecai.game;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

//TCP协议的客户端
public class MyFrame {
    public static void main(String[] args) throws IOException {
        //链接到服务器的5000端口
        Socket s = new Socket("frp-cup.top", 15266);
        OutputStream out = s.getOutputStream();
        out.write("你好你好".getBytes());
        out.close();
        s.close();
    }
}

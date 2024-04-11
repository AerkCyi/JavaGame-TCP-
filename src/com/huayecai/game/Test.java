package com.huayecai.game;
import java.io.*;
import java.net.*;
import java.awt.*;


//TCP协议的Server段
public class Test {
    public static void main(String[] args) throws IOException {
        //创建套接字，监听本机5000端口
        ServerSocket ss = new ServerSocket(5000);

        //等待连接,并获取客户端套接字
        System.out.println("正在等待目标......");
        Socket s = ss.accept();

        System.out.println("目标已连接");
        System.out.println("来自" + s.getInetAddress() + "的用户发送的消息如下: ");
        //获取输入流,并读取信息
        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
        int b;
        while((b = bf.read()) != -1){
            System.out.print((char) b);
        }

        s.close();
        bf.close();
        ss.close();
    }
}
package com.huayecai.game.Server;
import java.io.*;
import java.net.*;


//TCP协议的Server段
public class Server {
    public static void main(String[] args) throws IOException {
        //创建套接字，监听本机5000端口
        ServerSocket ss = new ServerSocket(5000);

        //等待连接,并获取客户端套接字
        System.out.println("正在等待目标......");
        Socket s = ss.accept();

        //链接成功提示
        System.out.println("目标已连接");
        System.out.println("来自" + s.getInetAddress().getHostName() + "的用户发送的消息如下: ");


        //获取输入流,并读取信息
        BufferedReader bf = null;
        bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //循环体，等待客户端发送信息
        boolean flag = true;
        while (flag) {
            int b;
            while((b = bf.read()) != -1){
                System.out.print((char) b);
            }
            System.out.println();
        }

        s.close();
        bf.close();
        ss.close();
    }
}
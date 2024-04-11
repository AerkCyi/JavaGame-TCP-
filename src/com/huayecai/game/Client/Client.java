package com.huayecai.game.Client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

//TCP协议的客户端
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String mess;
        //链接到服务器的5000端口
        System.out.println("正在连接服务器......");
        Socket s = new Socket("frp-cup.top", 15266);
        System.out.println("连接服务器成功");
        System.out.println("请输入发送消息(输入#结束）: ");
        OutputStream out = null;
        out = s.getOutputStream();
        boolean flag = true;
        while (flag) {
            mess = sc.nextLine();
            if(mess.equals("#")){
                flag = false;
                break;
            }
            out.write(mess.getBytes());
        }
        out.close();
        s.close();
    }
}

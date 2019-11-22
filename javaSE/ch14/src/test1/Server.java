package test1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("服务端创建完成");
            //阻塞方法，会一直等待客户端的连接

            Socket accept = server.accept();
            //System.out.println("服务端接收到了客户端的请求");

            SocketUtil util = new SocketUtil(accept);

            //负责读取客户端向服务端发送的数据
            new Thread(()->{
                while (true) {
                    String recive = util.recive();
                    System.out.println("客户端->服务端：" + recive);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            //负责向客户端发送数据
            new Thread(()->{
                while (true) {
                    String send = util.send();
                    System.out.println("服务端->客户端：" + send);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

package test1;

import java.io.IOException;
import java.net.Socket;
import java.util.stream.Stream;

public class Client {
    /**
     * 客户端
     * @param args
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);

            SocketUtil util = new SocketUtil(socket);

            //向服务端发送数据
            new Thread(()->{
                while (true) {
                    String send = util.send();//向服务端发送随机的字符串
                    System.out.println("客户端->服务端：" + send);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();

            new Thread(()->{
                while (true) {
                    String msg = util.recive();
                    System.out.println("服务端->客户端:" + msg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("客户端连接服务端时出现异常，" + e.getMessage());
        }
    }
}

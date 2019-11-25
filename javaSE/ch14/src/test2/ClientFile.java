package test2;

import test1.SocketUtil;

import java.io.IOException;
import java.net.Socket;

public class ClientFile {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8889);

            SocketUtil util = new SocketUtil(socket);
            String sendFile = "E:/girl.jpg";
            //向服务端发送文件
            util.sendFile(sendFile);

            String recive = util.recive();
            System.out.println(recive);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

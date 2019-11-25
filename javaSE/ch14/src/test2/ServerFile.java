package test2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8889);

            //等待用户的连接
            Socket accept = serverSocket.accept();
            //接收用户的输入
            InputStream inputStream = accept.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            //保存文件
            String savedPath = "F:/socketFile.jpg";
            OutputStream outputStream = new FileOutputStream(savedPath);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            //IO操作
            byte[] bytes = new byte[1024];
            int i;
            while ((i = bufferedInputStream.read(bytes)) != -1) { //接收客户端数据
                //将数据写到本地文件
                bufferedOutputStream.write(bytes, 0, i);
            }
            //刷新文件输出流
            bufferedOutputStream.flush();
            bufferedOutputStream.close(); //输出文件完毕，关闭流
            System.out.println("服务端接收文件完成");


            OutputStream outputStream1 = accept.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream1);
            dataOutputStream.writeUTF("！！！！！服务端接收数据成功！！！！");
            System.out.println("done");

            //关闭服务端的输出流
            accept.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

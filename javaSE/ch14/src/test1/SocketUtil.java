package test1;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class SocketUtil {
    private Socket socket;

    public SocketUtil(Socket socket) {
        this.socket = socket;
    }

    /**
     * 接收客户端向服务端发送的数据
     */
    public String recive(){
        try {
            InputStream inputStream = this.socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            return dataInputStream.readUTF();//得到客户端的数据
        } catch (IOException e) {
            //System.out.println("服务端接收客户端数据时发生异常，" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从服务端向客户端发送数据
     */
    public String send(){
        try {
            OutputStream outputStream = this.socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String randomString = getRandomString(5);

            dataOutputStream.writeUTF(randomString);
            return randomString;
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("服务端向客户端发送数据时异常，" + e.getMessage());
        }
        return null;
    }

    /**
     * 根据length生产a-zA-Z0-9的随机字符
     * @param length
     * @return
     */
    public static String getRandomString(int length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(3);
            long result;
            switch(number){
                case 0:
                    result=Math.round(Math.random()*25+65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }


        }
        return sb.toString();
    }

    /**
     * 通过网络编程，将本地文件发送到服务端
     * @param localPath
     */
    public void sendFile(String localPath){
        InputStream inputStream = null;
        try {
            //根据路径，得到文件字节输入流
            inputStream = new FileInputStream(localPath);
            //将字节输入流转换为包装流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            //socket的输出流，将文件输出到服务器
            OutputStream outputStream = this.socket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            byte[] arr = new byte[1024];
            int i;
            //一边读
            while ( (i = bufferedInputStream.read(arr)) != -1){
                bufferedOutputStream.write(arr, 0, i);//输出文件
                bufferedOutputStream.flush();
            }
            //socket.close();//双工通道直接关闭
            socket.shutdownOutput();//关闭输出流，告诉服务端，已经没有东西给你了
            System.out.println("客户端发送数据完成");

            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

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
            System.out.println("服务端接收客户端数据时发生异常，" + e.getMessage());
            //e.printStackTrace();
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
            //e.printStackTrace();
            System.out.println("服务端向客户端发送数据时异常，" + e.getMessage());
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
}

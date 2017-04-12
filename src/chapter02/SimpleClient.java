package chapter02;

import java.net.Socket;

public class SimpleClient {
    public static void main(String args[]) throws Exception {
        Socket s1 = new Socket("localhost", 8000);
        System.out.println("第一次连接成功");
        Socket s2 = new Socket("localhost", 8000);
        System.out.println("第二次连接成功");
        Socket s3 = new Socket("localhost", 8000);
        System.out.println("第三次连接成功");
    }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

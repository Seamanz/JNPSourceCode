package chapter03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeoutTester {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        serverSocket.setSoTimeout(6000); //等待客户连接的时间不超过6秒
        Socket socket = serverSocket.accept();
        socket.close();
        System.out.println("服务器关闭");
    }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

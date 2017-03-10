package chapter15;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class HTTPSClient {
    String host = "github.com";
    int port = 443;
    SSLSocketFactory factory;
    SSLSocket socket;

    public static void main(String args[]) throws Exception {
        HTTPSClient client = new HTTPSClient();
        client.createSocket();
        client.communicate();
    }

    public void createSocket() throws Exception {
        factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        socket = (SSLSocket) factory.createSocket(host, port);
        String[] supported = socket.getSupportedCipherSuites();
        System.out.println("SupportedCipherSuites--->"+Arrays.toString(supported));
        socket.setEnabledCipherSuites(supported);
    }

    public void communicate() throws Exception {
        StringBuffer sb = new StringBuffer("GET http://" + host + "/ HTTP/1.1\r\n");
        sb.append("Host:" + host + "\r\n");
        sb.append("Accept: */*\r\n");
        sb.append("\r\n");

        //发出HTTP请求
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(sb.toString().getBytes());

        //接收响应结果
        InputStream socketIn = socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len = socketIn.read(buff)) != -1) {
            buffer.write(buff, 0, len);
        }
        //把字节数组转换为字符串
        String responseStr = new String(buffer.toByteArray())+"";
        System.out.println(responseStr.length() > 1000 ? responseStr.substring(0, 1000) : responseStr);

        socket.close();
    }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

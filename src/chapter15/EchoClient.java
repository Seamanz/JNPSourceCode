package chapter15;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

public class EchoClient {
    private String host = "localhost";
    private int port = 8000;
    private SSLSocket socket;

    public EchoClient() throws IOException {
        //输出跟踪日志
        System.setProperty("javax.net.debug", "all");
        String trustStore = System.getProperty("javax.net.ssl.trustStore", "");
        System.out.println("trustStore = "+trustStore);
        //设置服务端的安全证书文件路径，客户端的TrustManager通过此属性来判断是否信任服务端的安全证书
        System.setProperty("javax.net.ssl.trustStore", "resources/test.keys");
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        socket = (SSLSocket) factory.createSocket(host, port);
        String[] supported = socket.getSupportedCipherSuites();
        socket.setEnabledCipherSuites(supported);
        System.out.println(socket.getUseClientMode() ? "客户模式" : "服务器模式");
    }

    public static void main(String args[]) throws IOException {
        new EchoClient().talk();
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void talk() throws IOException {
        try {
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = localReader.readLine()) != null) {

                pw.println(msg);
                System.out.println(br.readLine());

                if (msg.equals("bye"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

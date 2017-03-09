package chapter15;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HTTPSClientWithListener extends HTTPSClient {
    public static void main(String args[]) throws Exception {
        HTTPSClientWithListener client = new HTTPSClientWithListener();
        client.createSocket();
        client.communicate();
    }

    public void createSocket() throws Exception {
        factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        socket = (SSLSocket) factory.createSocket(host, port);
        String[] supported = socket.getSupportedCipherSuites();
        socket.setEnabledCipherSuites(supported);

        socket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
            public void handshakeCompleted(HandshakeCompletedEvent event) {
                System.out.println("握手结束");
                System.out.println("加密套件为：" + event.getCipherSuite());
                System.out.println("会话为：" + event.getSession());
                System.out.println("通信对方为：" + event.getSession().getPeerHost());
            }
        });
    }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

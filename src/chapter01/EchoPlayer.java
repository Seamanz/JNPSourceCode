package chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EchoPlayer {
    public static void main(String arg[]) throws IOException {
        new EchoPlayer().talk();
    }

    public String echo(String msg) {
        return "echo:" + msg;
    }

    public void talk() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(echo(msg));
            if (msg.equals("bye"))  //当用户输入“bye”，结束程序
                break;
        }
    }
}

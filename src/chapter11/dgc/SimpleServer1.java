package chapter11.dgc;

import javax.naming.Context;
import javax.naming.InitialContext;

public class SimpleServer1 {
    public static void main(String args[]) {
        try {
            System.setProperty("java.rmi.dgc.leaseValue", "3000");
            HelloService service = new HelloServiceImpl();
            Context namingContext = new InitialContext();
            namingContext.rebind("rmi:HelloService", service);
            System.out.println("服务器注册了一个HelloServiceImpl对象");

            //等待客户端获得该远程对象的引用
            while (!service.isAccessed()) Thread.sleep(500);

            namingContext.unbind("rmi:HelloService");
            System.out.println("服务器注销了一个HelloServiceImpl对象");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

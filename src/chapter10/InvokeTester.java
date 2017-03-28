package chapter10;

import java.lang.reflect.Method;

public class InvokeTester {
    public static void main(String[] args) throws Exception {
        Class classType = InvokeTester.class;
        Object invokeTester = classType.newInstance();

        //调用InvokeTester对象的add()方法
        Method addMethod = classType.getMethod("add", int.class, int.class);
        Object result = addMethod.invoke(invokeTester, 100, 200);
        System.out.println(result);

        //调用InvokeTester对象的echo()方法
        Method echoMethod = classType.getMethod("echo", String.class);
        result = echoMethod.invoke(invokeTester, "Hello");
        System.out.println((String) result);
    }

    public int add(int param1, int param2) {
        return param1 + param2;
    }

    public String echo(String msg) {
        return "echo:" + msg;
    }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

package chapter11.dgc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    public boolean isAccessed() throws RemoteException;

    public void access() throws RemoteException;

    public void bye() throws RemoteException;
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

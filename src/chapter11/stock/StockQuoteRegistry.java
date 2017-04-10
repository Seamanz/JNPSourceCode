package chapter11.stock;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockQuoteRegistry extends Remote {
    public void registerClient(StockQuote client) throws RemoteException;

    public void unregisterClient(StockQuote client) throws RemoteException;
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

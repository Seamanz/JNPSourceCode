package chapter11.flight2;

import java.io.Serializable;

//public class Flight{
public class Flight implements Serializable {

    protected String flightNumber;
    protected String origin;
    protected String destination;
    protected String skdDeparture;
    protected String skdArrival;

    public Flight(String aFlightNumber, String anOrigin,
                  String aDestination, String aSkdDeparture, String aSkdArrival) {
        flightNumber = aFlightNumber;
        origin = anOrigin;
        destination = aDestination;
        skdDeparture = aSkdDeparture;
        skdArrival = aSkdArrival;
    }

    public String getFlightNumber() {
        System.out.println("调用getFilghtNumber()，返回" + flightNumber);
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSkdDeparture() {
        return skdDeparture;
    }

    public void setSkdDeparture(String skdDeparture) {
        this.skdDeparture = skdDeparture;
    }

    public String getSkdArrival() {
        return skdArrival;
    }

    public void setSkdArrival(String skdArrival) {
        this.skdArrival = skdArrival;
    }
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/

package org.example;

public class TrafficCop implements Subscriber {

    private Boolean parkingFull = false;
    @Override
    public void notifyWhenParkingIsFull() {
        parkingFull = true;
    }
    public Boolean isParkingFull() {
        return parkingFull;
    }
    @Override
    public void notifyWhenParkingIsAvailable() {
        parkingFull = false;
    }
}

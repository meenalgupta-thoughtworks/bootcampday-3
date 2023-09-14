package org.example;

public class Owner implements Subscriber {
    private Boolean parkingFull = false;

    @Override
    public void notifyWhenParkingIsFull() {
        parkingFull = true;
    }

    @Override
    public void notifyWhenParkingIsAvailable() {
        parkingFull = false;
    }

    public Boolean isParkingFull() {
        return parkingFull;
    }
}

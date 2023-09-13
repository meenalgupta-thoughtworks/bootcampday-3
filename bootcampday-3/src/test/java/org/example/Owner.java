package org.example;

public class Owner implements Subscriber {
    private Boolean parkingFull = false;

    @Override
    public void notifyWhenParkingIsFull() {
        parkingFull = true;
    }

    public Boolean isParkingFull() {
        return parkingFull;
    }
}

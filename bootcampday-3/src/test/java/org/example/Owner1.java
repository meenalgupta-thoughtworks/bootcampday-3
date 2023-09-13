package org.example;

public class Owner1 implements Owner {
    @Override
    public void notifyWhenParkingIsFull() {
        System.out.println("Parking is full . . .");
    }
}

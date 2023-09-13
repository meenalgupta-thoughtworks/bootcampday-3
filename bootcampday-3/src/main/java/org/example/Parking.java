package org.example;

import java.util.List;

public class Parking {

    private static int parkingSlotsCounter = 0;
    private final int CAPACITY;

    public Parking(int capacity) {
        CAPACITY = capacity;
    }

    private static List<Object> parkedVehicles;

    private Boolean isParkingAvailable() {
        return CAPACITY - parkingSlotsCounter > 0;
    }

    public Boolean park() {
        if (this.isParkingAvailable()) {
            parkingSlotsCounter++;
            return true;
        }
        return false;
    }

    public int slotsAvailable() {
        // TODO: need to return counter
        return 0;
    }
}

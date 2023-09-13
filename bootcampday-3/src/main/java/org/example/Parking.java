package org.example;

import org.example.exception.InvalidCapacityException;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private int parkingSlotsCounter = 0;
    private final int CAPACITY;

    public Parking(int capacity) {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity should be a greater than 0.");
        }
        CAPACITY = capacity;
    }

    private List<Car> parkedVehicles = new ArrayList<>();

    private Boolean isParkingAvailable() {
        return CAPACITY - parkingSlotsCounter > 0;
    }

    public Boolean park(Car car) {
        if (this.isParkingAvailable()) {
            parkedVehicles.add(car);
            parkingSlotsCounter++;
            return true;
        }
        return false;
    }

    public Boolean isCarParked(Car car) {
        return parkedVehicles.contains(car);
    }

    public Boolean unPark(Car car) {
        if (parkedVehicles.contains(car)) {
            parkedVehicles.remove(car);
            parkingSlotsCounter--;
            return true;
        }
        return false;
    }

}

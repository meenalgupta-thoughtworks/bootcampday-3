package org.example;

import org.example.exception.InvalidCapacityException;
import org.example.exception.ParkingSlotFullException;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private int parkingSlotsCounter = 0;
    private final int CAPACITY;
    private final Owner owner;

    public Parking(int capacity, Owner owner) {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity should be a greater than 0.");
        }
        CAPACITY = capacity;
        this.owner = owner;
    }

    private List<Parkable> parkedVehicles = new ArrayList<>();

    private Boolean isParkingAvailable() {
        return CAPACITY - parkingSlotsCounter > 0;
    }

    public void park(Parkable vehicle) {
        if (this.isParkingAvailable() && !isCarParked(vehicle)) {
            parkedVehicles.add(vehicle);
            parkingSlotsCounter++;
            if (!this.isParkingAvailable()) owner.notifyWhenParkingIsFull();
        } else {
            throw new ParkingSlotFullException("Parking Slots are full");
        }
    }

    public Boolean isCarParked(Parkable vehicle) {
        return parkedVehicles.contains(vehicle);
    }

    public Boolean unPark(Parkable vehicle) {
        if (parkedVehicles.contains(vehicle)) {
            parkedVehicles.remove(vehicle);
            parkingSlotsCounter--;
            return true;
        }
        return false;
    }
}

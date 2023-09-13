package org.example;

import org.example.exception.InvalidCapacityException;
import org.example.exception.ParkingSlotFullException;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private int parkingSlotsCounter = 0;
    private final int CAPACITY;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public Parking(int capacity) {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity should be a greater than 0.");
        }
        CAPACITY = capacity;
    }

    private List<Parkable> parkedVehicles = new ArrayList<>();

    private Boolean isParkingAvailable() {
        return CAPACITY - parkingSlotsCounter > 0;
    }

    public void park(Parkable vehicle) {
        if (this.isParkingAvailable() && !isCarParked(vehicle)) {
            parkedVehicles.add(vehicle);
            parkingSlotsCounter++;
            if (!this.isParkingAvailable()) this.notifySubscribers();
        } else {
            throw new ParkingSlotFullException("Parking Slots are full");
        }
    }

    private void notifySubscribers() {
        this.subscribers.forEach(Subscriber::notifyWhenParkingIsFull);
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

    public void addSubscriber(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }
    public void removeSubscriber(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        }
    }
}

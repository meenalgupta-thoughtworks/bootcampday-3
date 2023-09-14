package org.example;

import org.example.exception.InvalidCapacityException;
import org.example.exception.ParkingSlotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    @Test
    public void shouldReturnTrueWhenPark1Car() {
        Subscriber subscriber1 = new Owner();
        Parking parking = new Parking(1);
        Car car1 = new Car();
        parking.park(car1);
        Boolean isParked = parking.isCarParked(car1);
        assertTrue(isParked);
    }

    @Test
    public void shouldReturnTrueWhenPark2Car() {
        Subscriber subscriber1 = new Owner();
        Parking parking = new Parking(2);
        Car car1 = new Car();
        Car car2 = new Car();
        parking.park(car1);
        parking.park(car2);
        Boolean secondCarParked = parking.isCarParked(car2);
        assertTrue(secondCarParked);
    }

    @Test
    public void shouldReturnFalseIfSlotsAreNotAvailable() {
        Subscriber subscriber1 = new Owner();
        Parking parking = new Parking(1);
        Car car1 = new Car();
        Car car2 = new Car();
        parking.park(car1);
        assertThrows(ParkingSlotFullException.class, () -> parking.park(car2));
    }

    @Test
    public void shouldReturnTrueIfCarIsParked() {
        Subscriber subscriber1 = new Owner();
        Parking parking = new Parking(1);
        Car car1 = new Car();
        parking.park(car1);
        Boolean isParked = parking.isCarParked(car1);
        assertTrue(isParked);
    }

    @Test
    public void shouldReturnFalseIfCarIsNotParked() {
        Subscriber subscriber1 = new Owner();
        Parking parking = new Parking(1);
        Car car1 = new Car();
        Boolean isParked = parking.isCarParked(car1);
        assertFalse(isParked);
    }

    @Test
    public void shouldReturnTrueIfCarIsUnParked() {
        Subscriber subscriber1 = new Owner();
        Parking parking = new Parking(1);
        Car car1 = new Car();
        parking.park(car1);
        Boolean isUnParked = parking.unPark(car1);
        assertTrue(isUnParked);
    }

    @Test
    public void shouldReturnFalseIfCarNotParked() {
        Subscriber subscriber1 = new Owner();
        Parking parking = new Parking(1);
        Car car1 = new Car();
        Boolean isUnParked = parking.unPark(car1);
        assertFalse(isUnParked);
    }

    @Test
    public void shouldReturnFalseWhenSameCarIsParked() {
        Subscriber subscriber1 = new Owner();
        Parking parking = new Parking(2);
        Car car1 = new Car();
        parking.park(car1);
        assertThrows(ParkingSlotFullException.class, () -> parking.park(car1));
    }

    @Test
    public void shouldThrowExceptionIfCapacityIsNegative() {
        assertThrows(InvalidCapacityException.class, () -> new Parking(-1));
    }

    @Test
    public void shouldNotifyOwnerIfParkingIsFull() {
        Parking parking = new Parking(1);
        Owner owner = new Owner();
        Car car1 = new Car();
        parking.addSubscriber(owner);
        parking.park(car1);
        assertTrue(owner.isParkingFull());
    }

    @Test
    public void shouldNotifyTrafficCopIfParkingIsFull() {
        Parking parking = new Parking(1);
        TrafficCop trafficCop = new TrafficCop();
        Car car1 = new Car();
        parking.addSubscriber(trafficCop);
        parking.park(car1);
        assertTrue(trafficCop.isParkingFull());
    }
    @Test
    public void shouldReturnFalseForOwnerIfParkingIsNotFull() {
        Parking parking = new Parking(2);
        Owner owner = new Owner();
        Car car1 = new Car();
        parking.addSubscriber(owner);
        parking.park(car1);
        assertFalse(owner.isParkingFull());
    }
    @Test
    public void shouldReturnFalseForTrafficCopIfParkingIsNotFull() {
        Parking parking = new Parking(2);
        TrafficCop trafficCop = new TrafficCop();
        Car car1 = new Car();
        parking.addSubscriber(trafficCop);
        parking.park(car1);
        assertFalse(trafficCop.isParkingFull());
    }

    @Test
    public void shouldReturnTrueToOwnerWhenParkingIsAvailable() {
        Parking parking = new Parking(1);
        Owner owner = new Owner();
        Car car1 = new Car();

        parking.addSubscriber(owner);
        parking.park(car1);
        assertTrue(owner.isParkingFull());

        parking.unPark(car1);
        assertFalse(owner.isParkingFull());
    }

    @Test
    public void shouldReturnTrueToTrafficCopWhenParkingIsAvailable() {
        Parking parking = new Parking(2);
        TrafficCop trafficCop = new TrafficCop();
        Car car1 = new Car();

        parking.addSubscriber(trafficCop);
        parking.park(car1);
        assertTrue(trafficCop.isParkingFull());

        parking.unPark(car1);
        assertFalse(trafficCop.isParkingFull());
    }

}
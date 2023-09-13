package org.example;

import org.example.exception.InvalidCapacityException;
import org.example.exception.ParkingSlotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    @Test
    public void shouldReturnTrueWhenPark1Car() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(1, owner1);
        Car car1 = new Car();
        parking.park(car1);
        Boolean isParked = parking.isCarParked(car1);
        assertTrue(isParked);
    }

    @Test
    public void shouldReturnTrueWhenPark2Car() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(2, owner1);
        Car car1 = new Car();
        Car car2 = new Car();
        parking.park(car1);
        parking.park(car2);
        Boolean secondCarParked = parking.isCarParked(car2);
        assertTrue(secondCarParked);
    }

    @Test
    public void shouldReturnFalseIfSlotsAreNotAvailable() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(1, owner1);
        Car car1 = new Car();
        Car car2 = new Car();
        parking.park(car1);
        assertThrows(ParkingSlotFullException.class, () -> parking.park(car2));
    }

    @Test
    public void shouldReturnTrueIfCarIsParked() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(1, owner1);
        Car car1 = new Car();
        parking.park(car1);
        Boolean isParked = parking.isCarParked(car1);
        assertTrue(isParked);
    }

    @Test
    public void shouldReturnFalseIfCarIsNotParked() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(1, owner1);
        Car car1 = new Car();
        Boolean isParked = parking.isCarParked(car1);
        assertFalse(isParked);
    }

    @Test
    public void shouldReturnTrueIfCarIsUnParked() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(1, owner1);
        Car car1 = new Car();
        parking.park(car1);
        Boolean isUnParked = parking.unPark(car1);
        assertTrue(isUnParked);
    }

    @Test
    public void shouldReturnFalseIfCarNotParked() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(1, owner1);
        Car car1 = new Car();
        Boolean isUnParked = parking.unPark(car1);
        assertFalse(isUnParked);
    }

    @Test
    public void shouldReturnFalseWhenSameCarIsParked() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(2, owner1);
        Car car1 = new Car();
        parking.park(car1);
        assertThrows(ParkingSlotFullException.class, () -> parking.park(car1));
    }

    @Test
    public void shouldThrowExceptionIfCapacityIsNegative() {
        Owner owner1 = new Owner1();
        assertThrows(InvalidCapacityException.class, () -> new Parking(-1, owner1));
    }

    @Test
    public void shouldNotifyOwnerIfParkingIsFull() {
        Owner owner1 = new Owner1();
        Parking parking = new Parking(1, owner1);

        Car car1 = new Car();
        parking.park(car1);
    }
}
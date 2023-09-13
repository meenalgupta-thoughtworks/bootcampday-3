package org.example;

import org.example.exception.InvalidCapacityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    @Test
    public void shouldReturnTrueWhenPark1Car() {
        Parking parking = new Parking(1);
        Car car1 = new Car();
        Boolean isParked = parking.park(car1);
        assertTrue(isParked);
    }

    @Test
    public void shouldReturnTrueWhenPark2Car() {
        Parking parking = new Parking(2);
        Car car1 = new Car();
        Car car2 = new Car();
        boolean firstCarParked = parking.park(car1);
        boolean secondCarParked = parking.park(car2);
        assertTrue(secondCarParked);
    }

    @Test
    public void shouldReturnFalseIfSlotsAreNotAvailable() {
        Parking parking = new Parking(1);
        Car car1 = new Car();
        Car car2 = new Car();
        boolean firstCarParked = parking.park(car1);
        boolean secondCarParked = parking.park(car2);
        assertFalse(secondCarParked);
    }

    @Test
    public void shouldReturnTrueIfCarIsParked() {
        Parking parking = new Parking(1);
        Car car1 = new Car();
        parking.park(car1);
        Boolean isParked = parking.isCarParked(car1);
        assertTrue(isParked);
    }

    @Test
    public void shouldReturnFalseIfCarIsNotParked() {
        Parking parking = new Parking(1);
        Car car1 = new Car();
        Boolean isParked = parking.isCarParked(car1);
        assertFalse(isParked);
    }

    @Test
    public void shouldReturnTrueIfCarIsUnParked() {
        Parking parking = new Parking(1);
        Car car1 = new Car();
        parking.park(car1);
        Boolean isUnParked = parking.unPark(car1);
        assertTrue(isUnParked);
    }

    @Test
    public void shouldReturnFalseIfCarNotParked() {
        Parking parking = new Parking(1);
        Car car1 = new Car();
        Boolean isUnParked = parking.unPark(car1);
        assertFalse(isUnParked);
    }

    @Test
    public void shouldReturnFalseWhenSameCarIsParked() {
        Parking parking = new Parking(2);
        Car car1 = new Car();
        parking.park(car1);
        assertFalse(parking.park(car1));
    }

    @Test
    public void shouldThrowExceptionIfCapacityIsNegative() {
        assertThrows(InvalidCapacityException.class, () -> new Parking(-1));
    }
}
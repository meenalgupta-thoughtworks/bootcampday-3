package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    @Test
    public void shouldPark1Car() {
        Parking parking = new Parking(50);

        Boolean isParked = parking.park();

        assertTrue(isParked);
    }

    @Test
    public void shouldPark2Car() {
        Parking parking = new Parking(50);

        boolean firstCarParked = parking.park();
        boolean secondCarParked = parking.park();

        assertTrue(firstCarParked);
        assertTrue(secondCarParked);
    }

}
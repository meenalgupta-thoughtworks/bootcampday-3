package org.example.exception;

public class ParkingSlotFullException extends RuntimeException {
    public ParkingSlotFullException(String s) {
        super(s);
    }
}

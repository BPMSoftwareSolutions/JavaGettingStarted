package com.company;

public abstract class Pilot {
    private Flight currentFlight;

    public void fly(Flight flight) {
        if (canAccept(flight)) {
            currentFlight = flight;
        }
        else {
            handleCantAccept();
        }
    }

    private void handleCantAccept() {
        System.out.println("Cannot accept flight!");
    }

    public abstract boolean canAccept(Flight flight);
}

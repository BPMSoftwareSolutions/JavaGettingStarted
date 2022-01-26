package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Flight implements Comparable<Flight>, Iterable<Passenger> {
    private int passengers;
    private int seats = 150;
    private int flightNumber;
    private char flightClass;
    private static int allPassengers;
    private ArrayList<Passenger> passengerList = new ArrayList<>();
    private boolean[] isSeatAvailable = new boolean[seats];

    {
        for (int i=0; i< isSeatAvailable.length; i++) {
            isSeatAvailable[i] = true;
        }
    }

    public Flight() {
    }

    public Flight(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Flight(char flightClass) {
        this.flightClass = flightClass;
    }

    public void add1Passenger(Passenger passenger) {
        if (passengers < seats) {
            passengerList.add(passenger);
            add1Passenger();
        }
    }

    protected void add1Passenger() {
        if (passengers < seats) {
            passengers += 1;
            allPassengers += 1;
        }
    }

    public static int getAllPassengers() {
        return allPassengers;
    }

    public static void resetAllPassengers() {
        allPassengers = 0;
    }

    public int getPassengers() {
        return passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o))
            return true;

        if (!(o instanceof Flight)) {
            return false;
        }
        return this.flightNumber == ((Flight) o).flightNumber &&
                this.flightClass == ((Flight) o).flightClass;
    }

    @Override
    public int compareTo(Flight flight) {
        return 0;
    }

    @Override
    public Iterator<Passenger> iterator() {
        return passengerList.iterator();
    }

    private class FlightIterable implements Iterable<Passenger> {

        @Override
        public Iterator<Passenger> iterator() {
            Passenger[] passengers = new Passenger[passengerList.size()];
            passengerList.toArray(passengers);
            Arrays.sort(passengers);
            return Arrays.asList(passengers).iterator();
        }
    }
    public Iterable<Passenger> getOrderedPassengers() {
//        FlightIterable orderedPassengers = new FlightIterable();
        return () -> {
            Passenger[] passengers = new Passenger[passengerList.size()];
            passengerList.toArray(passengers);
            Arrays.sort(passengers);
            return Arrays.asList(passengers).iterator();
        };
    }

//
//    @Override
//    public void forEach(Consumer<? super Passenger> action) {
//        Iterable.super.forEach(action);
//    }
//
//    @Override
//    public Spliterator<Passenger> spliterator() {
//        return Iterable.super.spliterator();
//    }
}

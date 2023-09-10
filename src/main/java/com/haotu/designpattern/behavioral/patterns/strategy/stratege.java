package com.haotu.designpattern.behavioral.patterns.strategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 策略模式
 */

interface TripMode {
    void go();
}

class Car implements TripMode {

    @Override
    public void go() {
        System.out.println("开车去");
    }
}

class Train implements TripMode {

    @Override
    public void go() {
        System.out.println("坐火车去");
    }
}

class Airplane implements TripMode {

    @Override
    public void go() {
        System.out.println("坐飞机去");
    }
}

class Trip {
    private TripMode tripMode;

    public Trip(TripMode tripMode) {
        this.tripMode = tripMode;
    }

    public void setTripMode(TripMode tripMode) {
        this.tripMode = tripMode;
    }

    public void go() {
        tripMode.go();
    }
}

public class stratege {
    public static void main(String[] args) {
        Trip trip = new Trip(new Car());
        trip.go();
        trip.setTripMode(new Train());
        trip.go();
        trip.setTripMode(new Airplane());
        trip.go();
        trip.setTripMode(() -> System.out.println("骑自行车去"));
        trip.go();

        Integer[] data = {3, 1, 5, 8, 12, 456, 7, 23};
        Arrays.sort(data, Comparator.comparingInt(o -> -o));
        System.out.println(Arrays.toString(data));
    }
}

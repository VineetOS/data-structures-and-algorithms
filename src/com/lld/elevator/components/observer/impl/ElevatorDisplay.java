package com.lld.elevator.components.observer.impl;

import com.lld.elevator.components.observer.ElevatorObserver;
import com.lld.elevator.constants.ElevatorState;
import com.lld.elevator.entities.Elevator;

public class ElevatorDisplay implements ElevatorObserver {

    @Override
    public void onElevatorStateChange(Elevator elevator, ElevatorState state) {
        System.out.println("Elevator " + elevator.getId() + " is now " + state);
    }

    @Override
    public void onElevatorFloorChange(Elevator elevator, int floor) {
        System.out.println("Elevator " + elevator.getId() + " has arrived at floor " + floor);
    }
}

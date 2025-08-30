package com.lld.elevator.components.observer;

import com.lld.elevator.constants.ElevatorState;
import com.lld.elevator.entities.Elevator;

public interface ElevatorObserver {
    void onElevatorStateChange(Elevator elevator, ElevatorState state);
    void onElevatorFloorChange(Elevator elevator, int floor);
}

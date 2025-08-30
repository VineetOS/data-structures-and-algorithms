package com.lld.elevator.components.scheduling.impl;

import com.lld.elevator.components.request.ElevatorRequest;
import com.lld.elevator.components.scheduling.SchedulingStrategy;
import com.lld.elevator.constants.Direction;
import com.lld.elevator.entities.Elevator;

import java.util.Queue;

public class FCFSSchedulingStrategy implements SchedulingStrategy {

    @Override
    public int getNextStop(Elevator elevator) {
        Direction elevatorDirection = elevator.getDirection();
        int currentFloor = elevator.getCurrentFloor();

        Queue<ElevatorRequest> requests = elevator.getRequests();

        if (requests.isEmpty()) return currentFloor; // No pending requests

        int nextRequestFloor = requests.poll().getFloor();

        if(nextRequestFloor==currentFloor) return currentFloor;

        if(elevatorDirection == Direction.IDLE)
            elevator.setDirection(nextRequestFloor>currentFloor?Direction.UP:Direction.DOWN);
        else if(elevatorDirection == Direction.UP && nextRequestFloor<currentFloor)
            elevator.setDirection(Direction.UP);
        else if (nextRequestFloor > currentFloor)
            elevator.setDirection(Direction.DOWN);

        return nextRequestFloor;
    }
}

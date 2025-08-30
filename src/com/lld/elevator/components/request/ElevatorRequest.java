package com.lld.elevator.components.request;

import com.lld.elevator.components.commands.ElevatorCommand;
import com.lld.elevator.components.controller.ElevatorController;
import com.lld.elevator.constants.Direction;

public abstract class ElevatorRequest implements ElevatorCommand {
    private int elevatorId;
    private int floor;
    private Direction direction;
    private ElevatorController elevatorController;

    public ElevatorRequest(int floor, Direction direction,ElevatorController elevatorController){
        this.floor = floor;
        this.direction = direction;
        this.elevatorController = elevatorController;
    }

    public ElevatorRequest(int floor, ElevatorController elevatorController){
        this.floor = floor;
        this.elevatorController = elevatorController;
    }


    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorController getElevatorController() {
        return elevatorController;
    }
}

package com.lld.elevator.components.controller;

import com.lld.elevator.constants.Direction;
import com.lld.elevator.entities.Elevator;
import com.lld.elevator.entities.Floor;
import com.lld.elevator.components.scheduling.SchedulingStrategy;

import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    private List<Floor> floors;
    private SchedulingStrategy schedulingStrategy;
    private int currentElevatorId;

    public void requestFloor(int floor){

    }

    public void requestElevator(int floor, Direction direction){

    }
}

package com.lld.elevator.components.request.impl;

import com.lld.elevator.components.controller.ElevatorController;
import com.lld.elevator.components.request.ElevatorRequest;
import com.lld.elevator.constants.Direction;

public class ExternalRequest extends ElevatorRequest {

    public ExternalRequest(int floor, Direction direction, ElevatorController elevatorController) {
        super(floor, direction, elevatorController);
    }


    @Override
    public void execute() {
        getElevatorController().requestElevator(getFloor(), getDirection());
    }
}

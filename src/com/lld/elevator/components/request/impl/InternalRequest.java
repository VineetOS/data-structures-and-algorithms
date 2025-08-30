package com.lld.elevator.components.request.impl;

import com.lld.elevator.components.controller.ElevatorController;
import com.lld.elevator.components.request.ElevatorRequest;

public class InternalRequest extends ElevatorRequest {

    public InternalRequest(int floor, ElevatorController elevatorController) {
        super(floor, elevatorController);
    }

    @Override
    public void execute() {
        getElevatorController().requestFloor(getFloor());
    }
}

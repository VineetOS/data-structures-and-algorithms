package com.lld.elevator.components.scheduling;

import com.lld.elevator.entities.Elevator;

public interface SchedulingStrategy {
    int getNextStop(Elevator elevator);
}

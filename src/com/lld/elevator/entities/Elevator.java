package com.lld.elevator.entities;

import com.lld.elevator.components.observer.ElevatorObserver;
import com.lld.elevator.constants.Direction;
import com.lld.elevator.constants.ElevatorState;
import com.lld.elevator.components.request.ElevatorRequest;

import java.util.List;
import java.util.Queue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private Queue<ElevatorRequest> requests;
    private List<ElevatorObserver> observers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public Queue<ElevatorRequest> getRequests() {
        return requests;
    }

    public void setRequests(Queue<ElevatorRequest> requests) {
        this.requests = requests;
    }

    public List<ElevatorObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<ElevatorObserver> observers) {
        this.observers = observers;
    }
}

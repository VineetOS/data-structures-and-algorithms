package com.lld.elevator.components.scheduling.impl;

import com.lld.elevator.components.request.ElevatorRequest;
import com.lld.elevator.components.scheduling.SchedulingStrategy;
import com.lld.elevator.constants.Direction;
import com.lld.elevator.entities.Elevator;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class SCANStrategy implements SchedulingStrategy {

    @Override
    public int getNextStop(Elevator elevator) {
        Direction elevatorDirection = elevator.getDirection();
        int currentFloor = elevator.getCurrentFloor();

        Queue<ElevatorRequest> requests = elevator.getRequests();

        if (requests.isEmpty()) return currentFloor; // No pending requests

        //only go in the current direction first then change direction
        PriorityQueue<ElevatorRequest> upQueue = new PriorityQueue<>((a, b) -> a.getFloor() - b.getFloor());
        PriorityQueue<ElevatorRequest> downQueue = new PriorityQueue<>((a, b) -> b.getFloor() - a.getFloor());

        //categorize requests based on current floor
        while (!requests.isEmpty()){
            ElevatorRequest request = requests.poll();
            if(request.getFloor() == currentFloor) return currentFloor;
            if(request.getFloor() > currentFloor) upQueue.offer(request);
            else downQueue.offer(request);
        }

        //handle case where elevator is IDLE - by default go up
        //enhancement: can check which queue is larger and go in that direction
        if(elevatorDirection == Direction.IDLE){
            if(!upQueue.isEmpty() && !downQueue.isEmpty()){
                if(upQueue.peek().getFloor() - currentFloor <= currentFloor - downQueue.peek().getFloor()){
                    elevator.setDirection(Direction.UP);
                    return Objects.requireNonNull(upQueue.poll()).getFloor();
                } else {
                    elevator.setDirection(Direction.DOWN);
                    return Objects.requireNonNull(downQueue.poll()).getFloor();
                }
            }
            else if(!upQueue.isEmpty()){
                elevator.setDirection(Direction.UP);
                return upQueue.poll().getFloor();
            } else if (!downQueue.isEmpty()) {
                elevator.setDirection(Direction.DOWN);
                return downQueue.poll().getFloor();
            } else {
                return currentFloor; // No pending requests
            }
        }

        //handle movement in upward direction
        if(elevatorDirection == Direction.UP){
            return !upQueue.isEmpty() ? Objects.requireNonNull(upQueue.poll()).getFloor() :
                    switchDirection(elevator, downQueue, Direction.DOWN);
        }else{
            return !downQueue.isEmpty() ? Objects.requireNonNull(downQueue.poll()).getFloor() :
                    switchDirection(elevator, upQueue, Direction.UP);
        }
    }

    private int switchDirection(Elevator elevator, PriorityQueue<ElevatorRequest> queue, Direction newDirection){
        if(queue.isEmpty()) {
            elevator.setDirection(Direction.IDLE);
            return elevator.getCurrentFloor();
        }
        elevator.setDirection(newDirection);
        return Objects.requireNonNull(queue.poll()).getFloor();
    }
}

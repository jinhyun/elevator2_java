package main.java.elevator.domain;

/**
 * Created by Jinhyun on 2015. 1. 22..
 */
public class Elevator {
    int MaxFloor = 20;
    int srcFloor = 1;

    public String[] destFloorList = new String[MaxFloor+1];

    public int getSrcFloor() {
        return srcFloor;
    }

    public void setSrcFloor(int srcFloor) {
        this.srcFloor = srcFloor;
    }
}

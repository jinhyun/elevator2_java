package main.java.elevator.domain;

/**
 * Created by Jinhyun on 2015. 1. 22..
 */
public class Elevator {
    int MaxFloor = 20;
    int srcFloor = 11;

    public String[] destFloorList = new String[MaxFloor+1];

    public int getSrcFloor() {
        return srcFloor;
    }

    public void setSrcFloor(int srcFloor) {
        this.srcFloor = srcFloor;
    }

    public String[] getDestFloorList() {
        return destFloorList;
    }

    public void setDestFloorList(int destFloorNumber) {
        this.destFloorList[destFloorNumber] = "on";
    }

    public void initDestFloorList(){
        this.destFloorList = new String[MaxFloor+1];
    }
}

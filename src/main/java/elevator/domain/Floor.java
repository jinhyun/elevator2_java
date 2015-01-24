package main.java.elevator.domain;

import java.util.*;


/**
 * Created by Jinhyun on 2015. 1. 22..
 */
public class Floor {
    int MaxFloor = 20;
    String[] reqFloorNumberList = new String[MaxFloor+1];

    public void setReqFloorNumberList(int reqFloorNumber) {
        this.reqFloorNumberList[reqFloorNumber] = "on";
    }

    public String[] getReqFloorNumberList(){
        return reqFloorNumberList;
    }
}

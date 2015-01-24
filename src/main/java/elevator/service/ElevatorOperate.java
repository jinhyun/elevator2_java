package main.java.elevator.service;

import main.java.elevator.domain.Elevator;
import main.java.elevator.domain.Floor;

/**
 * Created by Jinhyun on 2015. 1. 22..
 */
public class ElevatorOperate {
    private Elevator elevator = new Elevator();
    private Floor floor = new Floor();

    public void callElevator(int reqFloorNumber){
        floor.setReqFloorNumberList(reqFloorNumber);
    }

    public void pushNumber(int number) {
        elevator.destFloorList[number] = "on";
    }

    public boolean isNotNullStrOn(String[] strArray, int i){
        if (strArray[i] != null && strArray[i].equals("on")){
            return true;
        } else {
            return false;
        }
    }

    public void goUpDownElevator(ElevatorOperate elevatorOperate) {
        String[] evDestFloorList = elevator.destFloorList;
        int evSrcFloor = elevator.getSrcFloor();
        int evLastDestFloor = 1;

        for (int i=1; i<evDestFloorList.length; i++){
            if (isNotNullStrOn(evDestFloorList, i)){
                evLastDestFloor = i;
            }
        }

        try {
            for (int i=evSrcFloor; i<=evLastDestFloor; i++) {
                System.out.println(i + "층");
                Thread.sleep(200);

                if (isNotNullStrOn(floor.getReqFloorNumberList(),i)
                        || isNotNullStrOn(evDestFloorList, i)){
                    System.out.println(i + "층에 도착했습니다.");
                    Thread.sleep(1000);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
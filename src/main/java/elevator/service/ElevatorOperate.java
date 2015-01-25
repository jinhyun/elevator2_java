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
        elevator.setDestFloorList(number);
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
        boolean isGoUp = false;
        boolean isGoDown = false;

        /*
         * 올라가야하는지 내려가야하는지 검증 로직
         */
        for (int i=1; i<evDestFloorList.length; i++){
            if (isNotNullStrOn(evDestFloorList, i)){
                if (evSrcFloor < i){
                    // up
                    isGoUp = true;
                    break;

                } else if (evSrcFloor > i){
                    // down
                    isGoDown = true;
                    break;

                } else {
                    // stop
                }
            };
        }

        if (isGoUp) {
            System.out.println("올라갑니다");
            for (int i = 1; i < evDestFloorList.length; i++) {
                if (isNotNullStrOn(evDestFloorList, i)) {
                    evLastDestFloor = i;
                }
            }

            try {
                for (int i = evSrcFloor; i <= evLastDestFloor; i++) {
                    System.out.println(i + "층");
                    Thread.sleep(200);

                    if (isNotNullStrOn(floor.getReqFloorNumberList(), i)
                            || isNotNullStrOn(evDestFloorList, i)) {
                        System.out.println(i + "층에 도착했습니다.");
                        Thread.sleep(1000);

                    }

                /*
                 * 초기화 로직
                 * 내려갈경우, 내려가야하는 로직은 제외후 초기화
                 */
                    if (i == evLastDestFloor) {
                        floor.initReqFloorNumberList();     //TODO: up/down 분리필요
                        elevator.initDestFloorList();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (isGoDown){
            System.out.println("내려갑니다");
            for (int i = evDestFloorList.length-1; i >= 1; i--) {
                if (isNotNullStrOn(evDestFloorList, i)) {
                    evLastDestFloor = i;
                }
            }

            try {
                for (int i = evSrcFloor; i >= evLastDestFloor; i--) {
                    System.out.println(i + "층");
                    Thread.sleep(200);

                    if (isNotNullStrOn(floor.getReqFloorNumberList(), i)
                            || isNotNullStrOn(evDestFloorList, i)) {
                        System.out.println(i + "층에 도착했습니다.");
                        Thread.sleep(1000);

                    }

                    if (i == evLastDestFloor) {
                        floor.initReqFloorNumberList();     //TODO: up/down 분리필요
                        elevator.initDestFloorList();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
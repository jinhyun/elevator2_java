package test;

/**
 * Created by Jinhyun on 2015. 1. 17..
 */
class ElevatorOperate implements Runnable {
    private Thread thread;
    String threadName = "";

    Elevator elevator = new Elevator();

    int reqFloorNumber;

    public int getReqFloorNumber() {
        return reqFloorNumber;
    }

    public void setReqFloorNumber(int reqFloorNumber) {
        this.reqFloorNumber = reqFloorNumber;
    }

    ElevatorOperate (String name){
        threadName = name;
        System.out.println("Creating" + threadName);
    }

    @Override
    public void run(){
        System.out.println("Running" + threadName);

        try {
            goUpDownElevator(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Starting" + threadName);
        if (thread == null){
            thread = new Thread (this, threadName);
            thread.start();
        }
    }

    public void pushFloorNumber(int number) {
        elevator.destFloorList[number] = "on";
    }

    public boolean isReqFloor(ElevatorOperate elevatorOperate, int i){
        if (elevatorOperate.getReqFloorNumber() == i){
            return true;
        } else {
            return false;
        }
    }

    public boolean isEvDestFloor(String[] destFloorList, int i){
        if (destFloorList[i] != null && destFloorList[i].equals("on")){
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
            if (evDestFloorList[i]!=null && evDestFloorList[i].equals("on")) {
                evLastDestFloor = i;
            }
        }

        try {
            for (int i=evSrcFloor; i<=evLastDestFloor; i++) {
                System.out.println(i + "층");
                Thread.sleep(200);

                if (isReqFloor(elevatorOperate, i)
                        || isEvDestFloor(evDestFloorList, i)) {
                    System.out.println(i + "층에 도착했습니다.");
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Elevator {
    int MaxFloor = 20;
    String[] destFloorList = new String[MaxFloor+1];
    int srcFloor = 1;

    public int getSrcFloor() {
        return srcFloor;
    }

    public void setSrcFloor(int srcFloor) {
        this.srcFloor = srcFloor;
    }
}

public class TestElevatorOperate {
    /*
     * [v] 사용자가 엘리베이터에서 특정층을 누른다 (10층)
     * [v] 엘리베이터가 올라간다 (1층 > 10층)
     * [v] 사용자가 오름버튼을 누른다 (4층)
     * [v] 엘리베이터가 요청이 있는 층에서 멈춘다 (4층)
     * [v] 사용자가 특정층을 누른다 (8층)
     * [v] 엘리베이터가 특정층에서 멈춘다 (8층)
     * [v] 엘리베이터가 특정층에서 멈춘다 (10층)
     */
    public static void main(String args[]) {
        ElevatorOperate elevatorOperate = new ElevatorOperate("1호기");
        elevatorOperate.pushFloorNumber(10);
        elevatorOperate.start();

        try {
            elevatorOperate.setReqFloorNumber(4);
            elevatorOperate.pushFloorNumber(8);
        } catch (Exception e){

        }
    }
}
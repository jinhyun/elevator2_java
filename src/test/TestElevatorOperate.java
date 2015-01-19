package test;

import org.junit.Test;

/**
 * Created by Jinhyun on 2015. 1. 17..
 */
class ElevatorOperate implements Runnable {
    private Thread thread;
    String threadName = "";

    Elevator elevator = new Elevator();

    int reqFloorNumber;
    boolean isPushUpBtn = false;

    public boolean isPushUpBtn() {
        return isPushUpBtn;
    }

    public void setPushUpBtn(boolean isPushUpBtn) {
        this.isPushUpBtn = isPushUpBtn;
    }

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
        elevator.floorNumberList[number] = "on";
    }

    public void goUpDownElevator(ElevatorOperate elevatorOperate) {
        String[] floorNumberList = elevator.floorNumberList;
        int srcFloorNumber = elevator.getSrcFloorNumber();
        int destFloorNumber = elevator.getDestFloorNumber();

        for (int i = 0; i < floorNumberList.length; i++) {
            // 엘리베이터에서 버튼이 눌려있는 층수
            if (floorNumberList[i] != null && floorNumberList[i].equals("on")) {
                destFloorNumber = i;
            }
        }

        // 엘리베이터 층수보다 대상 층수가 큰 경우, up
        if (srcFloorNumber < destFloorNumber) {
            for (int j = srcFloorNumber; j <= destFloorNumber; j++){
                int reqFloorNumber = elevatorOperate.getReqFloorNumber();
                boolean isPushUpBtn = elevatorOperate.isPushUpBtn();

                try {
                    if (reqFloorNumber == j && isPushUpBtn){
                        System.out.println(reqFloorNumber + "층에서 잠시 멈춥니다.");
                        Thread.sleep(1000);
                        continue;
                    }

                    Thread.sleep(250);
                    System.out.println("엘리베이터: " + j + "층");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        // 엘리베이터 층수보다 대상 층수가 작은 경우, down
        } else if (srcFloorNumber >= destFloorNumber) {


        // 동일한 경우, stop
        } else {

        }
    }

    public void pushFloorUpBtn(){

    }

    public void stopElevator(){

    }
}

class Elevator {
    String[] floorNumberList = new String[11];  // TODO: 추후 변경
    int srcFloorNumber = 1;
    int destFloorNumber = 1;

    public int getSrcFloorNumber() {
        return srcFloorNumber;
    }

    public void setSrcFloorNumber(int srcFloorNumber) {
        this.srcFloorNumber = srcFloorNumber;
    }

    public int getDestFloorNumber() {
        return destFloorNumber;
    }

    public void setDestFloorNumber(int destFloorNumber) {
        this.destFloorNumber = destFloorNumber;
    }
}

public class TestElevatorOperate {
    /*
     * [v] 사용자가 엘리베이터에서 특정층을 누른다 (10층)
     * [v] 엘리베이터가 올라간다 (1층 > 10층)
     * [v] 사용자가 오름버튼을 누른다 (7층)
     * [v] 엘리베이터가 요청이 있는 층에서 멈춘다 (7층)
     * [v] 엘리베이터가 올라간다 (10층)
     */
    public static void main(String args[]) {
        ElevatorOperate elevatorOperate = new ElevatorOperate("1호기");
        elevatorOperate.pushFloorNumber(10);
        elevatorOperate.start();

        try {
            Thread.sleep(1000);
            elevatorOperate.setReqFloorNumber(7);
            elevatorOperate.setPushUpBtn(true);
            elevatorOperate.start();

        } catch (Exception e){

        }
    }

    @Test
    public void unitTest(){     // error
        ElevatorOperate elevatorOperate = new ElevatorOperate("1호기");
        elevatorOperate.pushFloorNumber(10);
        elevatorOperate.start();
    }
}
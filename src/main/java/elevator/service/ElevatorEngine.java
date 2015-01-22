package main.java.elevator.service;

/**
 * Created by Jinhyun on 2015. 1. 22..
 */
public class ElevatorEngine implements Runnable {
    ElevatorOperate elevatorOperate = new ElevatorOperate();

    public ElevatorEngine(ElevatorOperate evOperate){
        elevatorOperate = evOperate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            elevatorOperate.goUpDownElevator(elevatorOperate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

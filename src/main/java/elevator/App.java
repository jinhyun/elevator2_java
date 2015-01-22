package main.java.elevator;

import main.java.elevator.service.ElevatorEngine;
import main.java.elevator.service.ElevatorOperate;

/**
 * Created by Jinhyun on 2015. 1. 17..
 */
public class App {
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
        try {
            ElevatorOperate elevatorOperate = new ElevatorOperate();
            elevatorOperate.pushNumber(10);

            ElevatorEngine elevatorEngine = new ElevatorEngine(elevatorOperate);
            Thread thread = new Thread(elevatorEngine);
            thread.start();

            elevatorOperate.callElevator(4);
            elevatorOperate.pushNumber(8);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
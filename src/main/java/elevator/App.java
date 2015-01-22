package main.java.elevator;

import main.java.elevator.service.ElevatorEngine;
import main.java.elevator.service.ElevatorOperate;

/**
 * Created by Jinhyun on 2015. 1. 17..
 */
public class App {
    /*
     * [v] 1층 엘리베이터에서 사용자가 10층을 누른다 (A)
     * [v] 4층에서 사용자가 오름버튼을 누른다 (B)
     * [v] 엘리베이터가 4층에서 멈춘다 (B_Ev)
     * [v] 엘리베이터에서 사용자가 8층을 누른다 (B)
     * [v] 엘리베이터가 8층에서 멈춘다 (B_Ev)
     * [] 9층에서 사용자가 오름버튼을 누른다 (C)
     * [] 엘리베이터가 9층에서 멈춘다 (C_Ev)
     * [] 엘리베이터에서 사용자가 12층을 누른다 (C)
     * [v] 엘리베이터가 10층에서 멈춘다 (A_Ev)
     * [] 엘리베이터가 12층에서 멈춘다 (C_Ev)
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
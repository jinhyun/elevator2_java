package test;

import org.junit.Test;

/**
 * Created by Jinhyun on 2015. 1. 17..
 */
class ElevatorOperate implements Runnable {
    private Thread thread = new Tread();
    String threadName = "";

    ElevatorOperate (String name){
        threadName = name;
        System.out.println("Creating" + threadName);
    }

    public void run(){
        System.out.println("Running" + threadName);

    }

    public void start() {
        System.out.println("Starting" + threadName);
        thread.start();
    }
}

public class TestElevatorOperate {
    /*
     * [] 사용자가 엘리베이터에서 특정층을 누른다 (10층)
     * [] 엘리베이터가 올라간다 (1층 > 10층)
     * [] 사용자가 오름버튼을 누른다 (5층)
     * [] 엘리베이터가 요청이 있는 층에서 멈춘다 (5층)
     * [] 엘리베이터가 올라간다 (10층)
     */
    @Test
    public void pushFloorNumber() {

    }

    @Test
    public void goUpDownElevator() {

    }

    @Test
    public void pushFloorUpBtn(){

    }

    @Test
    public void stopElevator(){

    }
}

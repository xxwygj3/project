package com.sbtest.projectjdbc.test.queue;

/**
 * 负责跟踪顾客抵达售票口的时间和顾客买票后离开售票口的时间。
 * 顾客买票所花的总时间就是抵达时间与离开时间之差。
 * 为简化起见，模拟中的时间用逝去的秒数来度量，因此时间可以被存储为一个整数，模拟从时间0开始
 */
public class Customer {
    private int arrivalTime,departureTime;
    public Customer(int arrives){
        this.arrivalTime = arrives;
        this.departureTime = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int totalTime(){
        return departureTime - arrivalTime;
    }
}

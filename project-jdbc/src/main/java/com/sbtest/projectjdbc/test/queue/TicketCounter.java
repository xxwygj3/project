package com.sbtest.projectjdbc.test.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 售票口模拟
 * 只排一队，而且先到的人先得到服务（这是一个队列）。
 * 平均每隔15秒就会来一位顾客。
 * 如果有空闲的售票口，在顾客抵达之时就会马上开始处理。
 * 从顾客来到售票口到处理完顾客请求、让顾客持票进影院，这个过程平均需要2分钟（120秒）
 * 模拟将创建一个顾客队列，接着观察如果仅有一个售票口，处理这些顾客的购票需要多长时间。
 * 然后再考虑两个售票口时，处理同样的顾客队列需要多长时间。接着再考虑3个售票口。
 * 继续这一过程，直到达到10个售票口。
 * 最后，比较每位顾客所需的平均处理时间。
 */
public class TicketCounter {
    final static int PROCESS = 120;
    final static int MAX_CASHIERS = 10;
    final static int NUM_CUSTOMERS = 100;

    public static void main(String[] args) {
        Customer customer;
        Queue<Customer> customerQueue = new LinkedList<Customer>();
        int[] cashierTime = new int[MAX_CASHIERS];
        int totalTime, averageTime, departs, start;
        for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {
            for (int count = 0; count < cashiers; count++) {
                cashierTime[count] = 0;
            }
            for (int count = 1; count <= NUM_CUSTOMERS; count++) {
                customerQueue.add(new Customer(count * 15));//每隔15秒来一位顾客
            }
            totalTime = 0;

            while (!customerQueue.isEmpty()) {
                for (int count = 0; count <= cashiers; count++) {
                    if (!customerQueue.isEmpty()) {
                        customer = customerQueue.remove();
                        if (customer.getArrivalTime() > cashierTime[count]) {
                            start = customer.getArrivalTime();
                        } else {
                            start = cashierTime[count];
                        }
                        departs = start + PROCESS;
                        customer.setDepartureTime(departs);
                        cashierTime[count] = departs;
                        totalTime += customer.totalTime();
                    }
                }
            }
            averageTime = totalTime/NUM_CUSTOMERS;
            System.out.println("Number of cashiers: "+(cashiers+1));
            System.out.println("Average time: "+ averageTime+"\n");
        }
    }
}

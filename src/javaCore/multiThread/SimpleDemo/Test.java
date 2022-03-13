package javaCore.multiThread.SimpleDemo;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread t1 = new Thread(()->demo.demo1());
        Thread t2 = new Thread(()->demo.demo2());
        t2.start();
        t1.start();
    }
}

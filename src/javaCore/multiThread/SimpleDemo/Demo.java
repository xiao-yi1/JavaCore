package javaCore.multiThread.SimpleDemo;

public class Demo {

    public void demo1() {
         synchronized (this) {
             while (true) {  //死循环目的是为了让线程一直持有该锁
                 System.out.println(Thread.currentThread()+"demo1");

            }

        }

    }
    public void demo2() {
         synchronized (this) {
             while (true) {
                 System.out.println(Thread.currentThread()+"demo2");

            }

        }

    }

}

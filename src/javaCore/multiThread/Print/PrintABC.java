package javaCore.multiThread.Print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    ReentrantLock lock = new ReentrantLock();
    volatile int status = 0;
    Condition A = lock.newCondition();
    Condition B = lock.newCondition();
    Condition C = lock.newCondition();
    void printA(){
        while(true){
            lock.lock();
            try {
                while(status!=0)A.await();
                System.out.println("A");
                status = 1;
                B.signal();
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

    }
    void printB(){
        while (true){
            lock.lock();
            try {
                while(status!=1)B.await();
                System.out.println("B");
                status = 2;
                C.signal();
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

    }
    void printC(){
        while (true){
            lock.lock();
            try {
                while(status!=2)C.await();
                System.out.println("C");
                status = 0;
                A.signal();
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

    }
    public static void main(String[] args){
        PrintABC printABC = new PrintABC();
        new Thread(()->{
            printABC.printA();
        }).start();
        new Thread(()->{
             printABC.printB();
        }).start();
        new Thread(()->{

             printABC.printC();


        }).start();
    }
}

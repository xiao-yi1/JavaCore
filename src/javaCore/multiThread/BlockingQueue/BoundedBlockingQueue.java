package javaCore.multiThread.BlockingQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {
    Deque<Integer> list = new LinkedList<>();
    int capacity = 0;
    private ReentrantLock lock = new ReentrantLock();
    Condition produce = lock.newCondition();
    Condition consumer = lock.newCondition();
    AtomicInteger size = new AtomicInteger(0);
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try{
            while(size.get()>=capacity)produce.await();
            list.addFirst(element);
            size.incrementAndGet();
            consumer.signal();
        }finally{
            lock.unlock();
        }


    }
    public int dequeue() throws InterruptedException {
        lock.lock();

        try{
            while(size.get()==0){
                consumer.await();
            }
            int res=list.removeLast();
            size.decrementAndGet();
            produce.signal();
            return res;
        }finally{
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try{
           return size.get();
        }finally{
            lock.unlock();
        }
    }
}

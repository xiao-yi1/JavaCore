package javaCore.multiThread.TestLock;

public class TestSynchronized {
    public synchronized void m1() throws InterruptedException {
        System.out.println("m1");
        m2();
        Thread.sleep(20000);
    }
    public synchronized void m2(){
        System.out.println("m2");
    }

    public static void main(String[] args) {
        TestSynchronized test = new TestSynchronized();
        new Thread(()->{
            try {
                test.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        new Thread(()->{
//            test.m2();
//        }).start();
    }
}

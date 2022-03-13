package javaCore.multiThread.Interrupt;

public class InterruptDemo {

    static class MyThread implements Runnable {
        @Override
        public void run() {
//            for (int i= 0; !Thread.currentThread().isInterrupted() && i < 200000; i++) {
//                System.out.println(Thread.currentThread().getName() + "：i = " + i);
//            }
            try {
                Thread.sleep(20000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new MyThread());
        myThread.start();

        // 让线程运行一段时间
        Thread.sleep(1000);

//        myThread.interrupt();

        // 等待 myThread 运行停止
        myThread.interrupt();
        System.out.println("end");
    }

}

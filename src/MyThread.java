import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
    AtomicInteger res;
    MyThread(AtomicInteger res){
        this.res = res;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++)
        System.out.println(res.getAndIncrement());
    }
}

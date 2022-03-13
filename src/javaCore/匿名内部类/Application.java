package javaCore.匿名内部类;

public class Application{
    public static void main(String Args[]){
        HelloMachine machine=new HelloMachine();
        //用lamda表达式填充接口实例
        machine.turnOn(()->{
                    System.out.println("hello");
                });
        //直接构造一个接口的实例类，重写方法
        machine.turnOn(new SpeakHello(){
            public void speak(){
                System.out.println("hello,you are welcome!");
            }
        });
        machine.turnOn(new SpeakHello(){
            public void speak(){
                System.out.println("你好，欢迎光临！");
            }
        });
    }
}

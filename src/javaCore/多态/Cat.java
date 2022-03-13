package javaCore.多态;

public class Cat extends Animal{

    int num = 20;
    //重写
    public void eat(){
        System.out.println("猫吃猫粮");
    }

    //Cat特有的方法
    public void move(){
        System.out.println("猫走路很轻盈！");
    }

}

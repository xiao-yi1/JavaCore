package javaCore.多态;

public class AnimalTest01{

//    public static void main(String[] args){
//
//        Cat c1 = new Cat();
//        c1.eat();
//
//        Animal a1 = new Cat();//父类引用指向子类对象，我指着这只猫说这是一只动物
//        a1.eat();//会调用Cat中重写的eat方法
//        System.out.println(a1.num);//因为成员变量不存在重写，所以结果是10
//    }
public static void main(String[] args) {


        Animal a1 = new Cat();//父类引用指向子类对象
        //如果要是想执行Cat里面的move方法该怎么办？
        //只能强制类型转换,需要加强制类型转换符
        Cat c1 = (Cat)a1;
        c1.move();

        Animal a2 = new Dog(); //向上转型.
        //强制类型转换
        Cat c2 = (Cat)a2; //会报错 java.lang.ClassCastException


}
}

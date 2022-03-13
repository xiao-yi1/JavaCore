package javaCore.lamda;


import javax.swing.*;

public class TimedGreeter extends Greeter{
    public void greet(){
        Timer t = new Timer(1000,super::greet);
        t.start();
    }

    public static void main(String[] args) {
        TimedGreeter timedGreeter = new TimedGreeter();
        timedGreeter.greet();
    }
}

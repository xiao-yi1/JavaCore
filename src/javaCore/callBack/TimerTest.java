package javaCore.callBack;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TimerTest {

    public static void main(String[] args) {
        ActionListener actionListener = new TimePrinter();
        Timer t = new Timer(3000,actionListener);
        t.start();
    }
}

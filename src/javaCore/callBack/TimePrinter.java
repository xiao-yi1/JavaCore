package javaCore.callBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("the time is"+new Date());
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) {
        TimePrinter t1 = new TimePrinter();
    }


}

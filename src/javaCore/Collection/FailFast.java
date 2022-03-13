package javaCore.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
        Iterator<String> it = list.iterator();
        int i = 0 ;
        while(it.hasNext()) {
            if (i == 3) {
                it.remove(); //迭代器的remove()方法
            }
            System.out.println(it.next());
            i ++;
        }
        System.out.println(list);
    }

}

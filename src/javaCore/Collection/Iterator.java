package javaCore.Collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class Iterator {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap(){
            {
                put("A",1);
                put("B",2);
                put("C",3);
            }
        };
        java.util.Iterator it = map.entrySet().iterator();
        for(;it.hasNext();){
            Map.Entry<String,Integer> item =(Map.Entry<String,Integer>)it.next();
            System.out.println(item.getKey()+":"+item.getValue());
        }







    }
}
